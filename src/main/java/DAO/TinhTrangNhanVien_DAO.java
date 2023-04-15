/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien.TinhTrangNhanVien_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dinhn
 */
public class TinhTrangNhanVien_DAO {
    public ArrayList<TinhTrangNhanVien_DTO> getAllTinhTrangNhanVien(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<TinhTrangNhanVien_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TinhTrangNhanVien";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                TinhTrangNhanVien_DTO tinhTrang = new TinhTrangNhanVien_DTO();
                
                tinhTrang.setId(rs.getInt("TTNV_ID"));
                tinhTrang.setTen(rs.getNString("TTNV_Ten"));
                
                
                result.add(tinhTrang);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
