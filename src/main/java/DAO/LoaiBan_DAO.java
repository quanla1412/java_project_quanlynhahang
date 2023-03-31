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
    
    public boolean createLoaiBan(CreateLoaiBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO LoaiBan(LB_Ten, LB_SoLuongCho) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getSoLuongCho());
            
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
     
    public boolean updateLoaiBan(LoaiBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE LoaiBan SET LB_Ten = ?, LB_SoLuongCho = ? WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getSoLuongCho());
            statement.setInt(3, data.getId());
            
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
    
    public boolean deleteLoaiBan(int idLoaiBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM LoaiBan WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idLoaiBan);
            
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
