package DAO;

import DTO.HoaDon.ChiTietHoaDon_DTO;
import DTO.HoaDon.CreateChiTietHoaDon_DTO;
import DTO.HoaDon.CreateHoaDon_DTO;
import DTO.HoaDon.HoaDonFull_DTO;
import DTO.HoaDon.HoaDon_DTO;
import DTO.HoaDon.UpdateChiTietHoaDon_DTO;
import DTO.HoaDon.UpdateHoaDon_DTO;
import DTO.Search.SearchHoaDon_DTO;
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
                hoaDon.setMaNhanVien(rs.getString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                
                result.add(hoaDon);
            }
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<HoaDon_DTO> searchHoaDon(SearchHoaDon_DTO searchData){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<HoaDon_DTO> result = new ArrayList<>();
        
        try {
            StringBuilder sql = new StringBuilder("SELECT HD_ID, NV_Ma, KH_ID , HD_NgayGio, HD_TongGia"
                                                    + " FROM HoaDon"
                                                    + " WHERE ");
            
            ArrayList<String> listSQL = new ArrayList<String>();
            if(searchData.getId() != null && !searchData.getId().isBlank())
                listSQL.add("HD_ID LIKE '%" + searchData.getId() + "%'");
          
            if(searchData.getNgayBatDau() != null){
                listSQL.add("HD_NgayGio BETWEEN '" + searchData.getNgayBatDau() + "' AND '" + searchData.getNgayCuoiCung() + "'");
            }

            if (searchData.getMinPrice() > 0) {
                listSQL.add("HD_TongGia > " + searchData.getMinPrice());
            }
            
            if (searchData.getMaxPrice() > 0) {
                listSQL.add("HD_TongGia < " + searchData.getMaxPrice());
            }

            if(searchData.getIdTTHD() >= 0)
                listSQL.add("HD_DaHuy = " + searchData.getIdTTHD());
                
            
            sql.append(String.join(" AND ", listSQL));
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql.toString());
            
            while(rs.next()){
                HoaDon_DTO hoaDon = new HoaDon_DTO();
                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                
                result.add(hoaDon);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally   {
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
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                
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
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                
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
            String sql = "SELECT * FROM HoaDon WHERE HD_ID =" + idHoaDon;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){                
                hoaDon.setId(rs.getInt("HD_ID"));
                hoaDon.setMaNhanVien(rs.getString("NV_Ma"));
                hoaDon.setIdKhachHang(rs.getInt("KH_ID"));
                hoaDon.setNgayGio(rs.getTimestamp("HD_NgayGio"));
                hoaDon.setTinhTrangHoaDon(rs.getBoolean("HD_DaHuy"));
                hoaDon.setListMonAn(getAllChiTietHoaDonByIdHoaDon(idHoaDon));
                hoaDon.setTongGia(rs.getInt("HD_TongGia"));
                hoaDon.setUuDai(rs.getFloat("HD_UuDai"));
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
        try {
            String sql = "SELECT MA_Ten, CTHD_Gia, CTHD_SoLuong, CTHD_Gia*CTHD_SoLuong AS CTHD_ThanhTien "
                        + "FROM ChiTietHoaDon, MonAn "
                        + "WHERE MonAn.MA_ID = ChiTietHoaDon.MA_ID AND HD_ID =" + idHoaDon;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                
                cthd.setTenMonAn(rs.getNString("Ma_Ten"));
                cthd.setGia(rs.getInt("CTHD_Gia"));
                cthd.setSoLuong(rs.getInt("CTHD_SoLuong"));
                cthd.setThanhTien(rs.getInt("CTHD_ThanhTien"));
                
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
    
    public void updateHoaDon(UpdateHoaDon_DTO data){
        Connection con = ConnectDatabase.openConnection();
        try {
            String sql = "UPDATE HoaDon"
                    + "SET HD_DaHuy = 1 "
                    + "WHERE HD_ID = " + data.getIdHoaDon();
            
            PreparedStatement statement = con.prepareStatement(sql);
            

        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
    }
    
    public boolean deleteHoaDon(int idHoaDon){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "UPDATE HoaDon"
                    + " SET HD_DaHuy = 1"
                    + " WHERE HD_ID = " + idHoaDon;
            
            Statement statement = con.createStatement();
            
            if(statement.executeUpdate(sql) >=  1){                    
                result = true;
            }            
        } catch (SQLException ex ){
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        return result;
    }
}
