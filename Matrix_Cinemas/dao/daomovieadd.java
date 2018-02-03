package dao;

import java.sql.SQLException;
import java.sql.Statement;

import Model.Movie;

public class daomovieadd {
	
	connectioncheck dbcon= new connectioncheck();	
	Statement updrecord;
	int res;
	public int inserts(Movie mov) throws Exception {
		try {
			
			System.out.println("\nChecking the connection to database for inserting records into table .. Please wait....");
			updrecord= dbcon.genconnect().createStatement();
			System.out.println("\nInserting records into the table. Please wait");
			
							
			String command="insert into tblmovie(Movie_id,Movie_name,movie_pic,movie_desc) "
					+ "values ('"+mov.getMovie_id()+"','"+mov.getMovie_name()+"','"+mov.getMovie_pic()+"','"+mov.getMovie_desc()+"');";
			
			res=updrecord.executeUpdate(command);
		
			
			System.out.println("Values are inserted into table");
		  
		  updrecord.close();
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		return res;
	}

}
