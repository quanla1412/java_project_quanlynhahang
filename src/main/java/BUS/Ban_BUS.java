package BUS;

import DAO.Ban_DAO;
import DTO.Ban.BanFull_DTO;
import DTO.Ban.Ban_DTO;
import DTO.Ban.CreateBan_DTO;
import DTO.Ban.TinhTrangBan_DTO;
import DTO.Ban.UpdateBan_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class Ban_BUS {
    public ArrayList<Ban_DTO> getAllBan(){
        Ban_DAO ban_DAO = new Ban_DAO();
        ArrayList<Ban_DTO> result = ban_DAO.getAllBan();
        
        return result;
    }
    
    public ArrayList<TinhTrangBan_DTO> getAllTinhTrangBan(){
        Ban_DAO ban_DAO = new Ban_DAO();
        ArrayList<TinhTrangBan_DTO> result = ban_DAO.getAllTinhTrangBan();
        
        return result;
    }
    
    public BanFull_DTO getBanFullById(int id){
        Ban_DAO ban_DAO = new Ban_DAO();
        BanFull_DTO result = ban_DAO.getBanFullById(id);
        
        return result;
    }
    
    public boolean createBan(CreateBan_DTO data){
        Ban_DAO ban_DAO = new Ban_DAO();
        boolean result = ban_DAO.createBan(data);
    
        return result;
    }
    
    public boolean updateBan(UpdateBan_DTO data){
        Ban_DAO ban_DAO = new Ban_DAO();
        boolean result = ban_DAO.updateBan(data);
        
        return result;
    }
    
    public boolean deleteBanById(int id){
        Ban_DAO ban_DAO = new Ban_DAO();
        boolean result = ban_DAO.deleteBan(id);
        
        return result;
    }
    
    public int deleteNhieuBanByListId(ArrayList<Integer> listId){
        Ban_DAO ban_DAO = new Ban_DAO();
        int result = ban_DAO.deleteNhieuBan(listId);
        
        return result;
    }
}
