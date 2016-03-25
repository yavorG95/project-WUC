package application;

import java.sql.*;

public class LoginModel {

	Connection connection;
	
	public LoginModel()
	{
		connection = DBConnection.Connector();
		if (connection == null) System.exit(1);
	}
	
	public boolean isDBconnected() {
		try{
			return !connection.isClosed();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException{
		PreparedStatement prStatement = null;
		ResultSet reSet = null;
		String query = "select * from staff where staff_id = ? and password = ?";
		try{
			prStatement = connection.prepareStatement(query);
			prStatement.setString(1,user);
			prStatement.setString(2,pass);
			
			reSet = prStatement.executeQuery();
			
			if(reSet.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		} 
		finally {
			prStatement.close();
			reSet.close();
		}
	}
}
