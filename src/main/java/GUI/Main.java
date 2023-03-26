package GUI;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LeAnhQuan
 */
public class Main {
    private static Connection con;
    
    public static boolean openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyNhaHang;encrypt=true;trustServerCertificate=true;";
            String username = "sa"; 
            String password= "sa";
            con = DriverManager.getConnection(dbUrl, username,password);
            return true;
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void closeConnection(){
        try{
            if(con != null) 
                con.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        openConnection();
        closeConnection();
    }
    
}
