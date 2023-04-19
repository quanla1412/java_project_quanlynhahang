/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Constraints.GioiTinhConstraints;
import DTO.KhachHang.CreateKhachHang_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.KhachHang.LoaiKhachHang_DTO;
import DTO.KhachHang.SearchKhachHang_DTO;
import DTO.KhachHang.UpdateKhachHang_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;


/**
 *
 * @author tuant
 */
public class KhachHang_DAO {
    public ArrayList<KhachHang_DTO> getAllKhachHang(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<KhachHang_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT KH_ID, KH_Ten, KH_Sdt, KH_DiemTichLuy, LKH_Ten "
                    + "FROM KhachHang, LoaiKhachHang "
                    + "WHERE KhachHang.LKH_ID = LoaiKhachHang.LKH_ID";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                KhachHang_DTO khachHang = new KhachHang_DTO();
                khachHang.setId(rs.getInt("KH_ID"));
                khachHang.setTen(rs.getNString("KH_Ten"));
                khachHang.setSdt(rs.getString("KH_Sdt"));
                khachHang.setDiemTichLuy(rs.getInt("KH_DiemTichLuy"));
                LoaiKhachHang_DAO lkh = new LoaiKhachHang_DAO();
                khachHang.setLoaiKhachHang(rs.getNString("LKH_Ten"));
                
                result.add(khachHang);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public KhachHangFull_DTO getKhachHangFullById(int idKH){
        Connection con = ConnectDatabase.openConnection();
        KhachHangFull_DTO khachHangFull = new KhachHangFull_DTO();
        try {
            String sql = "SELECT KH_ID, KH_Ten, KH_SDT, KH_DiemTichLuy, KH_Email, KH_NgaySinh, LKH_ID, KH_GioiTinhNam "
                    + "FROM KhachHang "
                    + " WHERE KH_ID = " + idKH;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){ 
                khachHangFull.setId(rs.getInt("KH_ID"));
                khachHangFull.setTen(rs.getNString("KH_Ten"));
                khachHangFull.setSdt(rs.getString("KH_SDT"));
                khachHangFull.setDiemTichLuy(rs.getInt("KH_DiemTichLuy"));
                khachHangFull.setEmail(rs.getString("KH_Email"));
                khachHangFull.setNgaySinh(rs.getTimestamp("KH_NgaySinh"));
                khachHangFull.setGioiTinhNam(rs.getBoolean("KH_GioiTinhNam"));
                LoaiKhachHang_DAO lkh = new LoaiKhachHang_DAO();
                khachHangFull.setLoaiKhachHang(lkh.getLoaiKhachHangById(rs.getInt("LKH_ID")));
            }
        } catch (SQLException ex ){
            System.out.println(ex); 
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return khachHangFull;
    }
    
    
    public boolean createKhachHang(CreateKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO KhachHang(KH_Ten, KH_SDT, KH_DiemTichLuy, KH_Email, KH_NgaySinh, LKH_ID, KH_GioiTinhNam) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            statement.setString(2, data.getSdt());
            statement.setInt(3, 0);
            statement.setString(4, data.getEmail());
            statement.setTimestamp(5, data.getNgaySinh());
            statement.setInt(6, 1);
            statement.setBoolean(7, data.isGioiTinhNam());
            
            if (statement.executeUpdate() >= 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    public boolean updateKhachHang(UpdateKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE KhachHang "
                    + "SET LKH_ID = ?, KH_Ten = ?, KH_SDT = ?, KH_DiemTichLuy = ?, KH_Email = ?, KH_NgaySinh = ?, KH_GioiTinhNam = ? "
                    + "WHERE KH_ID = " + data.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getLoaiKhachHang());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setString(3, data.getSdt());
            preparedStatement.setInt(4, data.getDiemTichLuy());
            preparedStatement.setNString(5, data.getEmail());
            preparedStatement.setTimestamp(6, data.getNgaySinh());
            preparedStatement.setBoolean(7, data.isGioiTinhNam());
            
            
            if(preparedStatement.executeUpdate() >= 1){
                result = true;                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    public boolean deleteKhachHangById(int idKhachHang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM KhachHang WHERE KH_ID = "+ idKhachHang;
            PreparedStatement statement = con.prepareStatement(sql);
            
            
            while(statement.executeUpdate() >= 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<KhachHang_DTO> searchKhachHang(SearchKhachHang_DTO searchData){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<KhachHang_DTO> result = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT KH_ID, KH_Ten, KH_Sdt, KH_DiemTichLuy, LKH_Ten " 
                                                   + "FROM KhachHang, LoaiKhachHang "
                                                   + "WHERE KhachHang.LKH_ID = LoaiKhachHang.LKH_ID ");
            
            if(searchData.getIdOrName() != null && !searchData.getIdOrName().isBlank())
                sql.append(" AND (KH_Ten LIKE N'%").append(searchData.getIdOrName()).append("%' OR KH_ID LIKE '%").append(searchData.getIdOrName()).append("%') ");
            
            if(searchData.getLoaiKhachHang() > 0)
                sql.append(" AND KhachHang.LKH_ID = ").append(searchData.getLoaiKhachHang());
            
            if(searchData.isGioiTinh() >= 0)
                sql.append(" AND KH_GioiTinhNam = " + searchData.isGioiTinh());            
            
            if(searchData.getSdt() != null && !searchData.getSdt().isBlank())
                sql.append(" AND KH_SDT LIKE '%" + searchData.getSdt() + "%'");
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());        
            
            while(resultSet.next()){
                KhachHang_DTO khachHang = new KhachHang_DTO();
                khachHang.setId(resultSet.getInt("KH_ID"));
                khachHang.setTen(resultSet.getNString("KH_Ten"));
                khachHang.setSdt(resultSet.getString("KH_Sdt"));
                khachHang.setDiemTichLuy(resultSet.getInt("KH_DiemTichLuy"));
                khachHang.setLoaiKhachHang(resultSet.getNString("LKH_Ten"));
                
                result.add(khachHang);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public KhachHangFull_DTO findKhachHangFullBySDT(String sdt){
        Connection con = ConnectDatabase.openConnection();
        LoaiKhachHang_DAO loaiKhachHang_DAO = new LoaiKhachHang_DAO();
        KhachHangFull_DTO khachHang = null;
        try {
            String sql = "SELECT * FROM KhachHang WHERE KH_SDT = '" + sdt + "'";            
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            if(resultSet.next()){
                khachHang = new KhachHangFull_DTO();
                khachHang.setId(resultSet.getInt("KH_ID"));
                khachHang.setTen(resultSet.getNString("KH_Ten"));
                khachHang.setSdt(resultSet.getString("KH_Sdt"));
                khachHang.setDiemTichLuy(resultSet.getInt("KH_DiemTichLuy"));
                khachHang.setEmail(resultSet.getString("KH_Email"));
                khachHang.setNgaySinh(resultSet.getTimestamp("Kh_NgaySinh"));
                khachHang.setLoaiKhachHang(
                        loaiKhachHang_DAO.getLoaiKhachHangById(resultSet.getInt("LKH_ID")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        
        return khachHang;
    }

    public boolean hasSoDienThoaiOrEmail(String sdt, String email){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT KH_ID From KhachHang "
                    + "WHERE KH_SDT = '" + sdt + "' OR KH_Email = '" + email + "'";
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean hasSoDienThoaiOrEmail(int idKHHienTai, String sdt, String email){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT KH_ID From KhachHang "
                    + "WHERE (KH_SDT = '" + sdt + "' OR KH_Email = '" + email + "') AND KH_ID != " + idKHHienTai;
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    public boolean hasId(int idKHHienTai){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT KH_ID From KhachHang "
                    + "WHERE KH_ID = " + idKHHienTai;
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
}
