/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVien_DAO;
import DTO.NhanVien.CreateNhanVien_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.NhanVien.SearchNhanVien_DTO;
import DTO.NhanVien.UpdateNhanVien_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dinhn
 */
public class NhanVien_BUS {
    
    public ArrayList<NhanVien_DTO> getAllNhanVien(){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        ArrayList<NhanVien_DTO> result = nhanVien_DAO.getAllNhanVien();
   
        return result;
    }
    
    public NhanVienFull_DTO getNhanVienbyMa(String ma){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        
        NhanVienFull_DTO result = nhanVien_DAO.getNhanVienbyMa(ma);
        
        return result;
    }
    
   
    public boolean createNhanVien(CreateNhanVien_DTO data){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
     
        if(nhanVien_DAO.hasMaNV(data.getMa()) || nhanVien_DAO.hasSoDienThoaiOrEmail(data.getSoDienThoai(), data.getEmail()))
        {
            return false;
        }
        boolean result = nhanVien_DAO.createNhanVien(data);
    
        return result;
    }
    
    public boolean updateNhanVien(UpdateNhanVien_DTO data){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        if(nhanVien_DAO.hasSoDienThoaiOrEmail(data.getMa(),data.getSoDienThoai(),data.getEmail()))
            return false;
        boolean result = nhanVien_DAO.updateNhanVien(data);
        return result;
    }
    
    public boolean deleteNhanVien(String NVMa){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        boolean result = nhanVien_DAO.deleteNhanVien(NVMa);
        
        return result;
    }
    
    public ArrayList<NhanVien_DTO> searchNhanVien(SearchNhanVien_DTO searchData) {
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        ArrayList<NhanVien_DTO> result = nhanVien_DAO.searchNhanVien(searchData);
        
        return result;
    }
    
    

    
}
