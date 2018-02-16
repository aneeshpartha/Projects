package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectioncheck {
	
		Connection dbcon=null;
		public Connection genconnect(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver file missing");
				e.printStackTrace();
			}
			
			
			try{
				
				dbcon = DriverManager.getConnection("jdbc:mysql://www.papademas.net:3306/fp","dbfp","510");
				System.out.println("Connection established to the database !!!");	
			    }
			catch(SQLException se){
				System.out.println("Problem in connecting to the database. Please investigate");
				se.printStackTrace();
				
			}catch(Exception e)
			{
				e.printStackTrace();
				
			}
			return dbcon;
					
			}
	}



