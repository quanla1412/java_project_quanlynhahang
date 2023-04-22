package DAO;

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
public class QuyenTaiKhoan_DAO {
    public ArrayList<Integer> getAllQuyenByMaNV(String maNhanVien){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Integer> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM QuyenTaiKhoan WHERE NV_Ma = '" + maNhanVien + "'";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                result.add(rs.getInt("CN_ID"));
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean hasQuyen(String maNhanVien, int idChucNang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "SELECT * FROM QuyenTaiKhoan WHERE NV_Ma = '" + maNhanVien + "' AND CN_ID = " + idChucNang;
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
    
    public boolean createQuyen(String maNhanVien, int idChucNang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO QuyenTaiKhoan VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, maNhanVien);
            statement.setInt(2, idChucNang);
            
            if(statement.executeUpdate() >= 1)
                result = true;            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean deleteQuyen(String maNhanVien, int idChucNang){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "DELETE FROM QuyenTaiKhoan WHERE NV_Ma = '" + maNhanVien + "' AND CN_ID = " + idChucNang;
            Statement statement = con.createStatement();
            
            if(statement.executeUpdate(sql) >= 1)
                result = true;            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
