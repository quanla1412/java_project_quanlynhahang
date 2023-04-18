/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang.CreateKhachHang_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.KhachHang.SearchKhachHang_DTO;
import DTO.KhachHang.UpdateKhachHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class KhachHang_BUS {
    public ArrayList<KhachHang_DTO> getAllKhachHang(){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> result = khachHang_DAO.getAllKhachHang();
        
        return result;
    }

    public ArrayList<KhachHang_DTO> searchKhachHang(SearchKhachHang_DTO searchData){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> result = khachHang_DAO.searchKhachHang(searchData);
        
        return result;
    }
    
    public ArrayList<KhachHang_DTO> findKhachHangBySDT(String sdt){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> result = khachHang_DAO.findKhachHangBySDT(sdt);
        
        return result;
    }
    
    public KhachHangFull_DTO getKhachHangFullById(int id){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        KhachHangFull_DTO result = khachHang_DAO.getKhachHangFullById(id);
        
        return result;
    }
    
    public boolean createKhachHang(CreateKhachHang_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
        if(khachHang_DAO.hasSoDienThoaiOrEmail(data.getSdt(), data.getEmail()))
            return false;
        
        boolean result = khachHang_DAO.createKhachHang(data);
    
        return result;
    }
    
    public boolean updateKhachHang(UpdateKhachHang_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
        if(khachHang_DAO.hasSoDienThoaiOrEmail(data.getId(), data.getSdt(), data.getEmail()))
            return false;
        
        boolean result = khachHang_DAO.updateKhachHang(data);
    
        return result;
    }
    
    public boolean deleteKhachHangById(int id){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        boolean result = khachHang_DAO.deleteKhachHangById(id);
    
        return result;
    }
    
    public void importKhachHang(KhachHangFull_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        if(khachHang_DAO.hasId( data.getId()))
        {
            UpdateKhachHang_DTO up = new UpdateKhachHang_DTO(data.getId(), data.getLoaiKhachHang().getId(), data.getTen(), data.getSdt(), data.getDiemTichLuy(), data.getEmail(), data.getNgaySinh(), data.isGioiTinhNam());
            updateKhachHang(up);
        }
        else{
            CreateKhachHang_DTO up = new CreateKhachHang_DTO(data.getTen(), data.getSdt(), data.getEmail(), data.getNgaySinh(), data.isGioiTinhNam());
            createKhachHang(up);
        }
    }  
}
