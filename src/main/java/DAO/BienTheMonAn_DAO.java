package DAO;

import DTO.MonAn.BienTheMonAn_DTO;
import DTO.MonAn.CreateBienTheMonAn_DTO;
import DTO.MonAn.OptionValue_DTO;
import DTO.MonAn.TinhTrangMonAn_DTO;
import DTO.MonAn.UpdateBienTheMonAn_DTO;
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
public class BienTheMonAn_DAO {
    public BienTheMonAn_DTO getBienTheMonAn(int idMonAn, ArrayList<OptionValue_DTO> listOptionValues){
        Connection con = ConnectDatabase.openConnection();
        BienTheMonAn_DTO bienTheMonAn_DTO = new BienTheMonAn_DTO();
        try {
            if(listOptionValues.isEmpty())
                return null; 
            
            ArrayList<String> conditions = new ArrayList<>();
            
            for(OptionValue_DTO optionValue : listOptionValues){
                conditions.add("SELECT BTMA_ID FROM BTMA_Value "
                        + "WHERE MA_ID = 1 AND (OPT_ID = " + optionValue.getIdOption() +" AND VAL_ID = " + optionValue.getIdValue() + ")");
            }
            
            String sql = String.join(" INTERSECT ", conditions);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            rs.next();
            int btma_id = rs.getInt("BTMA_ID");
            
            sql = "SELECT * FROM BienTheMonAn WHERE MA_ID = " + idMonAn + " AND BTMA_ID = " + btma_id;
            rs = statement.executeQuery(sql);
            
            rs.next();
            bienTheMonAn_DTO.setIdMonAn(idMonAn);
            bienTheMonAn_DTO.setIdBTMA(btma_id);
            bienTheMonAn_DTO.setGia(rs.getInt("BTMA_Gia"));
            bienTheMonAn_DTO.setTinhTrang(getTinhTrangBTMA(rs.getInt("TTBT_ID")));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return bienTheMonAn_DTO;
    }
    
    public BienTheMonAn_DTO getBienTheMonAnById(int idMonAn, int idBTMA){
        Connection con = ConnectDatabase.openConnection();
        BienTheMonAn_DTO bienTheMonAn_DTO = new BienTheMonAn_DTO();
        try {
            String sql = "SELECT * FROM BienTheMonAn WHERE MA_ID = " + idMonAn + " AND BTMA_ID = " + idBTMA;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next()){
                bienTheMonAn_DTO.setIdMonAn(idMonAn);
                bienTheMonAn_DTO.setIdBTMA(idBTMA);
                bienTheMonAn_DTO.setGia(rs.getInt("BTMA_Gia"));
                bienTheMonAn_DTO.setTinhTrang(getTinhTrangBTMA(rs.getInt("TTBT_ID")));                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return bienTheMonAn_DTO;
    }
    
    public TinhTrangMonAn_DTO getTinhTrangBTMA(int id){
        Connection con = ConnectDatabase.openConnection();
        TinhTrangMonAn_DTO tinhTrangBTMA_DTO = new TinhTrangMonAn_DTO();
        try {            
            Statement statement = con.createStatement();
            String sql = "SELECT TTBT_Ten FROM TinhTrangBTMA WHERE TTBT_ID = " + id;
            ResultSet rs = statement.executeQuery(sql);
            
            rs.next();
            tinhTrangBTMA_DTO.setId(id);
            tinhTrangBTMA_DTO.setTen(rs.getNString("TTBT_Ten"));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return tinhTrangBTMA_DTO;
    }
    
    public boolean createBienTheMonAn(CreateBienTheMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        
        try{
            String sql = "INSERT INTO BienTheMonAn VALUES (?, ?, ?, ?)";
            PreparedStatement statementForBTMA = con.prepareStatement(sql);
            int btma_id = getNewestNoBTMA(data.getIdMonAn()) + 1;
            
            statementForBTMA.setInt(1, data.getIdMonAn());
            statementForBTMA.setInt(2, btma_id);
            statementForBTMA.setInt(3, data.getIdTinhTrang());
            statementForBTMA.setInt(4, data.getGia());

            if(statementForBTMA.executeUpdate() > 1){
                String sqlBTMAValues = "INSERT INTO BTMA_VALUE VALUES";
                ArrayList<String> values = new ArrayList<>();
                
                for(OptionValue_DTO option : data.getOptions())
                    values.add("(" + data.getIdMonAn() + ", " + btma_id + ", " + option.getIdOption() + ", " + option.getIdValue() + " )");
                
                sqlBTMAValues += String.join(", ", values);                
                PreparedStatement statementBTMAValues = con.prepareStatement(sqlBTMAValues);
                
                if(statementBTMAValues.executeUpdate() > 1)
                    result = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }   
        return result;
    }
    
    public boolean updateBienTheMonAn(UpdateBienTheMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        
        try{
            String sql = "UPDATE BienTheMonAn"
                + "SET TTBT_ID = ?, BTMA_Gia = ? "
                + "WHERE MA_ID = ? AND BTMA_ID = ?" ;

            PreparedStatement preparedStatementForBTMA = con.prepareStatement(sql);
            preparedStatementForBTMA.setInt(1, data.getIdTinhTrang());
            preparedStatementForBTMA.setInt(2, data.getGia());
            preparedStatementForBTMA.setInt(3, data.getIdMonAn());
            preparedStatementForBTMA.setInt(4, data.getIdBTMA());

            if(preparedStatementForBTMA.executeUpdate() > 1)
                result = true;                
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }   
        return result;
    }
    
    public boolean changeTinhTrangBTMA(int idMA, int idBTMA, int idTinhTrangBTMA){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        
        try{
            String sql = "UPDATE BienTheMonAn"
                + "SET TTBT_ID = ?"
                + "WHERE MA_ID = ? AND BTMA_ID = ?" ;

            PreparedStatement preparedStatementForBTMA = con.prepareStatement(sql);
            preparedStatementForBTMA.setInt(1, idTinhTrangBTMA);
            preparedStatementForBTMA.setInt(2, idMA);
            preparedStatementForBTMA.setInt(3, idBTMA);

            if(preparedStatementForBTMA.executeUpdate() > 1)
                result = true;                
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }   
        return result;
    }
    
    public boolean deleteBienTheMonAn(int idMonAn, int idBTMA){
        Connection con = ConnectDatabase.openConnection();
        boolean result = true;
        
        try{
            String sql = "DELETE FROM BTMA_value WHERE MA_ID = ? AND BTMA_ID = ?" ;

            PreparedStatement preparedStatementForBTMA = con.prepareStatement(sql);
            preparedStatementForBTMA.setInt(1, idMonAn);
            preparedStatementForBTMA.setInt(2, idBTMA);

            if(preparedStatementForBTMA.executeUpdate() > 1){
                sql = "DELETE FROM BienTheMonAn WHERE MA_ID = ? AND BTMA_ID = ?" ;
            
                preparedStatementForBTMA = con.prepareStatement(sql);
                preparedStatementForBTMA.setInt(1, idMonAn);
                preparedStatementForBTMA.setInt(2, idBTMA);
                
                if(preparedStatementForBTMA.executeUpdate() > 1)
                    result = true;
            }
                                
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }   
        return result;
    }
    
    private int getNewestNoBTMA(int idMonAn){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        try {            
            Statement statement = con.createStatement();
            String sql = "SELECT MAX(BTMA_ID) as BTMA_ID FROM BienTheMonAn WHERE MA_ID = " + idMonAn;
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next())
                result = rs.getInt("BTMA_ID");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    
}
