package GUI;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author LeAnhQuan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch(Exception ex){
            System.out.println(ex);
        }
        QuanLyNhanVien_GUI dangNhap_GUI= new QuanLyNhanVien_GUI();
        dangNhap_GUI.setVisible(true);
    }
    
}
