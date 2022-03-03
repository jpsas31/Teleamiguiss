/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Usuario
 */
public class BancoClientes {
        private Connection conn;
        
        public BancoClientes() throws IOException, SQLException {
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
  
  // Funcion que crea un archivo xlsx
  // 
      public void generarVouchers() throws FileNotFoundException, IOException, SQLException {
          // bancos: 
           ArrayList<String> bancos = new ArrayList<String>();
          bancos.add("Banco de bogota");
          bancos.add("Bancolombia"); 
          bancos.add("Banco popular"); 
          // crear random
          Random random = new Random();
          // crear un workbook
          XSSFWorkbook workbook = new XSSFWorkbook(); 
          // crear la hoja de excel
          XSSFSheet sheet = workbook.createSheet("Vouchers"); 
          // crear un row Object 
          XSSFRow  row; 
          // fuente
          CellStyle style = workbook.createCellStyle(); 
          style.setAlignment(HorizontalAlignment.CENTER);

          // crear cell = similar a las columnas 
          row = sheet.createRow(0); 
          Cell cell0 = row.createCell(0);
          Cell cell1 = row.createCell(1); 
          Cell cell2 = row.createCell(2); 
          Cell cell3 = row.createCell(3); 
          
           cell0.setCellValue("NumVoucher");
           cell0.setCellStyle(style); 
           cell1.setCellValue("NumFactura"); 
           cell1.setCellStyle(style); 
           cell2.setCellValue("Cantidad");
           cell3.setCellStyle(style); 
           cell3.setCellValue("Banco"); 
           // se llenan los datos 
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT num_factura, CAST(total_a_pagar AS numeric(10, 0)) FROM factura");
            ResultSet numColumn = stmt2.executeQuery("SELECT COUNT(num_factura) as numero FROM factura"); 
            numColumn.next(); 
            
            for (int i = 0; i < numColumn.getInt("numero"); i++) {
                result.next(); 
                row = sheet.createRow(i+1);
                for (int j = 0;  j < 4; j++) {
                    Cell cell = row.createCell(j); 
                    switch (cell.getColumnIndex()) {
                        case 0:
                            cell.setCellValue(i);
                            break;
                        case 1:
                            cell.setCellValue(result.getInt("num_factura"));
                            break;
                        case 2:
                            cell.setCellValue(random.nextInt(result.getInt("total_a_pagar")+ 1));
                            break;
                        default: 
                            cell.setCellValue(bancos.get(random.nextInt(bancos.size())));
                            break;
                    }
                    
                }
            }
            
            // escribirlo en el archivo
            FileOutputStream out = new FileOutputStream(new File("./src/main/java/services/banco.xlsx"));
            workbook.write(out);
            out.close(); 
            System.out.println("Se ha creado el excel"); 
      }
      
      public void leerVouchers(File archivo) throws FileNotFoundException, IOException, SQLException {
          PreparedStatement stm;
            
          FileInputStream in = new FileInputStream(archivo); 
          XSSFWorkbook importedfile = new XSSFWorkbook(in); 
          XSSFSheet sheet1 = importedfile.getSheetAt(0); 
          //Cadena sql 
          String sql = ""; 
          int i; 
          //
          Iterator<Row> rowIterator  = sheet1.iterator(); 
          Row row = rowIterator.next(); 
          while(rowIterator.hasNext()) {
                    row = rowIterator.next();
                    sql = "INSERT INTO voucher(num_voucher, num_factura, cantidad, banco) VALUES (CAST (? AS integer), CAST( ? AS integer), CAST (? AS money), ?)"; 
                    stm = conn.prepareStatement(sql);
                    Iterator<Cell> cellIterator = row.cellIterator(); 
                    i = 0; 
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        i++; 
                        if (cell.getColumnIndex() == 3) {
                            //System.out.println(cell.getStringCellValue());
                            stm.setString(i, cell.getStringCellValue()); 
                        } else {
                            stm.setString(i, String.valueOf(Math.round(cell.getNumericCellValue()))); 
                            //System.out.println(cell.getNumericCellValue());
                        }
                    }
                    stm.executeUpdate();
                    conn.commit();
          }
          
          
          in.close(); 
          System.out.println("Ha sido leido correctamente"); 
          
      } 
      
      public void actualizar() throws IOException, FileNotFoundException, SQLException{
          leerVouchers(new File("./src/main/java/services/banco.xlsx")); 
          PreparedStatement stm;
          String sql = "SELECT voucherfactura()"; 
          stm = conn.prepareStatement(sql); 
          stm.executeUpdate(); 
          conn.commit(); 
      }; 
      
      
      
      
      
      
     
      
      
 
      
    public static void main(String args[]) throws SQLException, IOException{
        BancoClientes prueba = new BancoClientes(); 
        prueba.actualizar(); 
        //prueba.generarVouchers(); 
        //prueba.leerVouchers(new File("./src/main/java/services/banco.xlsx"));
    }
  
  
  
  
  

}

