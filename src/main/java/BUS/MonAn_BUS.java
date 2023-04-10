package BUS;

import DAO.MonAn_DAO;
import DTO.MonAn.MonAn_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class MonAn_BUS {
    public ArrayList<MonAn_DTO> getAllMonAn(){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getAllMonAn();
        
        return result;
    }
}
