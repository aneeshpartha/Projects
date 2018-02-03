package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daocardcheck {

	connectioncheck dbcon1= new connectioncheck();	
	Statement updrecord1;
	
	public ResultSet getResultSet(String cardholdname,double number,double cvv) throws Exception {
		ResultSet result=null;
		
		//int a = Integer.parseInt(cvv);
		//int b= Integer.parseInt(number);
			try{
			
			System.out.println("\nChecking the connection to database for fetching records from table .. Please wait....");
			updrecord1= dbcon1.genconnect().createStatement();
			
			String command = "select cust_name,cvv,cardnumber from atblcarddetail where CVV= "+cvv+" and cardnumber = "+number+" and cust_name='"+cardholdname+"';";
			result= updrecord1.executeQuery(command);
			//check = logincheck(result,username1,password1);
			
			
			}catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
				
	}
	

	}
