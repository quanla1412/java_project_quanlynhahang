package DAO;

import DTO.Ban.Ban_DTO;
import DTO.Ban.CreateBan_DTO;
import DTO.Ban.CreateLoaiBan_DTO;
import DTO.Ban.LoaiBan_DTO;
import DTO.Ban.TinhTrangBan_DTO;
import DTO.Ban.UpdateBan_DTO;
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
public class Ban_DAO {
    public ArrayList<Ban_DTO> getAllLoaiBan(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Ban_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT B_ID, B.TTB_ID, TTB.TTB_Ten, B.LB_ID, LB_Ten, LB_SoLuongCho "
                    + "FROM Ban B, TinhTrangBan TTB, LoaiBan LB "
                    + "WHERE B.TTB_ID = TTB.TTB_ID AND B.LB_ID = LB.LB_ID";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                LoaiBan_DTO loaiBan = new LoaiBan_DTO();
                loaiBan.setId(rs.getInt("LB_ID"));
                loaiBan.setTen(rs.getNString("LB_Ten"));
                loaiBan.setSoLuongCho(rs.getInt("LB_SoLuongCho"));
                
                TinhTrangBan_DTO ttb = new TinhTrangBan_DTO();                
                ttb.setId(rs.getInt("TTB_ID"));
                ttb.setTen(rs.getNString("TTB_Ten"));

                Ban_DTO ban = new Ban_DTO();  
                ban.setId(rs.getInt("B_ID"));
                ban.setLoaiBan(loaiBan);
                ban.setTinhTrangBan(ttb);
                
                result.add(ban);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean createBan(CreateBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO Ban(TTB_ID, LB_ID) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdTinhTrangBan());
            statement.setInt(2, data.getIdLoaiBan());
            
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
    
     public boolean updateBan(UpdateBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE Ban SET TTB_ID = ?, LB_ID = ? WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdTinhTrangBan());
            statement.setInt(2, data.getIdLoaiBan());
            statement.setInt(3, data.getIdBan());
            
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
     
    public boolean changeTinhTrangBan(int idBan, int idTinhTrang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE Ban SET TTB_ID = ? WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idTinhTrang);
            statement.setInt(2, idBan);
            
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
     
    public boolean deleteBan(int idBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM Ban WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idBan);
            
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
