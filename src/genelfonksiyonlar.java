
import javax.swing.JOptionPane;

/**
 *
 * @author Osman Karadeniz
 */
public class genelfonksiyonlar {
    
    
    public static boolean int_sayimi(String deger)
    {
        try{
            Integer.parseInt(deger);
            return true;
        }catch (NumberFormatException e)
        {
        return false;
        }
    }
    
    public static boolean double_sayimi(String deger)
    {
        try{
            Double.parseDouble(deger);
            return true;
        }catch (NumberFormatException e)
        {
        return false;
        }
    }
    
     public static int sayiya_cevir(String deger)
    {
        try{
           int cevirilen = Integer.parseInt(deger);
            return cevirilen;
        }catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null , "HATALI PARAMETRE ÇEVİRİM BAŞARISIZ !");
            return 0;
        }
    }
    
    
}
