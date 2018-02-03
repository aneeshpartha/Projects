package dao;

import java.sql.SQLException;
import java.sql.Statement;

import Model.admin;

public class daoadminadd {

		
		connectioncheck dbcon= new connectioncheck();	
		Statement updrecord;
		int res;
		public int inserts(admin adm,String username,String password) throws Exception {
			
			try {
				
				System.out.println("\nChecking the connection to database for inserting records into table .. Please wait....");
				updrecord= dbcon.genconnect().createStatement();
				System.out.println("\nInserting records into the table. Please wait");
				
								
				String command="insert into atbladmin(admin_id,admin_name,admin_email,admin_number,admin_address) "
						+ "values ('"+adm.getAdmin_id()+"','"+adm.getAdmin_name()+"','"+adm.getAdmin_email()+"','"+adm.getAdmin_number()+"','"+adm.getAdmin_address()+"');";
				String command1="insert into a_login(username,password,user_type,admin_id) "
						+ "values ('"+username+"','"+password+"','admin','"+adm.getAdmin_id()+"');";
				res=updrecord.executeUpdate(command);
				updrecord.executeUpdate(command1);
				
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


