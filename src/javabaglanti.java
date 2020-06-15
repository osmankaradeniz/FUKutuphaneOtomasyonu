import java.sql.*;
import javax.swing.JOptionPane;
public class javabaglanti {
    
     protected static Connection baglanti;
    
     private final static String db_kulad = "root";
     private final static String db_sifre = "firat1975";
     private final static String url = "jdbc:mysql://localhost:3306/fukutuphanedb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
     
     
  public static Connection BaglantiDb() 
  {
   
      
      try {
         baglanti = DriverManager.getConnection(url, db_kulad, db_sifre);
         return baglanti;
      }
      catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
          JOptionPane.showMessageDialog(null,"Error Code: " + e.getErrorCode());
          JOptionPane.showMessageDialog(null,"Message: " + e.getMessage());
         e.printStackTrace(System.err);
         return null;
      }
   }
  
  
}