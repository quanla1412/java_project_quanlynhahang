package DAO;

import DTO.Ban.CreateDonGoi_DTO;
import DTO.Ban.DonGoi_DTO;
import DTO.Ban.UpdateDonGoi_DTO;
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
public class DonGoi_DAO {
    public ArrayList<DonGoi_DTO> getAllDonGoiByIdBan(int idBan){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<DonGoi_DTO> result = new ArrayList<>();
        BienTheMonAn_DAO bienTheMonAn_DAO = new BienTheMonAn_DAO();
        try {
            String sql = "SELECT * FROM DonGoi_BTMA WHERE B_ID = " + idBan;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                DonGoi_DTO donGoi = new DonGoi_DTO();
                
                int idMA = rs.getInt("MA_ID");
                int idBTMA = rs.getInt("BTMA_ID");
                
                donGoi.setBtma(bienTheMonAn_DAO.getBienTheMonAnById(idMA, idBTMA));
                donGoi.setGhiChu(rs.getNString("DGB_GhiChu"));
                donGoi.setSoLuong(rs.getInt("DGB_SoLuong"));
                donGoi.setNgayGio(rs.getTimestamp("DGB_NgayGio"));
                
                result.add(donGoi);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean createDonGoi(CreateDonGoi_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "INSERT INTO DonGoi_BTMA VALUES( ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdBan());            
            statement.setInt(2, data.getIdMA());
            statement.setInt(3, data.getIdBTMA());            
            statement.setInt(4, data.getSoLuong());
            statement.setTimestamp(5, data.getNgayGio());            
            statement.setNString(6, data.getGhiChu());

            if(statement.executeUpdate() > 1)
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
}
