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
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author gyron
 */
public class administradorUsuarios {
   
       
        private Connection conn;
        
        public administradorUsuarios() throws IOException, SQLException {
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
        
        
     
      
    public String mostrarUsuarios()
    {
        String confirmacion="";
        
        return confirmacion;
    }
    
    public String registrarUsuario()
    {
        
        String confirmacion="";
        
        return confirmacion;
    }
    
    public String inhabilitarUsuario()
    {
        String confirmacion="";
        
        return confirmacion;
    }
    
//    Funcion para ejecutar un update a un usuario en la DB, este metodo recibe un arreglo con los datos del usuario en el siguiente orden:
//    tipo_identificacio, cargo, nombre, direccion, telefono, correo,  id_trabajador ";
      public int modificarUsuario(String[] atributos) throws SQLException
    {

        PreparedStatement stm;
        int confirmacion;
        String sql =   "UPDATE trabajadores  SET  tipo_identificacion=?, cargo=?, nombre=?, direccion=?, telefono=?, correo=? WHERE id_trabajador = ?";
        stm=conn.prepareStatement(sql);
        //Recorrer todo el arreglo de atributos para insertarlos en la secuencia SQL
        for (int i = 1; i<=atributos.length; i++){
            System.out.println(atributos[i-1]);
            stm.setString(i,atributos[i-1]);
        }
        //Ejecutar la sentencia                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        confirmacion=stm.executeUpdate ();   
        conn.commit();
        return confirmacion;
    }
}
