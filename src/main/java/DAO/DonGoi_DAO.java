package DAO;

import DTO.Ban.CreateDonGoi_DTO;
import DTO.Ban.DonGoi_DTO;
import DTO.Ban.UpdateDonGoi_DTO;
import DTO.MonAn.MonAn_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoi_DAO {
    public ArrayList<DonGoi_DTO> getAllDonGoiByIdBan(int idBan){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DonGoi_DTO> result = new ArrayList<>();
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        try {
            String sql = "select B_ID, MA_ID, DG_SoLuong, DG_GhiChu from DonGoi WHERE B_ID = " + idBan;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DonGoi_DTO donGoi = new DonGoi_DTO();
                
                donGoi.setIdBan(rs.getInt("B_ID"));
                
                MonAn_DTO monAn = monAn_DAO.getMonAnById(rs.getInt("MA_ID"));
                donGoi.setMonAn(monAn);
                
                donGoi.setGhiChu(rs.getNString("DG_GhiChu"));
                donGoi.setSoLuong(rs.getInt("DG_SoLuong"));
                
                result.add(donGoi);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public DonGoi_DTO getDonGoiById(int idBan, int idMonAn){
        Connection con = ConnectDatabase.openConnection();
        DonGoi_DTO donGoi = new DonGoi_DTO();
        MonAn_DAO monAn_DAO = new MonAn_DAO();
        try {
            String sql = "select B_ID, MA_ID, DG_SoLuong, DG_GhiChu from DonGoi WHERE B_ID = " + idBan + " AND MA_ID = " + idMonAn; 
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                
                donGoi.setIdBan(rs.getInt("B_ID"));
                
                MonAn_DTO monAn = monAn_DAO.getMonAnById(rs.getInt("MA_ID"));
                donGoi.setMonAn(monAn);
                
                donGoi.setGhiChu(rs.getNString("DG_GhiChu"));
                donGoi.setSoLuong(rs.getInt("DG_SoLuong"));
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return donGoi;
    }
    
    public boolean createDonGoi(CreateDonGoi_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "INSERT INTO DonGoi VALUES( ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdBan());            
            statement.setInt(2, data.getIdMA()); 
            if(data.getSoLuong() <= 0)
                return false;
            statement.setInt(3, data.getSoLuong());   
            if(data.getGhiChu() != null && !data.getGhiChu().isBlank())
                statement.setNString(4, data.getGhiChu());
            else
                statement.setNull(4, Types.NVARCHAR);

            if(statement.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }    
    
    public boolean updateDonGoi(UpdateDonGoi_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "UPDATE DonGoi_BTMA "
                    + "SET DGB_SoLuong = ?, DGB_GhiChu = ?"
                    + "WHERE B_ID = ? AND MA_ID = ? AND BTMA_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
                       
            statement.setInt(1, data.getSoLuong());         
            statement.setNString(2, data.getGhiChu());
            statement.setInt(3, data.getIdBan());            
            statement.setInt(4, data.getIdMA());
            statement.setInt(5, data.getIdBTMA()); 

            if(statement.executeUpdate() > 1)
                result = true;
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean deleteDonGoi(int idBan, int idMA, int idBTMA){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "DELETE FROM DonGoi_BTMA "
                    + "WHERE B_ID = ? AND MA_ID = ? AND BTMA_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
                       
            statement.setInt(1, idBan);            
            statement.setInt(2, idMA);
            statement.setInt(3, idBTMA); 

            if(statement.executeUpdate() > 1)
                result = true;
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean deleteAllDonGoiByIdBan(int idBan){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "DELETE FROM DonGoi_BTMA WHERE B_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
                       
            statement.setInt(1, idBan);     

            if(statement.executeUpdate() > 1)
                result = true;
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean daTonTai(int idBan, int idMonAn){Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT B_ID, MA_ID FROM DonGoi WHERE B_ID = " + idBan + " AND MA_ID = " + idMonAn;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next())
                result = true;
            
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
        
    }
}
