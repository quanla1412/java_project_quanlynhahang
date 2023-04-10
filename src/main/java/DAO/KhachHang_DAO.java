/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang.CreateKhachHang_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.KhachHang.LoaiKhachHang_DTO;
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
                    + "WHERE KhachHang.KH_ID = LoaiKhachHang.LKH_ID ";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                LoaiKhachHang_DTO lkh = new LoaiKhachHang_DTO();
                lkh.setTen(rs.getNString("LKH_Ten"));
                
                KhachHang_DTO khachHang = new KhachHang_DTO();
                khachHang.setId(rs.getInt("KH_ID"));
                khachHang.setTen(rs.getNString("KH_Ten"));
                khachHang.setSdt(rs.getNString("KH_SDT"));
                khachHang.setDiemTichLuy(rs.getNString("KH_DiemTichLuy"));
                khachHang.setLoaiKhachHang(lkh);
                
                result.add(khachHang);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public KhachHangFull_DTO getKhachHangFullById(int idKhachHang){
        Connection con = ConnectDatabase.openConnection();
        KhachHangFull_DTO khachHangFull = new KhachHangFull_DTO();
        try {
            String sql = "SELECT KH_ID, KH_Ten, KH_SDT, KH_DiemTichLuy, KH_Email, KH_NgaySinh, LKH_Ten "
                    + "FROM KhachHang, LoaiKhachHang "
                    + " WHERE KH_ID = " + idKhachHang;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){                
                LoaiKhachHang_DTO lkh = new LoaiKhachHang_DTO();
                lkh.setTen(rs.getNString("LKH_Ten"));
                
                khachHangFull.setId(rs.getInt("KH_ID"));
                khachHangFull.setTen(rs.getNString("KH_Ten"));
                khachHangFull.setSdt(rs.getNString("KH_SDT"));
                khachHangFull.setDiemTichLuy(rs.getNString("KH_DiemTichLuy"));
                khachHangFull.setEmail(rs.getNString("KH_Email"));
                khachHangFull.setNgaySinh(rs.getTimestamp("KH_NgaySinh"));
                khachHangFull.setLoaiKhachHang(lkh);
            }
        } catch (SQLException ex ){
            System.out.println(ex); 
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return khachHangFull;
    }
    
    public ArrayList<KhachHang_DTO> getKhachHangByTimKiem(int idKhachHang, String ten, String gioiTinh, String loaiKhachHang){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<KhachHang_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT KH_ID, KH_Ten, KH_Sdt, KH_DiemTichLuy, LKH_Ten "
                    + "FROM KhachHang, LoaiKhachHang "
                    + "WHERE KhachHang.KH_ID = LoaiKhachHang.LKH_ID AND KH_ID = "+ idKhachHang 
                    + " AND KH_GioiTinh = " + gioiTinh + " AND KH_LoaiKhachHang = " + loaiKhachHang
                    + " AND KH_Ten = " + ten;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                LoaiKhachHang_DTO lkh = new LoaiKhachHang_DTO();
                lkh.setTen(rs.getNString("LKH_Ten"));
                
                KhachHang_DTO khachHang = new KhachHang_DTO();
                khachHang.setId(rs.getInt("KH_ID"));
                khachHang.setTen(rs.getNString("KH_Ten"));
                khachHang.setSdt(rs.getNString("KH_SDT"));
                khachHang.setDiemTichLuy(rs.getNString("KH_DiemTichLuy"));
                khachHang.setLoaiKhachHang(lkh);
                
                result.add(khachHang);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    public boolean createKhachHang(CreateKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO KhachHang(LKH_ID, KH-Ten, KH_SDT, KH_DiemTichLuy, KH_Email, KH_NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getLoaiKhachHang());
            statement.setString(2, data.getTen());
            statement.setString(3, data.getSdt());
            statement.setString(4,data.getDiemTichLuy());
            statement.setString(5, data.getEmail());
            statement.setTimestamp(6, data.getNgaySinh());
            
            while(statement.executeUpdate() > 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    public boolean UpdateKhachHang(UpdateKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE KhachHang"
                    + "SET LKH_ID = ?, KH_Ten = ?, KH_SDT = ?, KH_DiemTichLuy = ?, KH_Email = ?, KH_NgaySinh = ?"
                    + "WHERE KH_ID = " + data.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getLoaiKhachHang());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getSdt());
            preparedStatement.setNString(4, data.getDiemTichLuy());
            preparedStatement.setNString(5, data.getEmail());
            preparedStatement.setTimestamp(6, data.getNgaySinh());
            
            
            if(preparedStatement.executeUpdate() > 1){
                result = true;                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    public boolean deleteKhachHang(int idKhachHang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM KhachHang WHERE KH_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idKhachHang);
            
            while(statement.executeUpdate() > 1){
                result = true;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
