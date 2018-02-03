package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Movie;

public class daocustomerview {
	
	connectioncheck dbcon1= new connectioncheck();	
	Statement updrecord1;
	
	public ResultSet getResultSet(String username,String password) throws Exception {
		ResultSet result=null;
		
		//int a = Integer.parseInt(cvv);
		//int b= Integer.parseInt(number);
			try{
			System.out.println(username+password);
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select Cust_id,Cust_fname,Cust_lname,Cust_phno,cust_email,cust_address from atblcustomer where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"');";
			result= updrecord1.executeQuery(command);
			//check = logincheck(result,username1,password1);
			
			
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}

	
	connectioncheck dbcon= new connectioncheck();	
	Statement updrecord;
	int res;
	public int modifyuser(String username,String password,String fname,String lname,int phno,String email,String address){
		
		try {
				
				System.out.println("\nChecking the connection to database for inserting records into table .. Please wait....");
				updrecord= dbcon.genconnect().createStatement();
				System.out.println("\nInserting records into the table. Please wait");
				
								
				String command1= "update atblcustomer set Cust_fname='"+fname+"' where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"')";
				String command2= "update atblcustomer set Cust_lname='"+lname+"' where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"')";
				String command3= "update atblcustomer set Cust_phno='"+phno+"' where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"')";
				String command4= "update atblcustomer set cust_email='"+email+"' where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"')";
				String command5= "update atblcustomer set cust_address='"+address+"' where cust_id = ( select  cust_id from a_login where username='"+username+"' and password ='"+password+"')";
				
				res=updrecord.executeUpdate(command1);
				res=updrecord.executeUpdate(command2);
				res=updrecord.executeUpdate(command3);
				res=updrecord.executeUpdate(command4);
				res=updrecord.executeUpdate(command5);
			
				
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
			return 1;
		}
		
	}
	

