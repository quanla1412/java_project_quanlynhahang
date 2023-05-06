/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKe_DAO;
import DTO.ThongKe.DoanhThuNgay_DTO;
import DTO.ThongKe.DoanhThuNguoi_DTO;
import DTO.ThongKe.DoanhThuThang_DTO;
import DTO.ThongKe.DoanhThuTheoLoaiMonAn_DTO;
import DTO.ThongKe.SoLuongTheoMonAn_DTO;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class ThongKe_BUS {
    public ArrayList<DoanhThuThang_DTO> getAllDoanhThuTheoThang(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<DoanhThuThang_DTO> result = thongKe_DAO.getAllDoanhThuTheoThang();
        
        return result;
    }
    
    public ArrayList<DoanhThuNgay_DTO> getAllDoanhThuTheo7NgayGanNhat(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<DoanhThuNgay_DTO> result = thongKe_DAO.getAllDoanhThuTheo7NgayGanNhat();
        
        return result;
    }
    
    public ArrayList<DoanhThuNguoi_DTO> getAllDoanhThuTheoNhanVien(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<DoanhThuNguoi_DTO> result = thongKe_DAO.getAllDoanhThuTheoNhanVien();
        
        return result;
    }
    
    public ArrayList<DoanhThuNguoi_DTO> getAllDoanhThuTheoKhachHang(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<DoanhThuNguoi_DTO> result = thongKe_DAO.getAllDoanhThuTheoKhachHang();
        
        return result;
    }
    
    public ArrayList<DoanhThuTheoLoaiMonAn_DTO> getAllDoanhThuTheoLoaiMonAn(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<DoanhThuTheoLoaiMonAn_DTO> result = thongKe_DAO.getAllDoanhThuTheoLoaiMonAn();
        
        return result;
    }
    
    public ArrayList<SoLuongTheoMonAn_DTO> getAllSoLuongTheoMonAnTheoThang(){
        ThongKe_DAO thongKe_DAO = new ThongKe_DAO();
        ArrayList<SoLuongTheoMonAn_DTO> result = thongKe_DAO.getAllSoLuongTheoMonAnTheoThang();
        
        return result;
    }
}
