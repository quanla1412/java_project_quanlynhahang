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

        QuanLyPhucVu_GUI monAn_GUI = new QuanLyPhucVu_GUI();

        monAn_GUI.setVisible(true);
    }
    
}
