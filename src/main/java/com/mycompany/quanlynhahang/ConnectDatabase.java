package com.mycompany.quanlynhahang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LeAnhQuan
 */
public class ConnectDatabase {    
    
    public static Connection openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyNhaHang;encrypt=true;trustServerCertificate=true;";
            String username = "sa"; 
            String password= "sa";
            Connection con = DriverManager.getConnection(dbUrl, username,password);
            return con;
        } catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null) 
                con.close();
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
