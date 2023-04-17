/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang.CreateLoaiKhachHang_DTO;
import DTO.KhachHang.LoaiKhachHang_DTO;
import DTO.KhachHang.UpdateLoaiKhachHang_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class LoaiKhachHang_DAO {
    public LoaiKhachHang_DTO getLoaiKhachHangById(int idLKH){
        Connection con = ConnectDatabase.openConnection();
        LoaiKhachHang_DTO lkh = new LoaiKhachHang_DTO();
        try {
            String sql = "SELECT * "
                    + "FROM LoaiKhachHang "
                    + " WHERE LKH_ID = " + idLKH;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                lkh.setId(rs.getInt("LKH_ID"));
                lkh.setTen(rs.getNString("LKH_Ten"));
                lkh.setDiemToiThieu(rs.getInt("LKH_DiemToiThieu"));
                lkh.setMucUuDai(rs.getDouble("LKH_MucUuDai")); 
            }
        } catch (SQLException ex ){
            System.out.println(ex); 
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return lkh;
    }
    public ArrayList<LoaiKhachHang_DTO> getAllLoaiKhachHang(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<LoaiKhachHang_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * "
                    + "FROM LoaiKhachHang ";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                LoaiKhachHang_DTO lkh = new LoaiKhachHang_DTO();
                lkh.setId(rs.getInt("LKH_ID"));
                lkh.setTen(rs.getNString("LKH_Ten"));
                lkh.setDiemToiThieu(rs.getInt("LKH_DiemToiThieu"));
                lkh.setMucUuDai(rs.getDouble("LKH_MucUuDai"));
                
                result.add(lkh);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean createLoaiKhachHang(CreateLoaiKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO LoaiKhachHang(LKH_Ten, LKH_DiemToiThieu, LKH_MucUuDai) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, data.getTen());
            statement.setInt(2, data.getDiemToiThieu());
            statement.setDouble(3, data.getMucUuDai());
            
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
    
    public boolean updateLoaiKhachHang(UpdateLoaiKhachHang_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE LoaiKhachHang "
                    + "SET LKH_Ten = ?, LKH_DiemToiThieu = ?, LKH_MucUuDai = ? "
                    + "WHERE LKH_ID = " + data.getId();
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getDiemToiThieu());
            statement.setDouble(3, data.getMucUuDai());
            
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
}
