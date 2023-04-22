package BUS;

import DAO.HoaDon_DAO;
import DTO.HoaDon.HoaDonFull_DTO;
import DTO.HoaDon.HoaDon_DTO;
import DTO.HoaDon.UpdateHoaDon_DTO;
import DTO.Search.SearchHoaDon_DTO;
import java.sql.Array;
import java.util.ArrayList;



public class HoaDon_BUS {
    
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        ArrayList<HoaDon_DTO> result = hoaDon_DAO.getAllHoaDon();
        
        return result;
    }
    
    public ArrayList<HoaDon_DTO> searchHoaDon(SearchHoaDon_DTO searchData){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        ArrayList<HoaDon_DTO> result = hoaDon_DAO.searchHoaDon(searchData);
        
        return result;
    }
    
    public HoaDonFull_DTO getHoaDonFullById(int id){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        HoaDonFull_DTO result = hoaDon_DAO.getHoaDonFullById(id);
        
        if(result.getId() < 0){
            return null;
        }
        return result;
    }
    
    public boolean deleteHoaDon(int idHoaDon){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        boolean result = hoaDon_DAO.deleteHoaDon(idHoaDon);
        
        return result;
    }
    
}
