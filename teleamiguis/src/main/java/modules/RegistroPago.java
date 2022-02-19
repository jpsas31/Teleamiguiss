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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author gyron
 */
public class RegistroPago {
    
        private Connection conn;

    public RegistroPago() throws IOException, SQLException {
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
        totalpagarS.deleteCharAt(totalpagarS.length()-2);
        totalpagarS.deleteCharAt(totalpagarS.length()-3);
        
        String totalpagarS2 = totalpagarS.toString();
        
        String replace = totalpagarS2.replace(",","");
        
        int totalPagar = Integer.parseInt(replace);
        
        //convertir cantidad pagada de Money a int
        StringBuilder totalpagarSII = new StringBuilder(datos[2]);
        totalpagarSII.deleteCharAt(0);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-1);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-2);
        totalpagarSII.deleteCharAt(totalpagarSII.length()-3);
        
        String totalpagarSII2 = totalpagarSII.toString();
        
        String replaceII = totalpagarSII2.replace(",","");
        
        int cantidadPagada = Integer.parseInt(replaceII);
        
        
        System.out.println("Abonado " + abono);
        System.out.println("total a pagar " + totalPagar);
        System.out.println("Pagado Total " + cantidadPagada);
         
        if (abono > totalPagar)
        {
            confirmacion = 2;
            JOptionPane.showConfirmDialog(null, 
                "Monto demasiado alto", "Advertencia", JOptionPane.DEFAULT_OPTION);
        }else if (abono < 10000)
        {
            confirmacion = 2;
            JOptionPane.showConfirmDialog(null, 
                "Monto demasiado bajo", "Advertencia", JOptionPane.DEFAULT_OPTION);
            
        }else if (abono + cantidadPagada > totalPagar)
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
        
     
    
    public static void main(String args[]) throws SQLException, IOException{
        RegistroPago prueba = new RegistroPago();
        
        /*String atributos[] = 
        {
            "1003","70000"
        };
        prueba.registrarPago(atributos);*/
        
        prueba.mostrarFactura(1006);
    }
    
}
