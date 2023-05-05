package GUI;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
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
        TrangChuNew_GUI dangNhap_GUI= new TrangChuNew_GUI();
        dangNhap_GUI.setVisible(true);
    }
    
}


