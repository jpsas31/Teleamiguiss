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
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

/**
 *
 * @author gyron
 */
public class administradorUsuarios {
    
        private Statement stm;
        private Connection conn;
        
        public administradorUsuarios() throws IOException, SQLException {
            conn = getConnection();
            stm = conn.createStatement();
        
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
    
    public String cambiarUsuario()
    {
        String confirmacion="";
        
        return confirmacion;
    }
    
    
    
    
}
