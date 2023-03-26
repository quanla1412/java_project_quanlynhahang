package com.mycompany.quanlynhahang;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LeAnhQuan
 */
public class ConnectDatabase {    
    public static Connection openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyNhaHang";
            String username = "admin"; 
            String password= "admin";
            Connection con = DriverManager.getConnection(dbUrl, username,password);
            return con;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null) 
                con.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
