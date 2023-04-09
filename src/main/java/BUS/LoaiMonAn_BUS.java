package BUS;

import DAO.LoaiMonAn_DAO;
import DTO.MonAn.LoaiMonAn_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAn_BUS {
    public ArrayList<LoaiMonAn_DTO> getAllLoaiMonAn(){
        LoaiMonAn_DAO loaiMonAn_DAO = new LoaiMonAn_DAO();
        ArrayList<LoaiMonAn_DTO> result = loaiMonAn_DAO.getAllLoaiMonAn();
        
        return result;
    }
    
    public boolean createLoaiMonAn(String data){
        LoaiMonAn_DAO loaiMonAn_DAO = new LoaiMonAn_DAO();
        
        if(loaiMonAn_DAO.alreadyHasName(data))
            return false;
        
        boolean result = loaiMonAn_DAO.createLoaiMonAn(data);
        
        return result;
    }
    
    public boolean deleteLoaiMonAnById(int id){
        LoaiMonAn_DAO loaiMonAn_DAO = new LoaiMonAn_DAO();
        boolean result = loaiMonAn_DAO.deleteLoaiMonAn(id);
        
        return result;        
    }
    
    public int deleteNhieuLoaiMonAn(ArrayList<Integer> listId){
        LoaiMonAn_DAO loaiMonAn_DAO = new LoaiMonAn_DAO();
        int result = loaiMonAn_DAO.deleteNhieuLoaiMonAn(listId);
        
        return result;        
    }
}
