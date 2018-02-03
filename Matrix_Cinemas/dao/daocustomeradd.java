package dao;

import java.sql.SQLException;
import java.sql.Statement;

import Model.Customers;


public class daocustomeradd extends Customers{
	
	connectioncheck dbcon= new connectioncheck();	
	Statement updrecord;
	int res;
	public int inserts(/**Customers customer,**/String username,String password) throws Exception {
		
		try {
			
			System.out.println("\nChecking the connection to database for inserting records into table .. Please wait....");
			updrecord= dbcon.genconnect().createStatement();
			System.out.println("\nInserting records into the table. Please wait");
			
							
			String command="insert into atblcustomer(Cust_id,Cust_fname,Cust_lname,Cust_phno,Cust_email,Cust_address) "
					+ "values ('"+getCustomer().getCust_id()+"','"+getCustomer().getCust_fname()+"','"+getCustomer().getCust_lname()+"','"+getCustomer().getCust_phno()+"','"+getCustomer().getCust_email()+"','"+getCustomer().getCust_address()+"');";
			String command1="insert into a_login(username,password,user_type,cust_id) "
					+ "values ('"+username+"','"+password+"','customer','"+getCustomer().getCust_id()+"');";
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
