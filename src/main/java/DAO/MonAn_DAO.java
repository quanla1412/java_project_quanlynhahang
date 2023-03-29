package DAO;

import DTO.UpdateMonAn_DTO;
import DTO.MonAn_DTO;
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
public class MonAn_DAO {
    public ArrayList<MonAn_DTO> getAllMonAn() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn");
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setTen(resultSet.getNString("MA_HinhAnh"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public MonAn_DTO getMonAnById(String id){
        Connection con = ConnectDatabase.openConnection();
        MonAn_DTO monAn_DTO = new MonAn_DTO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn WHERE LMA_ID=" + id);
        
            resultSet.next();                
            monAn_DTO.setId(resultSet.getInt("LMA_ID"));
            monAn_DTO.setTen(resultSet.getNString("LMA_Ten")); 
            monAn_DTO.setTen(resultSet.getNString("MA_HinhAnh")); 
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return monAn_DTO;
    }
    
    public ArrayList<MonAn_DTO> getMonAnByLoaiMonAn(String id) {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn WHERE LMA_ID = " + id);
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setTen(resultSet.getNString("MA_HinhAnh"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean addLoaiMonAn(UpdateMonAn_DTO updateMonAn_DTO){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "INSERT INTO MonAn VALUES(?, ?, ?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setNString(1, updateMonAn_DTO.getIdLoaiMonAn());
            preparedStatement.setNString(2, updateMonAn_DTO.getTen());
            preparedStatement.setNString(3, updateMonAn_DTO.getHinhAnh());
            
            
            if(preparedStatement.executeUpdate() > 1)
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean updateLoaiMonAn(UpdateMonAn_DTO updateMonAn_DTO){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE LoaiMonAn "
                    + "SET LMA_ID = ?, MA_Ten = ?, MA_HinhAnh = ?"
                    + "WHERE LMA_ID = " + updateMonAn_DTO.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setNString(1, updateMonAn_DTO.getIdLoaiMonAn());
            preparedStatement.setNString(2, updateMonAn_DTO.getTen());
            preparedStatement.setNString(3, updateMonAn_DTO.getHinhAnh());
            
            
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
            
            String sql = "DELETE FROM MonAn WHERE LMA_ID=" + id ;
            
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
}
