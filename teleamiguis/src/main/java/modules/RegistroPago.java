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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

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
        
         for (int i = 0; i < atributos.length; i++) {
            if (atributos[i].isEmpty())
            {
                confirmacion = 2; 
            }
        }

        if (atributos[0].matches("-?\\d+(\\.\\d+)?") &&
            atributos[1].matches("-?\\d+(\\.\\d+)?") &&
            confirmacion != 2) {
            
            PreparedStatement stm;

            // Preparando el statement de la tabla registro
            String sql =
                    "update factura set cantidad_pagada = ?,fecha_pago = ? where num_factura = ?";
            stm = conn.prepareStatement(sql);
            
            stm.setInt(1,Integer.parseInt(atributos[1]));
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            
            stm.setDate(2,java.sql.Date.valueOf (dtf.format(now)) );
            
            stm.setInt(3,Integer.parseInt(atributos[0]));
            

            // envviando el query INSERT registro
            confirmacion = stm.executeUpdate();
            conn.commit();

        } else if (confirmacion != 2){
            confirmacion = -1;
        }

        return confirmacion;
    }
    
    public static void main(String args[]) throws SQLException, IOException{
        RegistroPago prueba = new RegistroPago();
        
        String atributos[] = 
        {
            "1003","70000"
        };
        prueba.registrarPago(atributos);
    }
    
}
