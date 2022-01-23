
package com.mycompany.teleamiguis;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author pablo
 */
public class reportes {
    public static Connection getConnection(){
        Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:postgresql://ec2-54-159-126-187.compute-1.amazonaws.com:5432/d5fj66nnqgd2dj","mujvqfxznhjlby","6c6084db23a79034be8cfdae64f615ded77905a14f48ed20d27f840426542e4d");
          conn.setAutoCommit(false);
          return conn;
        }
        catch (SQLException e) {
          System.out.println("Error de conexión: " + e.getMessage());
          System.exit(4);
        }
        return null;
    }
    public static JasperPrint createPrint(Map<String,Object> parameters,String jrxml, Connection conn) throws JRException{
      InputStream employeeReportStream= reportes.class.getResourceAsStream(jrxml);
      JasperReport jasperReport= JasperCompileManager.compileReport(employeeReportStream);
      JasperPrint jasperPrint = JasperFillManager.fillReport(
      jasperReport, parameters, conn);
      return jasperPrint;
    }
    public static void previewReport(JasperPrint print){
      JasperViewer jView=new JasperViewer(print,false);
      jView.setVisible(true);
        
    }
    public static void createPdf(String dir, JasperPrint print) throws JRException{
      JRPdfExporter exporter = new JRPdfExporter();
      exporter.setExporterInput(new SimpleExporterInput(print));
      exporter.setExporterOutput(
      new SimpleOutputStreamExporterOutput(dir));
      SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
      reportConfig.setSizePageToContent(true);
      reportConfig.setForceLineBreakPolicy(false);
      SimplePdfExporterConfiguration exportConfig= new SimplePdfExporterConfiguration();
      exportConfig.setMetadataAuthor("pablo");
      exportConfig.setEncrypted(true);
      exportConfig.setAllowedPermissionsHint("PRINTING");
      exporter.setConfiguration(reportConfig);
      exporter.setConfiguration(exportConfig);
      exporter.exportReport();
    }
    public static void main(String args[]) throws JRException, SQLException {
      Connection conn= getConnection();
      //Prueba de traer e imprimir filas
//      Statement stmt = conn.createStatement();
//      ResultSet rs= stmt.executeQuery("SELECT * FROM trabajadore"
//              + "s");
//      ResultSetMetaData rsmd = rs.getMetaData();
//      int columnsNumber = rsmd.getColumnCount();
//      while (rs.next()) {
//      for (int i = 1; i <= columnsNumber; i++) {
//        if (i > 1) System.out.print(",  ");
//        String columnValue = rs.getString(i);
//        System.out.print(columnValue + " " + rsmd.getColumnName(i));
//        }
//    System.out.println("");
//    
//      }
       
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("title", "Soy un titulo mamon");
      String jrxml = "/reports/reportes.jrxml";
      JasperPrint print=createPrint(parameters,jrxml,conn);
//      previewReport(print);
      createPdf("./src/main/resources/reports/kkReport.pdf",print);
      
      
    }


    
}
