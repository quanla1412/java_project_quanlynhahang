package DAO;

import DTO.Ban.BanFull_DTO;
import DTO.Ban.Ban_DTO;
import DTO.Ban.CreateBan_DTO;
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
    public ArrayList<Ban_DTO> getAllBan(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Ban_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT B_ID, TTB.TTB_Ten, LB_Ten "
                    + "FROM Ban B, TinhTrangBan TTB, LoaiBan LB "
                    + "WHERE B.TTB_ID = TTB.TTB_ID AND B.LB_ID = LB.LB_ID";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Ban_DTO ban = new Ban_DTO();  
                ban.setId(rs.getInt("B_ID"));
                ban.setLoaiBan(rs.getNString("LB_Ten"));
                ban.setTinhTrangBan(rs.getNString("TTB_Ten"));
                
                result.add(ban);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public BanFull_DTO getBanFullById(int id){
        Connection con = ConnectDatabase.openConnection();
        BanFull_DTO result = new BanFull_DTO();
        
        try {
            String sql = "SELECT B_ID, B.TTB_ID, TTB.TTB_Ten, B.LB_ID, LB_Ten, LB_SoLuongCho "
                    + "FROM Ban B, TinhTrangBan TTB, LoaiBan LB "
                    + "WHERE B.TTB_ID = TTB.TTB_ID AND B.LB_ID = LB.LB_ID AND B_ID = " + id;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                LoaiBan_DTO loaiBan = new LoaiBan_DTO();
                loaiBan.setId(rs.getInt("LB_ID"));
                loaiBan.setTen(rs.getNString("LB_Ten"));
                loaiBan.setSoLuongCho(rs.getInt("LB_SoLuongCho"));
                
                TinhTrangBan_DTO tinhTrang = new TinhTrangBan_DTO();
                tinhTrang.setId(rs.getInt("TTB_ID"));
                tinhTrang.setTen(rs.getNString("TTB_Ten"));
                
                result.setId(rs.getInt("B_ID"));
                result.setLoaiBan(loaiBan);
                result.setTinhTrangBan(tinhTrang);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<BanFull_DTO> getAllBanFull(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<BanFull_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT B_ID, B.TTB_ID, TTB.TTB_Ten, B.LB_ID, LB_Ten, LB_SoLuongCho "
                    + "FROM Ban B, TinhTrangBan TTB, LoaiBan LB "
                    + "WHERE B.TTB_ID = TTB.TTB_ID AND B.LB_ID = LB.LB_ID ";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                BanFull_DTO banFull_DTO = new BanFull_DTO();
                
                LoaiBan_DTO loaiBan = new LoaiBan_DTO();
                loaiBan.setId(rs.getInt("LB_ID"));
                loaiBan.setTen(rs.getNString("LB_Ten"));
                loaiBan.setSoLuongCho(rs.getInt("LB_SoLuongCho"));
                
                TinhTrangBan_DTO tinhTrang = new TinhTrangBan_DTO();
                tinhTrang.setId(rs.getInt("TTB_ID"));
                tinhTrang.setTen(rs.getNString("TTB_Ten"));
                
                banFull_DTO.setId(rs.getInt("B_ID"));
                banFull_DTO.setLoaiBan(loaiBan);
                banFull_DTO.setTinhTrangBan(tinhTrang);
                
                result.add(banFull_DTO);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<Ban_DTO> getAllBanByTinhTrang(int idTinhTrangBan){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Ban_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT B_ID, TTB.TTB_Ten, LB_Ten "
                    + "FROM Ban B, TinhTrangBan TTB, LoaiBan LB "
                    + "WHERE B.TTB_ID = TTB.TTB_ID AND B.LB_ID = LB.LB_ID AND B.TTB_ID = " + idTinhTrangBan;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Ban_DTO ban = new Ban_DTO();  
                ban.setId(rs.getInt("B_ID"));
                ban.setLoaiBan(rs.getNString("LB_Ten"));
                ban.setTinhTrangBan(rs.getNString("TTB_Ten"));
                
                result.add(ban);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<TinhTrangBan_DTO> getAllTinhTrangBan(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<TinhTrangBan_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM TinhTrangBan ";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                TinhTrangBan_DTO ban = new TinhTrangBan_DTO();  
                ban.setId(rs.getInt("TTB_ID"));
                ban.setTen(rs.getNString("TTB_Ten"));
                
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
    
     public boolean updateBan(UpdateBan_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE Ban SET TTB_ID = ?, LB_ID = ? WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdTinhTrangBan());
            statement.setInt(2, data.getIdLoaiBan());
            statement.setInt(3, data.getIdBan());
            
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
     
    public boolean changeTinhTrangBan(int idBan, int idTinhTrang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE Ban SET TTB_ID = ? WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idTinhTrang);
            statement.setInt(2, idBan);
            
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
     
    public boolean deleteBan(int idBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM Ban WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idBan);
            
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
    
    public int deleteNhieuBan(ArrayList<Integer> listId){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        
        try {
            String sql = "DELETE FROM Ban WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            for(int id : listId){
                statement.setInt(1, id);
                
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
    
    public boolean hasDonGoi(int idBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "SELECT B_ID FROM DonGoi WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBan);
            
            ResultSet rs = statement.executeQuery();
            
            if(rs.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
