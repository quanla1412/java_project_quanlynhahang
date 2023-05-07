package DAO;

import DTO.Ban.CreateLoaiBan_DTO;
import DTO.Ban.LoaiBan_DTO;
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
public class LoaiBan_DAO {
    public ArrayList<LoaiBan_DTO> getAllLoaiBan(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<LoaiBan_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM LoaiBan";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                LoaiBan_DTO loaiBan = new LoaiBan_DTO();
                
                loaiBan.setId(rs.getInt(1));
                loaiBan.setTen(rs.getNString(2));
                loaiBan.setSoLuongCho(rs.getInt(3));
                
                result.add(loaiBan);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public LoaiBan_DTO getLoaiBanByID(int id){
        Connection con = ConnectDatabase.openConnection();
        LoaiBan_DTO loaiBan = new LoaiBan_DTO();
        
        try {
            String sql = "SELECT * FROM LoaiBan WHERE LB_ID = " + id ;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                loaiBan.setId(rs.getInt(1));
                loaiBan.setTen(rs.getNString(2));
                loaiBan.setSoLuongCho(rs.getInt(3));;
            } else 
                return null;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return loaiBan;
    }
    
    public boolean createLoaiBan(CreateLoaiBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO LoaiBan(LB_Ten, LB_SoLuongCho) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getSoLuongCho());
            
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
     
    public boolean updateLoaiBan(LoaiBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE LoaiBan SET LB_Ten = ?, LB_SoLuongCho = ? WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getSoLuongCho());
            statement.setInt(3, data.getId());
            
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
    
    public boolean deleteLoaiBan(int idLoaiBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM LoaiBan WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idLoaiBan);
            
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
    
    public int deleteNhieuLoaiBan(ArrayList<Integer> listIDLoaiBan){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        
        try {
            String sql = "DELETE FROM LoaiBan WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);            
            
            for(int id : listIDLoaiBan) {
                statement.setInt(1, id);
                
                if(statement.executeUpdate() >= 1)
                    result++;
            }
                       
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean alreadyHasName(String name){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        try {
            String sql = "Select * from LoaiBan where LOWER(LB_Ten) = LOWER(N'" + name + "') ";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean alreadyHasName(int idLoaiBan, String name){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        try {
            String sql = "Select * from LoaiBan where LOWER(LB_Ten) = LOWER(N'" + name + "') AND LB_ID != " + idLoaiBan;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
