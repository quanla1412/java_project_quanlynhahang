package GUI;

import DAO.LoaiMonAn_DAO;
import DTO.LoaiMonAn_DTO;
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
        LoaiMonAn_DAO loaiMonAn_DAO = new LoaiMonAn_DAO();
        
        System.out.println(loaiMonAn_DAO.deleteLoaiMonAn("5"));
        
        
//        MonAn_GUI monAn_GUI = new MonAn_GUI();
//        monAn_GUI.setVisible(true);
    }
    
}
