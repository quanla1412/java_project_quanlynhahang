/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Constraints.TinhTrangNhanVienConstraints;
import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateNhanVien_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.NhanVien.SearchNhanVien_DTO;
import DTO.NhanVien.TinhTrangNhanVien_DTO;
import DTO.NhanVien.UpdateNhanVien_DTO;
import DTO.TaiKhoan_DTO;
import com.mycompany.quanlynhahang.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dinhn
 */
public class NhanVien_DAO {
    public NhanVienFull_DTO getNhanVienbyMa(String ma) {
        Connection con = ConnectDatabase.openConnection();
        NhanVienFull_DTO result = new NhanVienFull_DTO();
        String sql = "SELECT NV_Ma, NhanVien.TTNV_ID, TinhTrangNhanVien.TTNV_Ten, NhanVien.CV_ID, ChucVu.CV_Ten, NV_HoTen, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_SDT, NV_DiaChi, NV_CCCD "
                                            + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                                            + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID AND NV_Ma = '" + ma + "'";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            if(resultSet.next()){
                result.setMa(resultSet.getString("NV_Ma"));
                result.setHoTen(resultSet.getNString("NV_HoTen"));
                result.setNgaySinh(resultSet.getTimestamp("NV_NgaySinh"));
                result.setGioiTinhNam(resultSet.getBoolean("NV_GioiTinhNam"));
                result.setEmail(resultSet.getString("NV_Email").trim());
                result.setSoDienThoai(resultSet.getString("NV_SDT"));
                result.setDiaChi(resultSet.getNString("NV_DiaChi"));
                result.setCCCD(resultSet.getString("NV_CCCD"));
                
               
                TinhTrangNhanVien_DTO tinhTrang = new TinhTrangNhanVien_DTO();
                tinhTrang.setId(resultSet.getInt("TTNV_ID"));
                tinhTrang.setTen(resultSet.getNString("TTNV_Ten"));
                
                ChucVu_DTO chucVu = new ChucVu_DTO();
                chucVu.setId(resultSet.getInt("CV_ID"));
                chucVu.setTen(resultSet.getNString("CV_Ten"));
                
                result.setChucVu(chucVu);
                result.setTinhTrangNhanVien(tinhTrang);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
     }
     
    public ArrayList<NhanVien_DTO> getAllNhanVien() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<NhanVien_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT NV_MA, NV_HoTen, NV_SDT, TTNV_Ten, CV_Ten, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_DiaChi, NV_GioiTinhNam, NV_CCCD "
                        + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                        + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID AND NhanVien.TTNV_ID != " + TinhTrangNhanVienConstraints.DA_NGHI;
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        
            while(rs.next()){
                String ma = rs.getString("NV_Ma");
                String hoTen = rs.getNString("NV_HoTen");
                String sdt = rs.getString("NV_SDT");
                String tinhTrang = rs.getNString("TTNV_Ten");
                String chucVu = rs.getNString("CV_Ten");
                Date ngaySinh = rs.getTimestamp("NV_NgaySinh");
                String email = rs.getString("NV_Email");
                String diaChi = rs.getNString("NV_DiaChi");
                String gioiTinh = rs.getBoolean("NV_GioiTinhNam") ? "Nam" : "Nữ";
                String CCCD = rs.getString("NV_CCCD");
                
                NhanVien_DTO nhanVien_DTO = new NhanVien_DTO(
                        ma,
                        tinhTrang,
                        chucVu, 
                        hoTen,
                        sdt, 
                        ngaySinh, 
                        email, 
                        diaChi, 
                        gioiTinh,
                        CCCD
                );
                result.add(nhanVien_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
     
    public ArrayList<NhanVienFull_DTO> getAllNhanVienFull() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<NhanVienFull_DTO> result = new ArrayList<>();
        try {
            String sql = "SELECT NV_Ma, NhanVien.TTNV_ID, TinhTrangNhanVien.TTNV_Ten, NhanVien.CV_ID, ChucVu.CV_Ten, NV_HoTen, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_SDT, NV_DiaChi, NV_CCCD "
                                            + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                                            + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID AND NhanVien.TTNV_ID != " + TinhTrangNhanVienConstraints.DA_NGHI;
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        
            while(rs.next()){
                NhanVienFull_DTO nhanVienFull = new NhanVienFull_DTO();
                nhanVienFull.setMa(rs.getString("NV_Ma"));
                nhanVienFull.setHoTen(rs.getNString("NV_HoTen"));
                nhanVienFull.setNgaySinh(rs.getTimestamp("NV_NgaySinh"));
                nhanVienFull.setGioiTinhNam(rs.getBoolean("NV_GioiTinhNam"));
                nhanVienFull.setEmail(rs.getString("NV_Email").trim());
                nhanVienFull.setSoDienThoai(rs.getString("NV_SDT"));
                nhanVienFull.setDiaChi(rs.getNString("NV_DiaChi"));
                nhanVienFull.setCCCD(rs.getString("NV_CCCD"));
               
                TinhTrangNhanVien_DTO tinhTrang = new TinhTrangNhanVien_DTO();
                tinhTrang.setId(rs.getInt("TTNV_ID"));
                tinhTrang.setTen(rs.getNString("TTNV_Ten"));
                
                ChucVu_DTO chucVu = new ChucVu_DTO();
                chucVu.setId(rs.getInt("CV_ID"));
                chucVu.setTen(rs.getNString("CV_Ten"));
                
                nhanVienFull.setChucVu(chucVu);
                nhanVienFull.setTinhTrangNhanVien(tinhTrang);
                
                result.add(nhanVienFull);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
       
    public ArrayList<NhanVien_DTO> searchNhanVien(SearchNhanVien_DTO searchData){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<NhanVien_DTO> result = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT NV_MA, NV_HoTen, NV_SDT, TTNV_Ten, CV_Ten, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_DiaChi, NV_GioiTinhNam, NV_CCCD "
                        + "FROM NhanVien, TinhTrangNhanVien, ChucVu "
                        + "WHERE NhanVien.TTNV_ID = TinhTrangNhanVien.TTNV_ID AND NhanVien.CV_ID = ChucVu.CV_ID ");
            
            if(searchData.getMaOrhoTen()!= null && !searchData.getMaOrhoTen().isBlank())
               sql.append(" AND (NV_HoTen LIKE N'%").append(searchData.getMaOrhoTen()).append("%' OR NV_Ma LIKE '%").append(searchData.getMaOrhoTen()).append("%') ");

            if (searchData.getChucVu() > 0) 
                sql.append("AND ChucVu.CV_ID = ").append(searchData.getChucVu());

            if (searchData.isGioiTinh() >= 0)
                sql.append("AND NV_GioiTinhNam = ").append(searchData.isGioiTinh());

            if (searchData.getTinhTrang() != null){
                sql.append("AND NhanVien.TTNV_ID IN (");
                for(int tinhTrang : searchData.getTinhTrang())
                    sql.append(tinhTrang + ", ");
                sql.replace(sql.length()-2, sql.length(), "");
                sql.append(')');            
            }
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql.toString());        
            
            while(rs.next()){
                String ma = rs.getString("NV_Ma");
                String hoTen = rs.getNString("NV_HoTen");
                String sdt = rs.getString("NV_SDT");
                String tinhTrang = rs.getNString("TTNV_Ten");
                String chucVu = rs.getNString("CV_Ten");
                Date ngaySinh = rs.getTimestamp("NV_NgaySinh");
                String email = rs.getString("NV_Email");
                String diaChi = rs.getNString("NV_DiaChi");
                String gioiTinh = rs.getBoolean("NV_GioiTinhNam") ? "Nam" : "Nữ";
                String CCCD = rs.getString("NV_CCCD");
                
                NhanVien_DTO nhanVien_DTO = new NhanVien_DTO(
                        ma,
                        tinhTrang,
                        chucVu, 
                        hoTen,
                        sdt, 
                        ngaySinh, 
                        email, 
                        diaChi, 
                        gioiTinh,
                        CCCD
                );
                result.add(nhanVien_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    } 
       
    public boolean createNhanVien(CreateNhanVien_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO NhanVien(NV_MA, TTNV_ID, CV_ID, NV_HoTen, NV_NgaySinh, NV_GioiTinhNam, NV_Email, NV_SDT, NV_DiaChi, NV_Password, NV_CCCD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, data.getMa());
            statement.setInt(2, data.getIdTinhTrangNhanVien());
            statement.setInt(3, data.getIdChucVu());
            statement.setNString(4, data.getHoTen());
            statement.setTimestamp(5, new Timestamp(data.getNgaySinh().getTime()));
            statement.setBoolean(6, data.isGioiTinhNam());
            statement.setString(7, data.getEmail());
            statement.setString(8, data.getSoDienThoai());
            statement.setString(9, data.getDiaChi());
            statement.setString(10, data.getPassword());
            statement.setString(11, data.getCCCD());
            
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
      
    public boolean updateNhanVien(UpdateNhanVien_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE NhanVien SET TTNV_ID = ?, CV_ID = ?, NV_HoTen = ?, NV_Email = ?, NV_SDT = ?, NV_DiaChi = ? WHERE NV_MA = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, data.getIdTinhTrangNhanVien());
            statement.setInt(2, data.getIdChucVu());
            statement.setNString(3, data.getHoTen());
            statement.setString(4, data.getEmail());
            statement.setString(5, data.getSoDienThoai());
            statement.setString(6, data.getDiaChi());
            statement.setString(7, data.getMa());
            
            
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
       
    public boolean deleteNhanVien (String NVMa){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM NhanVien WHERE NV_MA = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, NVMa);
            
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
       
    public int deleteNhieuNhanVien(ArrayList<String> listmaNhanVien){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        
        try {
            String sql = "DELETE FROM NhanVien WHERE NV_Ma = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            for(String ma : listmaNhanVien){
                statement.setString(1, ma);
                
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
       
    public boolean hasSoDienThoaiOrEmailOrCCCD(String sdt, String email, String CCCD){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT NV_Ma From NhanVien "
                    + "WHERE NV_SDT = '" + sdt + "' OR NV_Email = '" + email + "' OR NV_CCCD = '" + CCCD + "'";
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean hasSoDienThoaiOrEmail(String MaNVHienTai, String sdt, String email){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT NV_Ma From NhanVien "
                    + "WHERE (NV_SDT = '" + sdt + "' OR NV_Email = '" + email + "') AND NV_Ma != '" + MaNVHienTai + "'";
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }  
    
     public boolean hasMaNV(String MaNV){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            String sql = "SELECT NV_Ma From NhanVien "
                    + "WHERE NV_Ma = '" + MaNV + "' ";
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);        
            
            if(resultSet.next())
                result = true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }  
    
    public boolean doiMatKhau(String maNhanVien, String password){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE NhanVien SET NV_Password = ? WHERE NV_MA = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, password);
            statement.setString(2, maNhanVien);
            
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
    
    public TaiKhoan_DTO getTaiKhoanByMa(String username) {
        Connection con = ConnectDatabase.openConnection();
        String sql = "SELECT NV_Ma, NV_Password FROM NhanVien WHERE NhanVien.NV_Ma = '" + username + "'";
        TaiKhoan_DTO result = null;
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
           
            if(resultSet.next())
                result = new TaiKhoan_DTO(resultSet.getString("NV_Ma"), resultSet.getString("NV_Password"));
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
     }
}
