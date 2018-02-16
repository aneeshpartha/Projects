package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoscreenselection {
	
		connectioncheck dbcon1= new connectioncheck();	
		Statement updrecord1;
		
		public ResultSet getResultSet(String theatre,String moviename,String showtime) throws Exception {
			ResultSet result=null;
			
			try{
				
				System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
				updrecord1= dbcon1.genconnect().createStatement();
				
				String command = "select Screen_name from atblscreen where Screen_id = (select Screen_id from atblmovierun where Movie_id = ( select Movie_id from tblmovie where Movie_name = '"+moviename+"' ) and Theatre_id = ( select Theatre_id from tbltheatre where Theatre_name='"+theatre+"') and Showid = (select Showid from atblshow where showtime='"+showtime+"'));";
				result= updrecord1.executeQuery(command);
				//check = logincheck(result,username1,password1);
				
				}catch (SQLException e){
				e.printStackTrace();
			}
			
			return result;
					
		}
		

		}
