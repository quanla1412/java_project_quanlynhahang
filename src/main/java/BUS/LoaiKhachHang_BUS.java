/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Constraints.LoaiKhachHangConstraints;
import DAO.LoaiKhachHang_DAO;
import DTO.KhachHang.CreateLoaiKhachHang_DTO;
import DTO.KhachHang.LoaiKhachHang_DTO;
import DTO.KhachHang.UpdateLoaiKhachHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class LoaiKhachHang_BUS {
    public ArrayList<LoaiKhachHang_DTO> getAllLoaiKhachHang(){
        LoaiKhachHang_DAO loaiKhachHang_DAO = new LoaiKhachHang_DAO();
        ArrayList<LoaiKhachHang_DTO> result = loaiKhachHang_DAO.getAllLoaiKhachHang();
        
        return result;
    }
    
    public LoaiKhachHang_DTO getLoaiKhachHangById(int id){
        LoaiKhachHang_DAO loaiKhachHang_DAO = new LoaiKhachHang_DAO();
        LoaiKhachHang_DTO result = loaiKhachHang_DAO.getLoaiKhachHangById(id);
        
        return result;
    }
    
    public boolean createLoaiKhachHang(CreateLoaiKhachHang_DTO data){
        LoaiKhachHang_DAO loaiKhachHang_DAO = new LoaiKhachHang_DAO();
        boolean result = loaiKhachHang_DAO.createLoaiKhachHang(data);
    
        return result;
    }
    
    public boolean updateLoaiKhachHang(UpdateLoaiKhachHang_DTO data){
        LoaiKhachHang_DAO loaiKhachHang_DAO = new LoaiKhachHang_DAO();
        
        if(data.getId() == LoaiKhachHangConstraints.LOAI_KHACH_HANG_LOCKED && data.getDiemToiThieu() != 0)
            return false;
        
        boolean result = loaiKhachHang_DAO.updateLoaiKhachHang(data);
    
        return result;
    }
    
    
}
