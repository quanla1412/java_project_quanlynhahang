
package DAO;

import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateChucVu_DTO;
import DTO.NhanVien.UpdateChucVu_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author dinhn
 */
public class ChucVu_DAO {
     public ArrayList<ChucVu_DTO> getAllChucVu(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<ChucVu_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChucVu";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                ChucVu_DTO chucVu = new ChucVu_DTO();
                
                chucVu.setId(rs.getInt("CV_ID"));
                chucVu.setTen(rs.getNString("CV_Ten"));
                
                
                result.add(chucVu);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
     
      public ChucVu_DTO getChucVuById(int id){
        Connection con = ConnectDatabase.openConnection();
        ChucVu_DTO chucVu = new ChucVu_DTO();
        try {
            String sql = "SELECT * FROM ChucVu WHERE CV_ID = " + id;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                
                chucVu.setId(rs.getInt("CV_ID"));
                chucVu.setTen(rs.getNString("CV_Ten"));

            }
            else return null;
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return chucVu;
    }
     
     
    public boolean createChucVu(CreateChucVu_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO ChucVu(CV_Ten) VALUES (?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTen());
            
            
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
    
    
    public boolean updateChucVu(ChucVu_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE ChucVu SET CV_Ten = ? WHERE CV_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
           
            statement.setNString(1, data.getTen());
            statement.setInt(2, data.getId());
            
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
    
     public boolean deleteChucVu(int CVid){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM ChucVu WHERE CV_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, CVid);
            
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
     
     public int deletenhieuChucVu(ArrayList<Integer> listIDChucVu){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        
        try {
            String sql = "DELETE FROM ChucVu WHERE LB_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);            
            
            for(int id : listIDChucVu) {
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
            String sql = "Select * from ChucVu where LOWER(CV_Ten) = LOWER(N'" + name + "') ";
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
