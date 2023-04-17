package BUS;

import Constraints.TinhTrangBanConstraints;
import DAO.Ban_DAO;
import DAO.DonGoi_DAO;
import DTO.Ban.CreateDonGoi_DTO;
import DTO.Ban.DonGoi_DTO;
import DTO.Ban.UpdateDonGoi_DTO;
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

    public boolean updateDonGoi(UpdateDonGoi_DTO updateDonGoi_DTO) {
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.updateDonGoi(updateDonGoi_DTO);
        
        return result;
    }
    
    public boolean deleteDonGoi(int idBan, int idMonAn) {
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.deleteDonGoi(idBan, idMonAn);
        
        return result;
    }
    
    public boolean chuyenBan(int idBanCu, int idBanMoi){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        Ban_DAO ban_DAO = new Ban_DAO();
        boolean result = false;
        
        if(ban_DAO.hasDonGoi(idBanMoi))
            return false;
        
        if(ban_DAO.hasDonGoi(idBanCu)){
            result = donGoi_DAO.chuyenBan(idBanCu, idBanMoi);
            if(!result)
                return false;

            result = ban_DAO.hasDonGoi(idBanMoi) && !ban_DAO.hasDonGoi(idBanCu);
            if(!result)
                return false;
        }
        
        result = ban_DAO.changeTinhTrangBan(idBanMoi, TinhTrangBanConstraints.DANG_PHUC_VU);        
        return result;
    }
}
