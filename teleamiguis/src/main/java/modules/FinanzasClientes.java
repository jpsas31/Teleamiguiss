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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author gyron
 */
public class FinanzasClientes {
    
    private Connection conn;

    public FinanzasClientes() throws IOException, SQLException {
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
    
    public ArrayList<ArrayList<String>> mostrarEstadoFinanciero (String id, String tipoId) throws SQLException {
        // Realizacion del query
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM estado_financiero ('"+id+"','"+tipoId+"')");

        ResultSetMetaData mtdResult = result.getMetaData();
        
        int columnas = mtdResult.getColumnCount();
        
        ArrayList<ArrayList<String>> resultados = new ArrayList();
        

        while (result.next()) {
            ArrayList<String> fila = new ArrayList();
            for (int i = 0; i < columnas; i++) {
                fila.add(result.getString(i + 1));
            }
            resultados.add(fila);
        }



        for(int i =0; i <resultados.size(); i++)
        {
            for(int j =0; j <4;j++){System.out.println(resultados.get(i).get(j));}
        }
        
         


        return resultados;
    }
    
    public static void main(String args[]) throws SQLException, IOException{
        FinanzasClientes prueba = new FinanzasClientes();
        
        String id = "2412";
        String tipoId = "T.I";
        prueba.mostrarEstadoFinanciero(id,tipoId);
        
    }
    
}
