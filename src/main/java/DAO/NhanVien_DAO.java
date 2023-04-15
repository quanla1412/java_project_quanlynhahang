/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateNhanVien_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.NhanVien.TinhTrangNhanVien_DTO;
import DTO.NhanVien.UpdateNhanVien_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dinhn
 */
public class NhanVien_DAO {
     public NhanVienFull_DTO getNhanVienbyMa(String ma) {
        Connection con = ConnectDatabase.openConnection();
        NhanVienFull_DTO result = new NhanVienFull_DTO();
        String sql = "SELECT NV_Ma, NhanVien.TTNV_ID, TinhTrangNhanVien.TTNV_Ten, NhanVien.CV_ID, ChucVu.CV_Ten, NV_HoTen, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_SDT, NV_DiaChi "
                                            + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                                            + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID AND NV_Ma LIKE '" + ma + "'";
        try {
            
           
           Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql   
                                                        );
            if(resultSet.next()){
               
             
                result.setMa(resultSet.getString("NV_Ma"));
                result.setHoTen(resultSet.getNString("NV_HoTen"));
                result.setNgaySinh(resultSet.getTimestamp("NV_NgaySinh"));
                result.setGioiTinhNam(resultSet.getBoolean("NV_GioiTinhNam"));
                result.setEmail(resultSet.getString("NV_Email"));
                result.setSoDienThoai(resultSet.getString("NV_SDT"));
                result.setDiaChi(resultSet.getNString("NV_DiaChi"));
                
               
                TinhTrangNhanVien_DTO tinhTrang = new TinhTrangNhanVien_DTO();
                tinhTrang.setId(resultSet.getInt("TTNV_ID"));
                tinhTrang.setTen(resultSet.getNString("TTNV_Ten"));
                
                ChucVu_DTO chucVu = new ChucVu_DTO();
                chucVu.setId(resultSet.getInt("CV_ID"));
                chucVu.setTen(resultSet.getNString("CV_Ten"));
                
                result.setChucVu(chucVu);
                result.setTinhTrangNhanVien(tinhTrang);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
     }
    
     
     
       public ArrayList<NhanVien_DTO> getAllNhanVien() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<NhanVien_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT NV_MA, NV_HoTen, NV_SDT, TTNV_Ten, CV_Ten "
                        + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                        + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID AND NhanVien.TTNV_ID != 3";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        
            while(rs.next()){
                NhanVien_DTO nhanVien_DTO = new NhanVien_DTO();
                
                nhanVien_DTO.setMa(rs.getString("NV_Ma"));
                nhanVien_DTO.setHoTen(rs.getNString("NV_HoTen"));
                nhanVien_DTO.setSdt(rs.getString("NV_SDT"));
                nhanVien_DTO.setTinhTrangNhanVien(rs.getNString("TTNV_Ten"));
                nhanVien_DTO.setTenChucVu(rs.getNString("CV_Ten"));
                
                
                result.add(nhanVien_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
     }
     
      public boolean createNhanVien(CreateNhanVien_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO NhanVien(NV_MA, TTNV_ID, CV_ID, NV_HoTen, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_SDT, NV_DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, data.getMa());
            statement.setInt(2, data.getIdTinhTrangNhanVien());
            statement.setInt(3, data.getIdChucVu());
            statement.setNString(4, data.getHoTen());
            statement.setDate(5, data.getNgaySinh());
            statement.setBoolean(6, data.isGioiTinhNam());
            statement.setString(7, data.getEmail());
            statement.setString(8, data.getSoDienThoai());
            statement.setString(9, data.getDiaChi());
            
            if(statement.executeUpdate() >= 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
      
       public boolean updateNhanVien(UpdateNhanVien_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE NhanVien SET TTNV_ID = ?, CV_ID = ?, NV_HoTen = ?, NV_NgaySinh = ?, NV_Email = ?, NV_SDT = ?, NV_DiaChi = ? WHERE NV_MA = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdTinhTrangNhanVien());
            statement.setInt(2, data.getIdChucVu());
            statement.setNString(3, data.getHoTen());
            statement.setDate(4, data.getNgaySinh());
            statement.setString(5, data.getEmail());
            statement.setString(6, data.getSoDienThoai());
            statement.setString(7, data.getDiaChi());
            statement.setString(8, data.getMa());
            
            
            if(statement.executeUpdate() >= 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
       public boolean deleteNhanVien (String NVMa){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM NhanVien WHERE NV_MA = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, NVMa);
            
            if(statement.executeUpdate() >= 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
       
      public int deleteNhieuNhanVien(ArrayList<String> listmaNhanVien){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        
        try {
            String sql = "DELETE FROM NhanVien WHERE NV_Ma = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            for(String ma : listmaNhanVien){
                statement.setString(1, ma);
                
                if(statement.executeUpdate() >= 1){
                    result++;
                }   
            }       
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }  
       
       
}
