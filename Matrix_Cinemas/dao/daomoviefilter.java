package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daomoviefilter {
	
	
		connectioncheck dbcon1= new connectioncheck();	
		Statement updrecord1;
		
		public ResultSet getResultSetmoviecheck(String comboselect,String moviefilter) throws Exception {
			ResultSet result=null;
			
			try{
				
				System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
				updrecord1= dbcon1.genconnect().createStatement();
				
				String command = "select Movie_name,movie_pic from tblmovie where Movie_id in (select distinct(Movie_id) from atblmovierun where Theatre_id = ( select Theatre_id from tbltheatre where Theatre_name ='"+moviefilter+"'))";
				result= updrecord1.executeQuery(command);
						
				}catch (SQLException e){
				e.printStackTrace();
			}
			
			return result;
					
		}
		

		}



