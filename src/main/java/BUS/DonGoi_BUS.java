package BUS;

import DAO.DonGoi_DAO;
import DTO.Ban.CreateDonGoi_DTO;
import DTO.Ban.DonGoi_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoi_BUS {
    public ArrayList<DonGoi_DTO> getAllDonGoiByIdBan(int idBan){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        ArrayList<DonGoi_DTO> result = donGoi_DAO.getAllDonGoiByIdBan(idBan);
        
        return result;
    }
    
    public boolean createDonGoi(CreateDonGoi_DTO data){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.createDonGoi(data);
        
        return result;
    }    
    
    public boolean daTonTai(int idBan, int idMonAn){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.daTonTai(idBan, idMonAn);
        
        return result;       
    }
    
    public DonGoi_DTO getDonGoiById(int idBan, int idMonAn){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        DonGoi_DTO result = donGoi_DAO.getDonGoiById(idBan, idMonAn);
        
        return result;
    }
}
