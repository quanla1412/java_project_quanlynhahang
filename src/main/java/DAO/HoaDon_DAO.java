package DAO;

import DTO.HoaDon.ChiTietHoaDon_DTO;
import DTO.HoaDon.CreateChiTietHoaDon_DTO;
import DTO.HoaDon.CreateHoaDon_DTO;
import DTO.HoaDon.HoaDonFull_DTO;
import DTO.HoaDon.HoaDon_DTO;
import DTO.HoaDon.UpdateChiTietHoaDon_DTO;
import DTO.HoaDon.UpdateHoaDon_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class HoaDon_DAO {
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<HoaDon_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                HoaDon_DTO hoaDon = new HoaDon_DTO();
                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getNString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                
                result.add(hoaDon);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public HoaDon_DTO getHoaDonById(int idHoaDon){
        Connection con = ConnectDatabase.openConnection();
        HoaDon_DTO hoaDon = new HoaDon_DTO();
        try {
            String sql = "SELECT * FROM HoaDon WHERE HD_ID = " + idHoaDon;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getNString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return hoaDon;
    }
    
    public ArrayList<HoaDon_DTO> getHoaDonFromDateToDate(Timestamp fromDate, Timestamp toDate){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<HoaDon_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon WHERE HD_NgayGio > ? AND HD_NgayGio < ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setTimestamp(1, fromDate);            
            statement.setTimestamp(2, toDate);

            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                HoaDon_DTO hoaDon = new HoaDon_DTO();
                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getNString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                
                result.add(hoaDon);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public HoaDonFull_DTO getHoaDonFullById(int idHoaDon){
        Connection con = ConnectDatabase.openConnection();
        HoaDonFull_DTO hoaDon = new HoaDonFull_DTO();
        try {
            String sql = "SELECT * FROM HoaDon WHERE HD_ID = " + idHoaDon;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getNString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                hoaDon.setListMonAn(getAllChiTietHoaDonByIdHoaDon(idHoaDon));
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return hoaDon;
    }
    
    public ArrayList<ChiTietHoaDon_DTO> getAllChiTietHoaDonByIdHoaDon(int idHoaDon){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<ChiTietHoaDon_DTO> result = new ArrayList<>();
        BienTheMonAn_DAO bienTheMonAn_DAO = new BienTheMonAn_DAO();
        try {
            String sql = "SELECT * FROM ChiTietHoaDon WHERE HD_ID = " + idHoaDon;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                
                cthd.setSoLuong(rs.getInt("CTHD_SoLuong"));
                
                int idMA = rs.getInt("MA_ID");
                int idBTMA = rs.getInt("idBTMA");
                
                cthd.setBienTheMonAn(bienTheMonAn_DAO.getBienTheMonAnById(idMA, idBTMA));
                
                result.add(cthd);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    
    public boolean createHoaDon(CreateHoaDon_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "INSERT INTO HoaDon(NV_Ma, KH_ID, HD_NgayGio, HD_TongGia) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, data.getMaNhanVien());
            statement.setInt(2, data.getIdKhachHang());
            statement.setTimestamp(3, data.getNgayGio());
            statement.setInt(4, data.getTongGia());
            
            if(statement.executeUpdate() >  1){
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()){
                    int idHoaDon = rs.getInt(1);
                    
                    sql = "INSERT INTO ChiTietHoaDon(HD_ID, MA_ID, BTMA_ID, CTHD_SoLuong)"
                            + "VALUES(?, ?, ?, ?)";
                    PreparedStatement statementCTHD = con.prepareStatement(sql);
                    
                    for(CreateChiTietHoaDon_DTO cthd : data.getListMonAn()) {
                        statementCTHD.setInt(1, idHoaDon);
                        statementCTHD.setInt(2, cthd.getIdMA());
                        statementCTHD.setInt(3, cthd.getIdBTMA());
                        statementCTHD.setInt(4, cthd.getSoLuong());
                        
                        statementCTHD.executeUpdate();
                    }                    
                }  
                result = true;
            }
            
            
            
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean updateHoaDon(UpdateHoaDon_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "UPDATE HoaDon"
                    + "SET NV_Ma = ?, KH_ID = ?, HD_TongGia = ? "
                    + "WHERE HD_ID = ?";
            
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, data.getMaNhanVien());
            statement.setInt(2, data.getIdKhachHang());
            statement.setInt(3, data.getTongGia());
            statement.setInt(4, data.getId());
            
            if(statement.executeUpdate() >  1){
                    
                sql = "UPDATE ChiTietHoaDon "
                        + "SET MA_ID = ?, BTMA_ID = ?, CTHD_SoLuong) = ?"
                        + "WHERE HD_ID = ?";
                PreparedStatement statementCTHD = con.prepareStatement(sql);

                for(UpdateChiTietHoaDon_DTO cthd : data.getListMonAn()) {
                    statementCTHD.setInt(1, cthd.getIdMA());
                    statementCTHD.setInt(2, cthd.getIdBTMA());
                    statementCTHD.setInt(3, cthd.getSoLuong());
                    statementCTHD.setInt(4, data.getId());

                    statementCTHD.executeUpdate();
                }                    
                  
                result = true;
            }
            
            
            
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean deleteHoaDon(int idHoaDon){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "DELETE ChiTietHoaDon WHERE HD_ID = ?";
            
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idHoaDon);
            
            if(statement.executeUpdate() >  1){                    
                sql = "DELETE HoaDon WHERE HD_ID = ?";
                PreparedStatement statementHD = con.prepareStatement(sql);

                statementHD.setInt(1, idHoaDon);

                if(statementHD.executeUpdate() > 1){
                    result = true;
                }  
            }            
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
