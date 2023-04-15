/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChucVu_DAO;
import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateChucVu_DTO;
import java.util.ArrayList;

/**
 *
 * @author dinhn
 */
public class ChucVu_BUS {
    private final ChucVu_DAO chucVu_DAO = new ChucVu_DAO();
    
    public ArrayList<ChucVu_DTO> getAllChucVu(){
      
        ArrayList<ChucVu_DTO> result = chucVu_DAO.getAllChucVu();
        
        return result;
    }
    
   public ChucVu_DTO getChucVuByID(int id){
        ChucVu_DTO result = chucVu_DAO.getChucVuById(id);
        
        return result;
    }
    
    public boolean createChucVu(CreateChucVu_DTO data){
        if(chucVu_DAO.alreadyHasName(data.getTen()))
            return false;
        
        boolean result = chucVu_DAO.createChucVu(data);
        
        return result;
    }
    
     public boolean updateChucVu(ChucVu_DTO data){
        if(chucVu_DAO.alreadyHasName(data.getTen()))
            return false;
        
        boolean result = chucVu_DAO.updateChucVu(data);
        
        return result;
    }
    
    public boolean deleteChucVuById(int id){
        boolean result = chucVu_DAO.deleteChucVu(id);
        
        return result;
    }
     public int deletenhieuChucVu(ArrayList<Integer> listID){
        int result = chucVu_DAO.deletenhieuChucVu(listID);
        
        return result;
    }
    
}
