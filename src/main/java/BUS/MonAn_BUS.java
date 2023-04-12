package BUS;

import DAO.MonAn_DAO;
import DTO.MonAn.MonAn_DTO;
import DTO.MonAn.TinhTrangMonAn_DTO;
import DTO.Search.SearchMonAn_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class MonAn_BUS {
    public final int TTMA_CON_PHUC_VU = 1;
    public final int TTMA_HET = 2;
    public final int TTMA_DA_XOA = 3;
    
    public ArrayList<MonAn_DTO> getAllMonAn(){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getAllMonAn();
        
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
    
    public ArrayList<MonAn_DTO> getListMonAnByIdAndName(String query){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getListMonAnByIdAndName(query);
        
        return result;
    }
    
    public ArrayList<MonAn_DTO> getListMonAnByLoaiMonAn(int id){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getListMonAnByLoaiMonAn(id);
        
        return result;
    }
    
    public ArrayList<MonAn_DTO> getListMonAnByIdNameAndLMA(String idName, int LMA_id){
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        ArrayList<MonAn_DTO> result = monAn_DAO.getListMonAnByIdNameAndLMA(idName, LMA_id);
        
        return result;        
    }
}
