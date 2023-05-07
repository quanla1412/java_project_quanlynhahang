package BUS;


import DAO.LoaiBan_DAO;
import DTO.Ban.CreateLoaiBan_DTO;
import DTO.Ban.LoaiBan_DTO;
import java.util.ArrayList;


/**
 *
 * @author LeAnhQuan
 */
public class LoaiBan_BUS {
    private final LoaiBan_DAO loaiBan_DAO = new LoaiBan_DAO();
    
    public ArrayList<LoaiBan_DTO> getAllLoaiBan(){
        ArrayList<LoaiBan_DTO> listLoaiBan = loaiBan_DAO.getAllLoaiBan();
        
        return listLoaiBan;
    }
    
    public LoaiBan_DTO getLoaiBanByID(int id){
        LoaiBan_DTO result = loaiBan_DAO.getLoaiBanByID(id);
        
        return result;
    }
    
    public boolean createLoaiBan(CreateLoaiBan_DTO data){
        if(loaiBan_DAO.alreadyHasName(data.getTen()))
            return false;
        
        boolean result = loaiBan_DAO.createLoaiBan(data);
        
        return result;
    }
    
    public boolean updateLoaiBan(LoaiBan_DTO data){
        if(loaiBan_DAO.alreadyHasName(data.getId(),data.getTen()))
            return false;
        
        boolean result = loaiBan_DAO.updateLoaiBan(data);
        
        return result;
    }
    
    public boolean deleteLoaiBanById(int id){
        boolean result = loaiBan_DAO.deleteLoaiBan(id);
        
        return result;
    }
    
    public int deleteNhieuLoaiBan(ArrayList<Integer> listID){
        int result = loaiBan_DAO.deleteNhieuLoaiBan(listID);
        
        return result;
    }
}
