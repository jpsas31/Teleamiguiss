
package services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pablo
 */
public class reportes {
    
    
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
    public static JasperPrint createPrint(Map<String,Object> parameters,String jrxml, Connection conn) throws JRException{
      InputStream employeeReportStream= reportes.class.getResourceAsStream(jrxml);
      JasperReport jasperReport= JasperCompileManager.compileReport(employeeReportStream);
      JasperPrint jasperPrint = JasperFillManager.fillReport(
      jasperReport, parameters, conn);
      return jasperPrint;
    }
    public static JRViewer createReportView(JasperPrint print){
      JRViewer jView=new JRViewer(print);
      return jView;
        
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
    
    public static void main(String args[]) throws JRException, SQLException, IOException {
      Connection conn= getConnection();
       
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("title", "Soy un titulo mamon");
      String jrxml = "/reports/reportes.jrxml";
      JasperPrint print=createPrint(parameters,jrxml,conn);
      createReportView(print);
      createPdf("./src/main/resources/reports/kkReport.pdf",print);
      
      
    }

    
}

