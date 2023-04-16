package DAO;

import DTO.MonAn.UpdateMonAn_DTO;
import DTO.MonAn.MonAn_DTO;
import DTO.MonAn.CreateMonAn_DTO;
import DTO.MonAn.LoaiMonAn_DTO;
import DTO.MonAn.MonAnFull_DTO;
import DTO.MonAn.TinhTrangMonAn_DTO;
import DTO.Search.SearchMonAn_DTO;
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
public class MonAn_DAO {
    public ArrayList<MonAn_DTO> getAllMonAn() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MA_ID, MA_Ten, MA_HinhAnh, LMA_Ten, MA_Gia, MA_GiaKhuyenMai, TTMA_Ten "
                                                    + "FROM MonAn, LoaiMonAn, TinhTrangMonAn TTMA "
                                                    + "WHERE MonAn.LMA_ID = LoaiMonAn.LMA_ID AND MonAn.TTMA_ID = TTMA.TTMA_ID AND MonAn.TTMA_ID != 3");
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                monAn_DTO.setLoaiMonAn(resultSet.getNString("LMA_Ten"));
                monAn_DTO.setGia(resultSet.getInt("MA_Gia"));
                monAn_DTO.setGiaKhuyenMai(resultSet.getInt("MA_GiaKhuyenMai"));
                monAn_DTO.setTinhTrangMonAn(resultSet.getNString("TTMA_Ten"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    } 
    
    public MonAn_DTO getMonAnById(int idMonAn) {
        Connection con = ConnectDatabase.openConnection();
        MonAn_DTO monAn_DTO = new MonAn_DTO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MA_ID, MA_Ten, MA_HinhAnh, LMA_Ten, MA_Gia, MA_GiaKhuyenMai, TTMA_Ten "
                                                    + "FROM MonAn, LoaiMonAn, TinhTrangMonAn TTMA "
                                                    + "WHERE MonAn.LMA_ID = LoaiMonAn.LMA_ID AND MonAn.TTMA_ID = TTMA.TTMA_ID AND MonAn.TTMA_ID != 3 AND MA_ID = " + idMonAn);
        
            if(resultSet.next()){
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                monAn_DTO.setLoaiMonAn(resultSet.getNString("LMA_Ten"));
                monAn_DTO.setGia(resultSet.getInt("MA_Gia"));
                monAn_DTO.setGiaKhuyenMai(resultSet.getInt("MA_GiaKhuyenMai"));
                monAn_DTO.setTinhTrangMonAn(resultSet.getNString("TTMA_Ten"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return monAn_DTO;
    } 
    
    public ArrayList<MonAn_DTO> getListMonAnByLoaiMonAn(int idLoaiMonAn) {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MA_ID, MA_Ten, MA_HinhAnh, LMA_Ten, MA_Gia, MA_GiaKhuyenMai, TTMA_Ten "
                                                    + "FROM MonAn, LoaiMonAn, TinhTrangMonAn TTMA "
                                                    + "WHERE MonAn.LMA_ID = LoaiMonAn.LMA_ID AND MonAn.TTMA_ID = TTMA.TTMA_ID AND MonAn.TTMA_ID != 3 AND MonAn.LMA_ID = " + idLoaiMonAn);
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                monAn_DTO.setLoaiMonAn(resultSet.getNString("LMA_Ten"));
                monAn_DTO.setGia(resultSet.getInt("MA_Gia"));
                monAn_DTO.setGiaKhuyenMai(resultSet.getInt("MA_GiaKhuyenMai"));
                monAn_DTO.setTinhTrangMonAn(resultSet.getNString("TTMA_Ten"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    } 
    
    public ArrayList<MonAn_DTO> searchMonAn(SearchMonAn_DTO searchData){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT MA_ID, MA_Ten, MA_HinhAnh, LMA_Ten, MA_Gia, MA_GiaKhuyenMai, TTMA_Ten "
                                                    + "FROM MonAn, LoaiMonAn, TinhTrangMonAn TTMA "
                                                    + "WHERE MonAn.LMA_ID = LoaiMonAn.LMA_ID AND MonAn.TTMA_ID = TTMA.TTMA_ID ");
            
            if(searchData.getIdOrName() != null && !searchData.getIdOrName().isBlank())
                sql.append(" AND (MA_Ten LIKE N'%").append(searchData.getIdOrName()).append("%' OR MA_ID LIKE '%").append(searchData.getIdOrName()).append("%') ");
            
            if(searchData.getIdLoaiMonAn() > 0)
                sql.append(" AND MonAn.LMA_ID = ").append(searchData.getIdLoaiMonAn());
            
            if (searchData.getMinPrice() > 0) {
                sql.append(" AND MA_Gia > ").append(searchData.getMinPrice());
            }
            
            if (searchData.getMaxPrice() > 0) {
                sql.append(" AND MA_Gia < ").append(searchData.getMaxPrice());
            }
            
            if(searchData.getIdTTMA()> 0)
                sql.append(" AND ( MonAn.TTMA_ID != 3 OR MonAn.TTMA_ID = ").append(searchData.getIdTTMA()).append(") ");
            else 
                sql.append(" AND MonAn.TTMA_ID != 3 ");
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
        
            
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                monAn_DTO.setLoaiMonAn(resultSet.getNString("LMA_Ten"));
                monAn_DTO.setGia(resultSet.getInt("MA_Gia"));
                monAn_DTO.setGiaKhuyenMai(resultSet.getInt("MA_GiaKhuyenMai"));
                monAn_DTO.setTinhTrangMonAn(resultSet.getNString("TTMA_Ten"));
                
                result.add(monAn_DTO);
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
            String sql = "Select * from MonAn where LOWER(MA_Ten) = LOWER(N'" + name + "') AND TTMA_ID = 3 ";
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
    
    public boolean alreadyHasName(int idMonAn, String name){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "Select MA_ID from MonAn where LOWER(MA_Ten) = LOWER(N'" + name + "') AND TTMA_ID = 3 AND MA_ID != " + idMonAn;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<TinhTrangMonAn_DTO> getAllTinhTrangMA(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<TinhTrangMonAn_DTO> result = new ArrayList<>();
        try {            
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM TinhTrangMonAn";
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                TinhTrangMonAn_DTO tinhTrangMonAn_DTO = new TinhTrangMonAn_DTO();
                
                tinhTrangMonAn_DTO.setId(rs.getInt("TTMA_ID"));
                tinhTrangMonAn_DTO.setTen(rs.getNString("TTMA_Ten"));
                
                result.add(tinhTrangMonAn_DTO);
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        return result;
    }
    
    
    public MonAnFull_DTO getMonAnFullById(int id){
        Connection con = ConnectDatabase.openConnection();
        MonAnFull_DTO monAnFull_DTO = new MonAnFull_DTO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MA_ID, MonAn.LMA_ID, LMA_Ten, MA_Ten, MA_HinhAnh, MA_Gia, MA_GiaKhuyenMai, MA_NoiDung, MonAn.TTMA_ID, TTMA_Ten "
                    + " FROM MonAn, LoaiMonAn, TinhTrangMonAn TTMA"
                    + " WHERE MonAn.LMA_ID = LoaiMonAn.LMA_ID AND MonAn.TTMA_ID = TTMA.TTMA_ID AND MA_ID= " + id);
        
            if(resultSet.next()){
                monAnFull_DTO.setId(id);
                
                LoaiMonAn_DTO loaiMonAn_DTO = new LoaiMonAn_DTO();
                loaiMonAn_DTO.setId(resultSet.getInt("LMA_ID"));
                loaiMonAn_DTO.setTen(resultSet.getNString("LMA_Ten"));
                monAnFull_DTO.setLoaiMonAn(loaiMonAn_DTO);
                
                monAnFull_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAnFull_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                monAnFull_DTO.setGia(resultSet.getInt("MA_Gia"));
                monAnFull_DTO.setGiaKhuyenMai(resultSet.getInt("MA_GiaKhuyenMai"));
                monAnFull_DTO.setNoiDung(resultSet.getNString("MA_NoiDung"));
                
                TinhTrangMonAn_DTO tinhTrangMonAn_DTO = new TinhTrangMonAn_DTO();
                tinhTrangMonAn_DTO.setId(resultSet.getInt("TTMA_ID"));
                tinhTrangMonAn_DTO.setTen(resultSet.getNString("TTMA_Ten"));
                monAnFull_DTO.setTinhTrangMonAn(tinhTrangMonAn_DTO);
            }                 
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return monAnFull_DTO;
    }
    
    public boolean createMonAn(CreateMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "INSERT INTO MonAn VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getIdLoaiMonAn());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getHinhAnh());
            preparedStatement.setInt(4, data.getGia());
            if(data.getGiaKhuyenMai() == 0)
                preparedStatement.setNull(5, Types.INTEGER);
            else
                preparedStatement.setInt(5, data.getGiaKhuyenMai());
            preparedStatement.setNString(6, data.getNoiDung());
            preparedStatement.setInt(7, data.getIdTtinhTrangMonAn());
            
            
            if(preparedStatement.executeUpdate() >= 1){
                result = true;     
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean updateMonAn(UpdateMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE MonAn"
                    + " SET LMA_ID = ?, MA_Ten = ?, MA_HinhAnh = ?, MA_Gia = ?, MA_GiaKhuyenMai = ?, MA_NoiDung = ?, TTMA_ID = ?"
                    + " WHERE MA_ID = " + data.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getIdLoaiMonAn());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getHinhAnh());
            
            preparedStatement.setInt(1, data.getIdLoaiMonAn());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getHinhAnh());
            preparedStatement.setInt(4, data.getGia());
            if(data.getGiaKhuyenMai() == 0)
                preparedStatement.setNull(5, Types.INTEGER);
            else
                preparedStatement.setInt(5, data.getGiaKhuyenMai());
            preparedStatement.setNString(6, data.getNoiDung());
            preparedStatement.setInt(7, data.getIdTtinhTrangMonAn());
            
            
            if(preparedStatement.executeUpdate() >= 1){
                result = true;                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean chuyenTinhTrangMonAn(int idMonAn, int tinhTrangMonAn){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE MonAn"
                    + " SET TTMA_ID = " + tinhTrangMonAn
                    + " WHERE MA_ID = " + idMonAn;
            
            Statement statement = con.createStatement();
            
            if(statement.executeUpdate(sql) >= 1){
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
