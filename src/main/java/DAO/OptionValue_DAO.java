package DAO;

import DTO.MonAn.OptionFull_DTO;
import DTO.MonAn.Option_DTO;
import DTO.MonAn.UpdateOptionValue_DTO;
import DTO.MonAn.Value_DTO;
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
public class OptionValue_DAO {
    public ArrayList<Option_DTO> getAllOptions(){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Option_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM OPTIONS";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Option_DTO option_DTO = new Option_DTO(rs.getInt(1), rs.getNString(2));
                
                result.add(option_DTO);
            }
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public ArrayList<Value_DTO> getAllValuesByOptionId(String idOption){
        Connection con = ConnectDatabase.openConnection();
        ArrayList<Value_DTO> result = new ArrayList<>();
        
        try {
            String sql = "SELECT VAL_ID, VAL_Ten FROM Option_Value WHERE OPT_ID = " + idOption;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Value_DTO value_DTO = new Value_DTO(rs.getInt(1), rs.getNString(2));
                
                result.add(value_DTO);
            }
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public Option_DTO getOptionByIdOption(int idOption){
        Connection con = ConnectDatabase.openConnection();
        Option_DTO result = new Option_DTO();
        
        try {
            String sql = "SELECT * FROM Options WHERE OPT_ID = " + idOption ;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                result.setId(rs.getInt(1));
                result.setTen(rs.getNString(2));
            }
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public Value_DTO getValueById(int idOption, int idValue){
        Connection con = ConnectDatabase.openConnection();
        Value_DTO result = new Value_DTO();
        
        try {
            String sql = "SELECT * FROM Option_Value WHERE OPT_ID = ? AND VAL_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, idOption);
            statement.setInt(2, idValue);
            
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                result.setId(rs.getInt(1));
                result.setTen(rs.getNString(2));
            }
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    public OptionFull_DTO getOptionFullByIdOption(int idOption){
        Connection con = ConnectDatabase.openConnection();
        OptionFull_DTO result = new OptionFull_DTO();
        
        try {
            String sql = "SELECT VAL_ID, VAL_Ten FROM Option_Value WHERE OPT_ID = " + idOption ;
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Value_DTO> values = new ArrayList<>();
            while(rs.next()){
                Value_DTO value_DTO = new Value_DTO();
                
                value_DTO.setId(rs.getInt(1));
                value_DTO.setTen(rs.getNString(2));
                
                values.add(value_DTO);
            }
            
            Option_DTO option_DTO = getOptionByIdOption(idOption);
            
            result.setId(idOption);
            result.setTen(option_DTO.getTen());
            result.setValue(values);
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    
    public boolean createValue(int idOption, String tenValue){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "INSERT INTO Option_Value VALUES(?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            int val_id = getNewestNoValue(idOption) + 1;
            
            statement.setInt(1, idOption);
            statement.setInt(2, val_id);
            statement.setNString(3, tenValue);
            
            if(statement.executeUpdate() > 1)
                result = true;
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    public boolean updateValue(UpdateOptionValue_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        
        try {
            String sql = "UPDATE Option_Value SET VAL_Ten = ? WHERE OPT_ID = ? AND VAL_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setNString(1, data.getTenValue());
            statement.setInt(2, data.getIdOption());
            statement.setInt(3, data.getIdValue());
            
            if(statement.executeUpdate() > 1)
                result = true;
            
        } catch(SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
    
    private int getNewestNoValue(int idOption){
        Connection con = ConnectDatabase.openConnection();
        int result = 0;
        try {            
            Statement statement = con.createStatement();
            String sql = "SELECT MAX(VAL_ID) as VAL_ID FROM Option_Value WHERE OPT_ID = " + idOption;
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next())
                result = rs.getInt("VAL_ID");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
