package GUI;

import DAO.LoaiMonAn_DAO;
import DTO.MonAn.LoaiMonAn_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

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
       MonAn_GUI monAn_GUI = new MonAn_GUI();
       monAn_GUI.setVisible(true);
        
        
//        MonAn_GUI monAn_GUI = new MonAn_GUI();
//        monAn_GUI.setVisible(true);
    }
    
}
