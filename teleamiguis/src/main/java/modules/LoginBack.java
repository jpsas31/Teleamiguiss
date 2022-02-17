/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class LoginBack {


    private Connection conn;

    public LoginBack() throws IOException, SQLException {
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



    // Consulta de usuario (trabajadores)
    public String[] usuarioIngreso(String user, String password) throws SQLException {
        // Realizacion del query
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(" SELECT * FROM usuarios WHERE id_trabajador = '"
                + user + "'  and contraseña = '" + password + "'and isactive = 'false' ");


        String arr[] = new String[4];

        String existe = "no";
        String cargo = "";
        String nombre = "";

        if (result.next()) {
            for (int i = 0; i < 4; i++) {
                arr[i] = result.getString(i + 1);
            }
            result = stmt
                    .executeQuery("SELECT cargo,nombre FROM trabajadores WHERE id_trabajador = '"
                            + arr[0] + "' and tipo_identificacion = '" + arr[1] + "'   ");
            result.next();
            cargo = result.getString(1);
            existe = "si";
            nombre = result.getString(2);

            PreparedStatement stm;
            stm = conn.prepareStatement(
                    "UPDATE usuarios  SET  isactive = true WHERE id_trabajador = '" + arr[0]
                            + "' and tipo_identificacion = '" + arr[1] + "' ");
            stm.executeUpdate();
            conn.commit();
        }

        // System.out.println(cargo);
        // System.out.println(existe);
        String resultados[] = new String[5];
        resultados[0] = existe;
        resultados[1] = cargo;
        resultados[2] = arr[0];
        resultados[3] = arr[1];
        resultados[4] = nombre;

        return resultados;
    }


    public void cerrarConexion() throws SQLException {
        conn.close();
    }


    public static void main(String args[]) throws SQLException, IOException {
        LoginBack prueba = new LoginBack();
        prueba.usuarioIngreso("1193552015", "A1193G");
    }
}
