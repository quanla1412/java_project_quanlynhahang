/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKe.DoanhThuNgay_DTO;
import DTO.ThongKe.DoanhThuNguoi_DTO;
import DTO.ThongKe.DoanhThuThang_DTO;
import DTO.ThongKe.DoanhThuTheoLoaiMonAn_DTO;
import DTO.ThongKe.SoLuongTheoMonAn_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class ThongKe_DAO {
    public ArrayList<DoanhThuThang_DTO> getAllDoanhThuTheoThang(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DoanhThuThang_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT MONTH(HD_NgayGio) as month, SUM(HD_TongGia)/(SELECT top (1) SUM(HD_TongGia)/1.0 " 
                        +"FROM HoaDon GROUP BY MONTH(HD_NgayGio))*100 as tongGia "
                        + "FROM HoaDon WHERE YEAR(HD_NgayGio) = YEAR(GETDATE()) AND HD_ID != 1 GROUP BY MONTH(HD_NgayGio)";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DoanhThuThang_DTO doanhThu = new DoanhThuThang_DTO();  
                doanhThu.setThang(rs.getString("month"));
                doanhThu.setTongTien(rs.getDouble("tongGia"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    public ArrayList<DoanhThuNgay_DTO> getAllDoanhThuTheo7NgayGanNhat(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DoanhThuNgay_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT HD_NgayGio, SUM(HD_TongGia)/1000000.0 as tongGia FROM HoaDon WHERE HD_NgayGio >= DATEADD(day, -7, GETDATE()) GROUP BY HD_NgayGio";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DoanhThuNgay_DTO doanhThu = new DoanhThuNgay_DTO();  
                doanhThu.setDate(rs.getTimestamp("HD_NgayGio"));
                doanhThu.setTongTien(rs.getDouble("tongGia"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;   
    }
    public ArrayList<DoanhThuNguoi_DTO> getAllDoanhThuTheoNhanVien(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DoanhThuNguoi_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT TOP (5) NV_HoTen, SUM(HD_TongGia)/1000000.0 as tongGia "
                    +"FROM HoaDon, NhanVien WHERE NhanVien.NV_Ma=HoaDon.NV_Ma AND YEAR(HD_NgayGio) = YEAR(GETDATE()) AND HD_ID != 1 GROUP BY NV_HoTen ORDER BY tongGia DESC";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DoanhThuNguoi_DTO doanhThu = new DoanhThuNguoi_DTO();  
                doanhThu.setHoTen(rs.getNString("NV_HoTen"));
                doanhThu.setTongTien(rs.getDouble("tongGia"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;   
    }
    public ArrayList<DoanhThuNguoi_DTO> getAllDoanhThuTheoKhachHang(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DoanhThuNguoi_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT TOP (5) KH_Ten, SUM(HD_TongGia)/1000000.0 as tongGia "
                    +"FROM HoaDon, KhachHang WHERE KhachHang.KH_ID=HoaDon.KH_ID AND YEAR(HD_NgayGio) = YEAR(GETDATE()) AND HD_ID != 1"
                    +" GROUP BY KH_Ten ORDER BY tongGia DESC";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DoanhThuNguoi_DTO doanhThu = new DoanhThuNguoi_DTO();  
                doanhThu.setHoTen(rs.getNString("KH_Ten"));
                doanhThu.setTongTien(rs.getDouble("tongGia"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;   
    }
    public ArrayList<DoanhThuTheoLoaiMonAn_DTO> getAllDoanhThuTheoLoaiMonAn(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DoanhThuTheoLoaiMonAn_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT LoaiMonAn.LMA_Ten as tenLMA, SUM(HoaDon.HD_TongGia)/1000000.0 as tongGia "
                        +"FROM HoaDon, ChiTietHoaDon, MonAn, LoaiMonAn WHERE HoaDon.HD_ID = ChiTietHoaDon.HD_ID  AND HoaDon.HD_ID != 1"
                        +"AND ChiTietHoaDon.MA_ID = MonAn.MA_ID AND MonAn.LMA_ID = LoaiMonAn.LMA_ID "
                        +"AND YEAR(HD_NgayGio) = YEAR(GETDATE()) GROUP BY(LoaiMonAn.LMA_Ten)";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DoanhThuTheoLoaiMonAn_DTO doanhThu = new DoanhThuTheoLoaiMonAn_DTO();  
                doanhThu.setTenLMA(rs.getNString("tenLMA"));
                doanhThu.setTongTien(rs.getDouble("tongGia"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;   
    }
    
    public ArrayList<SoLuongTheoMonAn_DTO> getAllSoLuongTheoMonAnTheoThang(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<SoLuongTheoMonAn_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT TOP (5) MonAn.MA_Ten as tenMA, SUM(CTHD_SoLuong) as soLuong "
                        +"FROM HoaDon, ChiTietHoaDon, MonAn WHERE HoaDon.HD_ID = ChiTietHoaDon.HD_ID  AND HoaDon.HD_ID != 1 "
                        +"AND ChiTietHoaDon.MA_ID = MonAn.MA_ID AND MONTH(HD_NgayGio) = MONTH(GETDATE()) "
                        +"AND YEAR(HD_NgayGio) = YEAR(GETDATE())GROUP BY(MonAn.MA_Ten) ORDER BY soLuong DESC";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                SoLuongTheoMonAn_DTO doanhThu = new SoLuongTheoMonAn_DTO();  
                doanhThu.setTenMonAn(rs.getNString("tenMA"));
                doanhThu.setSoLuong(rs.getInt("soLuong"));
               
                result.add(doanhThu);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;   
    }
}
