/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author gyron
 */
public class OperadorClientes {
    
        private Connection conn;

    public OperadorClientes() throws IOException, SQLException {
        conn = getConnection();

    }

    public static Connection getConnection() throws FileNotFoundException, IOException {
        Connection conn = null;
        Properties properties = new Properties();
        properties.load(new FileInputStream(
                new File("./src/main/resources/properties/credenciales.properties")));

        try {
            conn = DriverManager.getConnection((String) properties.get("JDBC"),
                    (String) properties.get("USUARIO"), (String) properties.get("CLAVE"));
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }
        return null;
    }
    
    
    public int registrarPago(String[] atributos) throws IOException, SQLException {
        int confirmacion = 0;
        
        String [] datos = mostrarFactura(Integer.parseInt(atributos[0]));
        
        for(int j =0; j <2;j++){ System.out.println(atributos[j]); }
        
         for (int i = 0; i < atributos.length; i++) {
            if (atributos[i].isEmpty())
            {
                confirmacion = 2; 
            }
        }

        
        int abono = Integer.parseInt(atributos[1]);
        
        
        //convertir total a pagar de Money a Int
        StringBuilder totalpagarS = new StringBuilder(datos[3]);
        totalpagarS.deleteCharAt(0);
        totalpagarS.deleteCharAt(totalpagarS.length()-1);
        totalpagarS.deleteCharAt(totalpagarS.length()-1);
        totalpagarS.deleteCharAt(totalpagarS.length()-1);
        
        String totalpagarS2 = totalpagarS.toString();
        
        String replace = totalpagarS2.replace(",","");
        
        int totalPagar = Integer.parseInt(replace);
        
        
        System.out.println(datos[2].length());
        
        //convertir cantidad pagada de Money a int
        StringBuilder totalpagarSII = new StringBuilder(datos[2]);
        totalpagarSII.deleteCharAt(0);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-1);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-1);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-1);
        
        String totalpagarSII2 = totalpagarSII.toString();
        
        String replaceII = totalpagarSII2.replace(",","");
        
        int cantidadPagada = Integer.parseInt(replaceII);
        
        
        //System.out.println("Abonado " + abono);
        //System.out.println("total a pagar " + totalPagar);
        //System.out.println("Pagado Total " + cantidadPagada);
         
        if (abono > totalPagar)
        {
            confirmacion = 2;
            JOptionPane.showConfirmDialog(null, 
                "Monto demasiado alto", "Advertencia", JOptionPane.DEFAULT_OPTION);
        } else if (abono + cantidadPagada > totalPagar)
        {
            confirmacion = 2;
            JOptionPane.showConfirmDialog(null, 
                "El monto total excede el debido", "Advertencia", JOptionPane.DEFAULT_OPTION);
            
        }
        
            if (atributos[0].matches("-?\\d+(\\.\\d+)?") &&
            atributos[1].matches("-?\\d+(\\.\\d+)?") &&
            confirmacion != 2) {
            
            PreparedStatement stm;

            // Preparando el statement de la tabla registro
            String sql =
                    "update factura set cantidad_pagada = ?,fecha_pago = ? where num_factura = ?";
            stm = conn.prepareStatement(sql);
            
            stm.setInt(1,abono + cantidadPagada);
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            
            if (abono + cantidadPagada == totalPagar)
            {
                stm.setDate(2,java.sql.Date.valueOf (dtf.format(now)) );
                
            }else
            {
                stm.setDate(2,null);
            }
            
            
            stm.setInt(3,Integer.parseInt(atributos[0]));
            

            // envviando el query INSERT registro
            confirmacion = stm.executeUpdate();
            //System.out.println(confirmacion); 
            conn.commit();

        } else if (confirmacion != 2){
            confirmacion = -1;
        }
         
        return confirmacion;
    }
    
    
        public String[] mostrarFactura (int numFactura) throws SQLException {
        // Realizacion del query
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM factura WHERE num_factura = "
                + numFactura);


        String arr[] = new String[8];
        

        if (result.next()) {
            for (int i = 0; i < 8; i++) {
                if (i != 7) {
                    arr[i] = result.getString(i + 1);
                } else {
                    // true --> Activo / false --> Inactivo
                    if (result.getString(3).equals(result.getString(4))) {
                        arr[i] = "PAGADO";
                    } else {
                        arr[i] = "IMPAGADO";
                    }
                }
            }
        }



        
        //for(int j =0; j <8;j++){ System.out.println(arr[j]); }
         


        return arr;
    }
        
     
    public void generarGastos() throws SQLException, IOException{
        File archivo;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter pwr;
        
        
        archivo = new File("./src/main/java/services/gastos.txt");
        w = new FileWriter(archivo);
        bw = new BufferedWriter(w);
        pwr = new PrintWriter(bw);
        
        
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT numero_tel, minutos_usados, datos_usados, mensajes_usados FROM numero");
        
        String valores = "";
        while (result.next()){
            Random random = new Random();
            String numero = result.getString("numero_tel");
            String  minutos = String.valueOf(random.nextInt(200) + Integer.parseInt(result.getString("minutos_usados")));
            String datos = String.valueOf(random.nextInt(10000)+ Integer.parseInt(result.getString("datos_usados")));
            String mensajes = String.valueOf(random.nextInt(500)+ Integer.parseInt(result.getString("mensajes_usados")));
            valores += numero + "," + minutos + "," +datos+ "," + mensajes + "\n";
        }
        
        
        pwr.write(valores);
        
        
        
        pwr.close();
        bw.close();
        
        if (archivo.createNewFile()){
            System.out.println("Se ha creado el archivo ");
        }
    }
    
    public void guardarGastos() throws SQLException, IOException{
           FileReader archivo;
           BufferedReader lector;
           PreparedStatement stm;
           int confirmacion;

           
           archivo = new FileReader("./src/main/java/services/gastos.txt");
           
           if (archivo.ready()){
               System.out.println("El archivo puede ser leido");
               lector = new BufferedReader (archivo);
               String cadena;
               while ((cadena = lector.readLine()) != null){
                   String[] partes = cadena.split(",");
                   stm = conn.prepareStatement("UPDATE numero SET \n" +
                                                                                "minutos_usados = "+ partes[1]+" ,\n" +
                                                                                "datos_usados = "+ partes[2]+" ,\n" +
                                                                                "mensajes_usados = "+ partes[3]+" \n" +
                                                                                "WHERE numero_tel = '"+ partes[0]+"' ");
                   confirmacion = stm.executeUpdate();
                   conn.commit();
               }
           }else {
               System.out.println("El archivo no pudo ser leído");
           }
           
    
    }
    
    public static void main(String args[]) throws SQLException, IOException{
        OperadorClientes prueba = new OperadorClientes();
        
        /*String atributos[] = 
        {
            "1003","70000"
        };
        prueba.registrarPago(atributos);*/
        
        //prueba.mostrarFactura(1006);
        prueba.generarGastos();
        prueba.guardarGastos();
    }
    
}
