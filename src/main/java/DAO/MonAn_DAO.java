package DAO;

import DTO.MonAn.UpdateMonAn_DTO;
import DTO.MonAn.MonAn_DTO;
import DTO.MonAn.CreateMonAn_DTO;
import DTO.MonAn.OptionValueFull_DTO;
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
public class MonAn_DAO {
    public ArrayList<MonAn_DTO> getAllMonAn() {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MonAn");
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    
    public MonAn_DTO getMonAnById(int id){
        Connection con = ConnectDatabase.openConnection();
        MonAn_DTO monAn_DTO = new MonAn_DTO();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MonAn WHERE MA_ID=" + id);
        
            resultSet.next();                
            monAn_DTO.setId(id);
            monAn_DTO.setTen(resultSet.getNString("LMA_Ten")); 
            monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh")); 
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return monAn_DTO;
    }
    
     public ArrayList<MonAn_DTO> getMonAnByName(String name) {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MonAn WHERE MA_Ten LIKE '%" + name + "%'");
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
     
    public ArrayList<MonAn_DTO> getMonAnByLoaiMonAn(String id) {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<MonAn_DTO> result = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM LoaiMonAn WHERE LMA_ID = " + id);
        
            while(resultSet.next()){
                MonAn_DTO monAn_DTO = new MonAn_DTO();
                
                monAn_DTO.setId(resultSet.getInt("MA_ID"));
                monAn_DTO.setTen(resultSet.getNString("MA_Ten"));
                monAn_DTO.setHinhAnh(resultSet.getNString("MA_HinhAnh"));
                
                result.add(monAn_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }   
    
    public ArrayList<OptionValueFull_DTO> getAllOptionsValuesByMA(int idMonAn) {
        Connection con = ConnectDatabase.openConnection();
        ArrayList<OptionValueFull_DTO> result = new ArrayList<>();
        OptionValue_DAO optionValue_DAO = new OptionValue_DAO();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT OPT_ID, VAL_ID FROM BTMA_Value WHERE MA_ID = " + idMonAn);

        
            while(resultSet.next()){
                OptionValueFull_DTO optionValueFull_DTO = new OptionValueFull_DTO();
                
                int option_id = resultSet.getInt(1);
                int val_id = resultSet.getInt(2);
                
                optionValueFull_DTO.setOption(optionValue_DAO.getOptionByIdOption(option_id));
                optionValueFull_DTO.setValue(optionValue_DAO.getValueById(option_id, val_id));
                
                result.add(optionValueFull_DTO);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public int createMonAn(CreateMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        try {
            
            String sql = "INSERT INTO MonAn VALUES(?, ?, ?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getIdLoaiMonAn());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getHinhAnh());
            
            
            if(preparedStatement.executeUpdate() > 1){
                return getNewestNoMonAn();     
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return -1;
    }
    
    public boolean UpdateMonAn(UpdateMonAn_DTO data){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            String sql = "UPDATE MonAn"
                    + "SET LMA_ID = ?, MA_Ten = ?, MA_HinhAnh = ?"
                    + "WHERE MA_ID = " + data.getId();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, data.getIdLoaiMonAn());
            preparedStatement.setNString(2, data.getTen());
            preparedStatement.setNString(3, data.getHinhAnh());
            
            
            if(preparedStatement.executeUpdate() > 1){
                result = true;                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean deleteMonAn(int id){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {       
            
            String sql = "DELETE FROM BTMA_value WHERE MA_ID = ?" ;

            PreparedStatement preparedStatementForBTMA = con.prepareStatement(sql);
            preparedStatementForBTMA.setInt(1, id);

            if(preparedStatementForBTMA.executeUpdate() > 1){
                sql = "DELETE FROM BienTheMonAn WHERE MA_ID = ?";
            
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                if(preparedStatement.executeUpdate() > 1){
                    String sqlForMonAn = "DELETE FROM MonAn WHERE MA_ID = ?";

                    PreparedStatement preparedStatementForMonAn = con.prepareStatement(sqlForMonAn);
                    preparedStatementForMonAn.setInt(1, id);

                    if(preparedStatementForMonAn.executeUpdate() > 1)
                        result = true;

                }
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    public boolean hasBienThe(String id){
        Connection con = ConnectDatabase.openConnection();
        boolean result = false;
        try {
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BienTheMonAn WHERE MA_ID = " + id);
        
            result = resultSet.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con); 
        }
        return result;
    }
    
    private int getNewestNoMonAn(){
        Connection con = ConnectDatabase.openConnection();
        int result = -1;
        try {            
            Statement statement = con.createStatement();
            String sql = "SELECT MAX(MA_ID) as MA_ID FROM MonAn";
            ResultSet rs = statement.executeQuery(sql);
            
            rs.next();
            result = rs.getInt("MA_ID");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectDatabase.closeConnection(con);
        }
        
        return result;
    }
}
