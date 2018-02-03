package dao;

import java.sql.*;

public class daologin {
	
	connectioncheck dbcon= new connectioncheck();	
	Statement updrecord;
	
	public ResultSet getResultSet() throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord= dbcon.genconnect().createStatement();
			
			String command = "select username,password,user_type from a_login;";
			result= updrecord.executeQuery(command);
			//check = logincheck(result,username1,password1);	
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public ResultSet getResultSetadmin() throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord= dbcon.genconnect().createStatement();
			
			String command = "select username,password,user_type from a_login where user_type='admin';";
			result= updrecord.executeQuery(command);
			//check = logincheck(result,username1,password1);	
				
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}

	}
