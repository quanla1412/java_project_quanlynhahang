package GUI;

import DAO.LoaiMonAn_DAO;
import DTO.MonAn.LoaiMonAn_DTO;
import com.microsoft.sqlserver.jdbc.StringUtils;
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
        
        QuanLyLoaiBanVaBan monAn_GUI = new QuanLyLoaiBanVaBan();
        monAn_GUI.setVisible(true);
    }
    
}
