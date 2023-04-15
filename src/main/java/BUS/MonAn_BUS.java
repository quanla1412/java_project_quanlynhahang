package BUS;

import Constraints.TinhTrangMonAnConstraints;
import DAO.MonAn_DAO;
import DTO.MonAn.CreateMonAn_DTO;
import DTO.MonAn.MonAnFull_DTO;
import DTO.MonAn.MonAn_DTO;
import DTO.MonAn.TinhTrangMonAn_DTO;
import DTO.MonAn.UpdateMonAn_DTO;
import DTO.Search.SearchMonAn_DTO;
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
    
    public ArrayList<MonAn_DTO> getListMonAnByLoaiMonAn(int idLoaiMonAn){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getListMonAnByLoaiMonAn(idLoaiMonAn);
        
        return result;        
    }
    
    public ArrayList<MonAn_DTO> searchMonAn(SearchMonAn_DTO searchData){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.searchMonAn(searchData);
        
        return result;
    }
    
    public ArrayList<TinhTrangMonAn_DTO> getAllTinhTrangMA(){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<TinhTrangMonAn_DTO> result = monAn_DAO.getAllTinhTrangMA();
        
        return result;
    }
    
    public MonAnFull_DTO getMonAnFullById(int id){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        MonAnFull_DTO result = monAn_DAO.getMonAnFullById(id);
        
        if(result.getId() < 0)
            return null;
        
        return result;        
    }

    public boolean createMonAn(CreateMonAn_DTO createMonAn_DTO) {
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        if(monAn_DAO.alreadyHasName(createMonAn_DTO.getTen()))
            return false;
        
        return monAn_DAO.createMonAn(createMonAn_DTO);
    }

    public boolean updateMonAn(UpdateMonAn_DTO updateMonAn_DTO) {
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        if(monAn_DAO.alreadyHasName(updateMonAn_DTO.getId(), updateMonAn_DTO.getTen()))
            return false;
        
        return monAn_DAO.updateMonAn(updateMonAn_DTO);
    }

    public boolean deleteMonAn(int idMonAn) {
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        boolean result = monAn_DAO.chuyenTinhTrangMonAn(idMonAn, TinhTrangMonAnConstraints.DA_XOA);
        
        return result;
    }

    public int deleteNhieuMonAn(ArrayList<Integer> listID) {
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        int total = 0;
        for(int idMonAn : listID){
            boolean result = monAn_DAO.chuyenTinhTrangMonAn(idMonAn, TinhTrangMonAnConstraints.DA_XOA);
            if(result)
                total++;
        }
        
        return total;
    }

    public boolean chuyenTinhTrangMonAn(int idMonAn, int tinhTrangMonAn) {
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        boolean result = monAn_DAO.chuyenTinhTrangMonAn(idMonAn, tinhTrangMonAn);
        
        return result;
    }
}
