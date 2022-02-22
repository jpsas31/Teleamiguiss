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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gyron
 */
public class AdministradorClientes {


    private Connection conn;

    public AdministradorClientes() throws IOException, SQLException {
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
    public String[] mostrarClientes(String id, String tipoid) throws SQLException {
        // Realizacion del query
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM cliente WHERE id_cliente = '" + id
                + "' and tipo_identificacion = '" + tipoid + "' ");
        String arr[] = new String[8];
        if (result.next()) {
            for (int i = 0; i < 8; i++) {
                if (i != 7) {
                    arr[i] = result.getString(i + 1);
                } else {
                    // true --> Activo / false --> Inactivo
                    if (true == result.getBoolean(8)) {
                        arr[i] = "ACTIVO";
                    } else {
                        arr[i] = "INACTIVO";
                    }
                }
            }
        }


        /*
         * for(int j =0; j <8;j++){ System.out.println(arr[j]); }
         */


        return arr;
    }

    // retorna una arreglo de strings de nombres e id de trabajadores;
    public ArrayList<String[]> mostrarListaClientes() throws SQLException {
        // Realizacion del query
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM cliente");
        ArrayList<String[]> usuarios = new ArrayList<String[]>();
        while (result.next()) {

            String aux[] = new String[3];
            aux[0] = result.getString("nombre");
            aux[1] = result.getString("id_cliente");
            aux[2] = result.getString("tipo_identificacion");
            usuarios.add(aux);

        }
        return usuarios;
    }


    public int registrarCliente(String[] atributos) throws IOException, SQLException {
        int confirmacion = 0;
        
        for (int i = 0; i < atributos.length; i++) {
            if (atributos[i].isEmpty())
            {
                confirmacion = 2; 
            }
        }
        
        if (atributos[0].matches("-?\\d+(\\.\\d+)?") && atributos[5].matches("-?\\d+(\\.\\d+)?") && confirmacion != 2) {
            PreparedStatement stm;

            // Preparando el statement de la tabla trabajadores
            String sql =
                    "INSERT INTO cliente (id_cliente, tipo_identificacion, tipo_cliente, nombre, direccion, telefono, correo, estado) VALUES (?,?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);

            for (int i = 1; i <= atributos.length; i++) {
                stm.setString(i, atributos[i - 1]);
            }

            stm.setBoolean(8, true);
            // envviando el query INSERT trabajadores
            confirmacion = stm.executeUpdate();
            conn.commit();

        } else if (confirmacion != 2){
            confirmacion = -1;
        }

        return confirmacion;
    }


    // Funcion para cambiar el estado de un cliente en el sistema (true -> ACTIVO, false ->
    // INACTIVO). La función recibe como parametro
    // el id (cedula) del usuario.
    public int cambiaEstadoCliente(String id, String tipoid, String status) throws SQLException {
        PreparedStatement stm;
        int confirmacion;
        // Escribimos el Query
        String inhabQuery =
                "UPDATE cliente SET  estado = CAST( ? AS boolean ) WHERE id_cliente = ? AND tipo_identificacion = ? ";
        stm = conn.prepareStatement(inhabQuery);

        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setString(1, status);
        stm.setString(2, id);
        stm.setString(3, tipoid);

        // Ejecutamos la sentencia
        confirmacion = stm.executeUpdate();
        conn.commit();
        return confirmacion;
    }

    // Funcion para ejecutar un update a un cliente en la DB, este metodo recibe un arreglo con los
    // datos del usuario en el siguiente orden:
    // tipo_cliente, nombre, direccion telefono, correo, estado,id_cliente, tipo_identificacion
    public int modificarCliente(String[] atributos) throws SQLException {
        int confirmacion;
        if (atributos[3].matches("-?\\d+(\\.\\d+)?")) {
            PreparedStatement stm;
            String sql =
                    "UPDATE cliente  SET  tipo_cliente=?, nombre=?, direccion=?, telefono=?,correo=?  WHERE id_cliente = ? AND tipo_identificacion = ?";
            stm = conn.prepareStatement(sql);
            // Recorrer todo el arreglo de atributos para insertarlos en la secuencia SQL
            for (int i = 1; i <= atributos.length; i++) {
                // System.out.println(atributos[i-1]);
                stm.setString(i, atributos[i - 1]);
            }
            // Ejecutar la sentencia
            confirmacion = stm.executeUpdate();
            conn.commit();
        } else {
            confirmacion = -1;
        }
        return confirmacion;
    }

    public void cerrarConexion(String idUsuario, String tipoidUsuario) throws SQLException {
        PreparedStatement stm;
        stm = conn.prepareStatement("UPDATE usuarios  SET  isactive = false WHERE id_trabajador = '"
                + idUsuario + "' and tipo_identificacion = '" + tipoidUsuario + "' ");
        stm.executeUpdate();
        conn.commit();

        conn.close();
    }

    // Trae los planes disponibles
    public ArrayList<String> getPlanes() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM planes");
        ArrayList<String> usuarios = new ArrayList<String>();

        while (result.next()) {

            String aux = String.format(
                    "ID: %s \n Nombre: %s \n Precio: %s \n Limite de minutos: %s \n Limite de datos: %s GB \n Limite de mensajes: %s \n Descripcion: %s",
                    result.getString("id_plan"), result.getString("nom_plan"),
                    result.getString("precio"), result.getString("limite_de_minutos"),
                    result.getString("limite_de_datos"), result.getString("limite_de_mensajes"),
                    result.getString("descripcion"));
            aux = "<html>" + aux.replaceAll("\n", "<br>") + "</html>";
            usuarios.add(aux);

        }
        return usuarios;
    }

    // Tra los planes que tiene registrado el cliente
    public ArrayList<String> getPlanesCliente(String id, String tipoid) throws SQLException {

        PreparedStatement stmt;
        stmt = conn.prepareStatement("select * from planes p inner join \n"
                + "(select * from numero num inner join \n"
                + "(select num_contrato ,numero_tel from contratos_telefonos where num_contrato  in\n"
                + "(select num_contrato from contratos_clientes WHERE id_cliente = ? and tipo_identificacion = ?)) contra\n"
                + "on num.numero_tel= contra.numero_tel) n \n"
                + "on p.id_plan = n.id_plan           \n");
        stmt.setString(1, id);
        stmt.setString(2, tipoid);
        ArrayList<String> planesCliente = new ArrayList<String>();
        ResultSet result = stmt.executeQuery();
        while (result.next()) {

            String aux = String.format(
                    "ID de contrato: %s \n Numero: %s \n "
                            + "ID Plan: %s \n Nombre: %s \n Precio: %s \n Minutos usados: %s \n"
                            + " Datos usados: %s GB \n Mensajes usados: %s \n",
                    Integer.toString(result.getInt("num_contrato")), result.getString("numero_tel"),
                    result.getString("id_plan"), result.getString("nom_plan"),
                    result.getString("precio"), result.getString("minutos_usados"),
                    result.getString("datos_usados"), result.getString("mensajes_usados"));
            aux = "<html>" + aux.replaceAll("\n", "<br>") + "</html>";
            planesCliente.add(aux);

        }
        return planesCliente;
    }

    // Crea un numero aleatorio para el numero de telefono
    private String getNumber(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return String.valueOf(digits);
    }

    // Crea nuevo contrato para el cliente
    public String agregarContrato() throws SQLException {
        PreparedStatement stm;
        // Escribimos el Query
        String inhabQuery =
                "INSERT INTO contratos (fecha, estado) VALUES(?, true) RETURNING num_contrato;";
        stm = conn.prepareStatement(inhabQuery);
        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setObject(1, LocalDate.now());
        // Ejecutamos la sentencia
        ResultSet result = stm.executeQuery();
        conn.commit();
        result.next();
        return result.getString("num_contrato");
    }

    // Inserta un nuevo numero para crear un contrato para un cliente
    public String agregarNumero(int idPlan,String numero) throws SQLException {
        PreparedStatement stm;
        // Escribimos el Query
        String numeroTel = numero;
        String inhabQuery =
                "INSERT INTO numero (numero_tel, id_plan, minutos_usados, datos_usados, mensajes_usados) VALUES(?, ?, 0, 0, 0) RETURNING numero_tel;";
        stm = conn.prepareStatement(inhabQuery);

        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setString(1, numeroTel);
        stm.setInt(2, idPlan);
        // Ejecutamos la sentencia
        conn.commit();
        ResultSet result = stm.executeQuery();
        result.next();
        return result.getString("numero_tel");
    }

    public int unirContratoNumero(String numContrato, String numTelefono) throws SQLException {
        PreparedStatement stm;
        int confirmacion;
        // Escribimos el Query
        String inhabQuery =
                "INSERT INTO public.contratos_telefonos (num_contrato, numero_tel) VALUES(?, ?);";
        stm = conn.prepareStatement(inhabQuery);

        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setInt(1, Integer.parseInt(numContrato));
        stm.setString(2, numTelefono);
        // Ejecutamos la sentencia
        confirmacion = stm.executeUpdate();
        conn.commit();
        return confirmacion;
    }

    public int unirContratoClient(String id, String tipoid, String numContrato)
            throws SQLException {
        PreparedStatement stm;
        int confirmacion;
        // Escribimos el Query
        String inhabQuery =
                "INSERT INTO public.contratos_clientes (num_contrato, tipo_identificacion, id_cliente) VALUES(?, ?, ?);";
        stm = conn.prepareStatement(inhabQuery);

        // Seteamos los parametros del query teniendo en cuenta los parametros de la funcion
        stm.setInt(1, Integer.parseInt(numContrato));
        stm.setString(2, tipoid);
        stm.setString(3, id);
        // Ejecutamos la sentencia
        confirmacion = stm.executeUpdate();
        conn.commit();

        return confirmacion;
    }

    // Hace todo el proceso para agregar un plan a un cliente
    public void agregarPlan(int plan, String id, String tipoid,String numero) throws SQLException {
        String numContrato = agregarContrato();
        String numTel = agregarNumero(plan,numero);
        unirContratoNumero(numContrato, numTel);
        unirContratoClient(id, tipoid, numContrato);
    }

    // Obtiene el id de plan de los planes disponibles para saber cual eligio el cliente
    public int getIdPlan(String planInfo) {
        String aux = planInfo.replaceAll("<br>", "\n").replaceAll("</html>", "")
                .replaceAll("<html>", "");
        String lines[] = aux.split("\\r?\\n");
        return Integer.parseInt(lines[0].split(" ")[1]);
    }

    // Trae el numero del string del plan que tiene un cliente
    public String getNumeroFromPlan(String plan) {
        String aux =
                plan.replaceAll("<br>", "\n").replaceAll("</html>", "").replaceAll("<html>", "");
        String lines[] = aux.split("\\r?\\n");
        return lines[1].split(" ")[2];
    }

    // Trae el numero de contrato del string del plan que tiene un cliente
    public String getContratoFromPlan(String plan) {
        String aux =
                plan.replaceAll("<br>", "\n").replaceAll("</html>", "").replaceAll("<html>", "");
        String lines[] = aux.split("\\r?\\n");
        return lines[0].split(" ")[3];

    }

    // Hace las queries necesarias para desvincular un cliente de un plan
    public int cancelarPlan(String idContrato, String numero, String id, String tipoid)
            throws SQLException {
        int confirmacion;
        PreparedStatement stm;
        String sql = "DELETE FROM contratos_clientes\n"
                + "WHERE  num_contrato=? AND tipo_identificacion=? AND id_cliente=?;";
        stm = conn.prepareStatement(sql);
        // System.out.println(idContrato);
        // System.out.println(numero);
        stm.setInt(1, Integer.parseInt(idContrato));
        stm.setString(2, tipoid);
        stm.setString(3, id);
        confirmacion = stm.executeUpdate();
        conn.commit();

        sql = "DELETE FROM contratos_telefonos\n" + "WHERE  num_contrato=? AND numero_tel=?;";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, Integer.parseInt(idContrato));
        stm.setString(2, numero);
        confirmacion = stm.executeUpdate();
        conn.commit();

        sql = "DELETE FROM public.numero\n" + "WHERE numero_tel=?;";
        stm = conn.prepareStatement(sql);
        stm.setString(1, numero);
        confirmacion = stm.executeUpdate();
        conn.commit();

        sql = "DELETE FROM public.contratos\n" + "WHERE num_contrato=?;";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, Integer.parseInt(idContrato));
        confirmacion = stm.executeUpdate();
        conn.commit();
        return confirmacion;
    }

    // Revisa que el cliente si pueda agregar mas planes
    public int clientePermitido(String id, String tipoid) {
        try {
            String datos[] = mostrarClientes(id, tipoid);
            int planes = getPlanesCliente(id, tipoid).size();
            if (planes >= 3 && datos[2].equals("Natural")) {
                return -1;
            } else
                return 1;

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int[] estadisticasPlanes(String fechaInicial, String fechaFinal) throws SQLException{
        System.out.println(fechaInicial + "  " + fechaFinal);
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT pl.id_plan, sum(fac.cantidad_pagada) FROM factura fac,contratos con, contratos_telefonos ct, numero num, planes pl\n" +
                                                                            "WHERE cantidad_pagada = total_a_pagar and \n" +
                                                                            "		fecha_pago <= '" + fechaFinal + "' and \n" +
                                                                            "			fecha_pago >= '" + fechaInicial + "' and\n" +
                                                                            "				fac.num_contrato = con.num_contrato and\n" +
                                                                            "					con.num_contrato = ct.num_contrato and\n" +
                                                                            "						ct.numero_tel = num.numero_tel and\n" +
                                                                            "							num.id_plan = pl.id_plan\n" +
                                                                            "GROUP BY pl.id_plan ORDER BY pl.id_plan");
        
        int arr[] = new int[8];
         
        int j = 0;
        while (result.next()) {
            int y = 0;
            for (int i = j; i < j+2; i++) {
                  if (y == 1){
                        StringBuilder ganancia = new StringBuilder(result.getString(y + 1));
                        ganancia.deleteCharAt(0);
                        ganancia.deleteCharAt(ganancia.length()-1);
                        ganancia.deleteCharAt(ganancia.length()-1);
                        ganancia.deleteCharAt(ganancia.length()-1);
                        String ganancia1 = ganancia.toString();
                        String ganancia2 = ganancia1.replace(",", "");
                        arr[i] = Integer.parseInt(ganancia2);
                        //System.out.println(arr[i]);
                  }else {
                        arr[i] = Integer.parseInt(result.getString(y + 1));
                        //System.out.println(arr[i]);
                  }
                  y++;
            }
            j = j + 2;
        }
        
        return arr;
    }


public static void main(String args[]) throws SQLException, IOException {
        AdministradorClientes prueba = new AdministradorClientes();
        prueba.estadisticasPlanes("2022-01-19", "2022-12-19");
        // String numContrato = prueba.agregarContrato();
        // String numTel = prueba.agregarNumero(4);
        // prueba.unirContratoNumero(numContrato,numTel);
        // prueba.unirContratoClient("31482384", "C.C", numContrato);
        //System.out.println(prueba.getIdPlan(
        //        "<html>ID: 4 <br> Nombre: Plan Rojo <br> Precio: $100.00 <br> Limite de minutos: 100 <br> Limite de datos: 100 GB <br> Limite de mensajes: 100 <br> Descripcion: Plan para sasuki</html>"));
        // for( String plan:prueba.getPlanesCliente("31482384", "C.C")){
        // System.out.println(plan);
        // }
        //prueba.clientePermitido("31482384", "C.C");
        
        // for (String plan: prueba.getPlanesCliente("31482384", "C.C")){
        // System.out.println(plan);
        // }
    }


}
