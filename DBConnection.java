package application;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection{
	 public static Connection Connector()  {
		 
	        // creates three different Connection objects
	        Connection conn = null;
	        
	        
	        try {
	            // connect way #1
	            String url1 = "jdbc:mysql://192.168.56.2:3306/wuc";
	            String user = "student";
	            String password = "student";
	 
	            conn = DriverManager.getConnection(url1, user, password);
	            
	            return conn;
	 
	           
	        } catch (SQLException ex) {
	            
	            return null;
	        }
	    }
	 public static void main(String[] args)
	 {
		 
	 }
}
