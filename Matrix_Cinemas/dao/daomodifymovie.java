package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daomodifymovie {

	connectioncheck dbcon1= new connectioncheck();	
	Statement updrecord1;
	
	public ResultSet modifymov() throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select Theatre_name from tbltheatre;";
			result= updrecord1.executeQuery(command);
							
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	
	public ResultSet modifynewmov(String theatre) throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select Movie_name from tblmovie where Movie_id not in ( select distinct(Movie_id) from atblmovierun where Theatre_id= (select Theatre_id from tbltheatre where Theatre_name like '"+theatre+"'));";
			result= updrecord1.executeQuery(command);
						
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	
	public ResultSet modifyoldmov(String theatre) throws Exception {
		ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select Movie_name from tblmovie where Movie_id in ( select distinct(Movie_id) from atblmovierun where Theatre_id = (select Theatre_id from tbltheatre where Theatre_name like '"+theatre+"'));";
			result= updrecord1.executeQuery(command);
						
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	
	public void tblmoviemodify(String theatre,String Newmovie,String oldmovie) throws Exception{
//ResultSet result=null;
		
		try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "update atblmovierun set movie_id = (select Movie_id from tblmovie where Movie_name like '"+Newmovie+"') where movie_id = (select Movie_id from tblmovie where Movie_name like '"+oldmovie+"') and theatre_id= (select Theatre_id from tbltheatre where Theatre_name like '"+theatre+"');";
			int b= updrecord1.executeUpdate (command);
			System.out.println("updated");			
			updrecord1.close();	
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}
}
