package DAO;

import DTO.MonAn.LoaiMonAnFull_DTO;
import DTO.MonAn.LoaiMonAn_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAn_DAO {
    public ArrayList<LoaiMonAn_DTO> getAllLoaiMonAn() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<LoaiMonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn");
        
            while(resultSet.next()){
                LoaiMonAn_DTO loaiMonAn_DTO = new LoaiMonAn_DTO();
                
                loaiMonAn_DTO.setId(resultSet.getInt("LMA_ID"));
                loaiMonAn_DTO.setTen(resultSet.getNString("LMA_Ten"));
                
                result.add(loaiMonAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public LoaiMonAn_DTO getLoaiMonAnById(String id){
        Connection con = ConnectDatabase.openConnection();
        LoaiMonAn_DTO loaiMonAn_DTO = new LoaiMonAn_DTO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn WHERE LMA_ID=" + id);
        
            resultSet.next();                
            loaiMonAn_DTO.setId(resultSet.getInt("LMA_ID"));
            loaiMonAn_DTO.setTen(resultSet.getNString("LMA_Ten"));  
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return loaiMonAn_DTO;
    }
    
    public LoaiMonAnFull_DTO getLoaiMonAnFullById(String id){
        Connection con = ConnectDatabase.openConnection();
        LoaiMonAnFull_DTO loaiMonAnFull_DTO = new LoaiMonAnFull_DTO();
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn WHERE LMA_ID=" + id);
        
            resultSet.next();                
            loaiMonAnFull_DTO.setId(resultSet.getInt("LMA_ID"));
            loaiMonAnFull_DTO.setTen(resultSet.getNString("LMA_Ten"));  
            loaiMonAnFull_DTO.setListMonAn(monAn_DAO.getMonAnByLoaiMonAn(id));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return loaiMonAnFull_DTO;
    }
    
    public boolean addLoaiMonAn(String tenLoaiMonAn){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "INSERT INTO LoaiMonAn VALUES(?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setNString(1, tenLoaiMonAn);
            
            if(preparedStatement.executeUpdate() > 1)
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean createLoaiMonAn(LoaiMonAn_DTO loaiMonAn_DTO){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE LoaiMonAn SET LMA_Ten = ? WHERE LMA_ID = " + loaiMonAn_DTO.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setNString(1, loaiMonAn_DTO.getTen());
            
            if(preparedStatement.executeUpdate() > 1)
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean deleteLoaiMonAn(String id){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "DELETE FROM LoaiMonAn WHERE LMA_ID=" + id ;
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            if(preparedStatement.executeUpdate() > 1)
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean hasLoaiMonAn(String id) {
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT LMA_Ten FROM LoaiMonAn WHERE LMA_ID=" + id);
        
            result = resultSet.next();                 
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
}
