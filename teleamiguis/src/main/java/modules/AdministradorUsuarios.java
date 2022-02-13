/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gyron
 */
public class AdministradorUsuarios {
   
       
        private Connection conn;
        
        public AdministradorUsuarios() throws IOException, SQLException {
            conn = getConnection();
        
        }
    
        public static Connection getConnection() throws FileNotFoundException, IOException{
        Connection conn = null;
        Properties properties= new Properties();
        properties.load(new FileInputStream(new File("./src/main/resources/properties/credenciales.properties")));
        
        try {
          conn = DriverManager.getConnection((String) properties.get("JDBC"),(String) properties.get("USUARIO"),(String) properties.get("CLAVE"));
          conn.setAutoCommit(false);
          return conn;
        }
        catch (SQLException e) {
          System.out.println("Error de conexión: " + e.getMessage());
          System.exit(4);
        }
        return null;
    }
        
        
     
    // Consulta de usuario (trabajadores)
    public String[] mostrarUsuario(String id,String tipoid) throws SQLException
    {
        //Realizacion del query 
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery("SELECT * FROM trabajadores WHERE id_trabajador = '"+id+"' and tipo_identificacion = '"+tipoid+"' ");


         String arr[]= new String[8];


         if (result.next()){
                   for(int i = 0; i<8;i++){
                                    if (i != 7){
                                             arr[i] = result.getString(i+1);
                                    } else {
                                             //true --> Activo / false --> Inactivo
                                             if (true == result.getBoolean(8)){
                                                  arr[i] = "ACTIVO";
                                             } else {
                                                      arr[i] = "INACTIVO";
                                              }
                                    }
                           }
        } 
        


/*        for(int j =0; j <8;j++){
            System.out.println(arr[j]);
         }*/

        
        return arr;
    }
    // retorna una arreglo de strings de nombres e id de trabajadores;
    public ArrayList<String[]>  mostrarListaUsuarios() throws SQLException
    {
        //Realizacion del query 
         Statement stmt = conn.createStatement();
         ResultSet result = stmt.executeQuery("SELECT * FROM trabajadores");


         ArrayList<String[]> usuarios= new ArrayList<String[]>();

         while (result.next()) {
        
            String aux[]= new String[3];
            aux[0]=result.getString("nombre");
            aux[1]= result.getString("id_trabajador");
            aux[2]= result.getString("tipo_identificacion");
            usuarios.add(aux);
        
         }         
        return usuarios;
    }
    
   



   public int registrarUsuario(String id, String tipoI, String cargo, String nombre, String direccion, String telefono,String correo, boolean estado ) throws IOException, SQLException
    {
        int confirmacion = 0;
         if (id.matches("-?\\d+(\\.\\d+)?") && telefono.matches("-?\\d+(\\.\\d+)?")) {
             PreparedStatement stm;
             

             // Preparando el statement de la tabla trabajadores
             String sql = "INSERT INTO trabajadores (id_trabajador, tipo_identificacion, cargo, nombre, direccion, telefono, correo, estado) VALUES (?,?,?,?,?,?,?,?)";
             stm = conn.prepareStatement(sql);

             stm.setString(1, id);
             stm.setString(2, tipoI);
             stm.setString(3, cargo);
             stm.setString(4, nombre);
             stm.setString(5, direccion);
             stm.setString(6, telefono);
             stm.setString(7, correo);
             stm.setBoolean(8, estado);

             //envviando el query INSERT trabajadores
             confirmacion = stm.executeUpdate();
             conn.commit();

             //Preparando las varibales del stament de usuario
             String usr = id;
             String tipoU = tipoI;
             String pass = "";

             //Generando la contraseña
             pass = pass + nombre.charAt(0);
             pass = pass + id.substring(0, 4);

             //Preparando el statement de la tabla usuarios
             sql = "INSERT INTO usuarios (id_trabajador,tipo_identificacion,contraseña) VALUES (?,?,?)";
             stm = conn.prepareStatement(sql);

             stm.setString(1, usr);
             stm.setString(2, tipoU);
             stm.setString(3, pass);

             //Enviando el query INSERT usuarios
             stm.executeUpdate();
             conn.commit();
         }else {
            confirmacion = -1;
        }
        
        return confirmacion;
    }
    
   
   // Funcion para cambiar el estado de un trabajador en el sistema (true -> ACTIVO, false -> INACTIVO). La función recibe como parametro
   // el id (cedula) del usuario. 
    public int cambiaEstadoUsuario(String id, String tipoid,String status) throws SQLException
    {
        PreparedStatement stm;
        int confirmacion;
        // Escribimos el Query
        String inhabQuery =   "UPDATE trabajadores  SET  estado = CAST( ? AS boolean ) WHERE id_trabajador = ? AND tipo_identificacion = ?";
        stm=conn.prepareStatement(inhabQuery);
        
        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setString(1, status); 
        stm.setString(2, id); 
        stm.setString(3, tipoid); 
        
        //Ejecutamos la sentencia
        confirmacion= stm.executeUpdate ();
        conn.commit();
        return confirmacion;
    }
    
//    Funcion para ejecutar un update a un usuario en la DB, este metodo recibe un arreglo con los datos del usuario en el siguiente orden:
//    cargo, nombre, direccion, telefono, correo,  id_trabajador ";
      public int modificarUsuario(String[] atributos) throws SQLException
    {
        int confirmacion;
        if (atributos[3].matches("-?\\d+(\\.\\d+)?")) {
            PreparedStatement stm;

            String sql = "UPDATE trabajadores  SET  cargo=?, nombre=?, direccion=?, telefono=?, correo=? WHERE id_trabajador = ? AND tipo_identificacion = ?";
            stm = conn.prepareStatement(sql);
            //Recorrer todo el arreglo de atributos para insertarlos en la secuencia SQL
            for (int i = 1; i <= atributos.length; i++) {
                //System.out.println(atributos[i-1]);
                stm.setString(i, atributos[i - 1]);
            }
            //Ejecutar la sentencia                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
            confirmacion = stm.executeUpdate();
            conn.commit();
            //System.out.println(confirmacion);
            //System.out.println(atributos[5]);
        }else {
            confirmacion = -1;
        }
        return confirmacion;
    }
      
     public void cerrarConexion(String idUsuario, String tipoidUsuario) throws SQLException {
         
         PreparedStatement stm;
         stm = conn.prepareStatement("UPDATE usuarios  SET  isactive = false WHERE id_trabajador = '" + idUsuario+ "' and tipo_identificacion = '" + tipoidUsuario+ "' ");
         stm.executeUpdate();
         conn.commit();

         conn.close();
     }
     


public static void main(String args[]) throws SQLException, IOException {
      AdministradorUsuarios prueba = new AdministradorUsuarios();
      prueba.mostrarUsuario("1190512015","C.C");
    }
}
