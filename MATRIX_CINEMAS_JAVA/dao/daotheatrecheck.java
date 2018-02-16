package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daotheatrecheck {
	
	connectioncheck dbcon1= new connectioncheck();	
	Statement updrecord1;
	
	public ResultSet getResultSet(String comboselect) throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select Theatre_name from tbltheatre where Theatre_city = '"+comboselect+"';";
			result= updrecord1.executeQuery(command);
			//check = logincheck(result,username1,password1);
			
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	

	}



