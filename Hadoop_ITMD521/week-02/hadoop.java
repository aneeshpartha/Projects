import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.*;

public class hadoop {


//public static LinkedList<Integer> filecontent = new LinkedList<Integer>();

public static  void readData() {

  String url = "jdbc:mysql://localhost";

  String user = "root";

   String password = "safestsystemever";
   
BufferedReader br = null;



try 
{
	
 Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
			Statement updrecord = con.createStatement();
		
			   
br=new BufferedReader (new FileReader("/vagrant/compfold/1990"));

String line;

Integer temp;

while(( line = (br.readLine()))!= null){

 if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }
//temp = Integer.parseInt(line.substring(88,92));

if(temp==9999){
	
}

else {
	

String command = "insert into hadoop_class.temp1 values(1990,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";

	         //   Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command);
System.out.println("Inserting record "+temp);
}
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));
ResultSet result=null;
		String command = "select max(temp) from hadoop_class.temp1;";
	    result= updrecord.executeQuery(command);
			
               while(result.next()){
			   System.out.println("\nMaximum temperature is :"+result.getInt(1));
		   }

}catch(FileNotFoundException e){
System.out.println("*********************************************Alert***********************************************!!!");
System.out.println("The file is not available in the location given . Kindly place the file or correct the file path\n");
System.out.println("Please find below the details of error....\n");
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
e.printStackTrace();
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
}catch(IOException e)
{
e.printStackTrace();
}catch(Exception e){

System.out.println("Error found!!!!");
}
finally {
}

try {
br.close();
} catch (IOException e) {
e.printStackTrace();
}

//connect();
}

static int maxtemp4;

public static void readDataset1(){



  String url = "jdbc:mysql://localhost";

  String user = "root";

   String password = "safestsystemever";
   
BufferedReader br = null;
BufferedReader cr = null;

try 
{
	
 Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
			Statement updrecord = con.createStatement();
		
			   
br=new BufferedReader (new FileReader("/vagrant/compfold/1990"));
cr=new BufferedReader (new FileReader("/vagrant/compfold/1992"));

String line;

Integer temp;

while(( line = (br.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));
if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }

if(temp==9999){
	
}

else {
	

String command = "insert into hadoop_class.temp2 values(1990,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	         //   Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command);
			   System.out.println("Inserting temperature "+temp);
}
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));
ResultSet result=null;
		String command = "select max(temp) from hadoop_class.temp2 where years=1990;";
	    result= updrecord.executeQuery(command);
			
               while(result.next()){
			  maxtemp4=result.getInt(1); 
		   }



while(( line = (cr.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));

if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }

if(temp==9999){
	
}

else {
	

String command1 = "insert into hadoop_class.temp2 values(1992,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	           // Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command1);
			   System.out.println("Inserting temperature "+temp);
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));

}
System.out.println("\nMaximum temperature for year 1990 is "+maxtemp4);
ResultSet result1=null;
		String command2 = "select max(temp) from hadoop_class.temp2 where years=1992;";
	    result1= updrecord.executeQuery(command2);
			
               while(result1.next()){
			   System.out.println("\nMaximum temperature is "+result1.getInt(1));
		   }
}catch(FileNotFoundException e){
System.out.println("*********************************************Alert***********************************************!!!");
System.out.println("The file is not available in the location given . Kindly place the file or correct the file path\n");
System.out.println("Please find below the details of error....\n");
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
e.printStackTrace();
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
}catch(IOException e)
{
e.printStackTrace();
}catch(Exception e){

System.out.println("Error found!!!!");
}
finally {
}

try {
br.close();
} catch (IOException e) {
e.printStackTrace();
}

	
}

static int maxtemp1;
static int maxtemp2;
static int maxtemp3;

public static void readDataset2(){


  String url = "jdbc:mysql://localhost";

  String user = "root";

   String password = "safestsystemever";
   
BufferedReader br = null;
BufferedReader cr = null;
BufferedReader dr = null;
BufferedReader er = null;

try 
{
	
 Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
			Statement updrecord = con.createStatement();
		
			   
br=new BufferedReader (new FileReader("/vagrant/compfold/1990"));
cr=new BufferedReader (new FileReader("/vagrant/compfold/1991"));
dr=new BufferedReader (new FileReader("/vagrant/compfold/1992"));
er=new BufferedReader (new FileReader("/vagrant/compfold/1993"));

String line;

Integer temp;

while(( line = (br.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));

if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }

if(temp==9999){
	
}

else {
	

String command = "insert into hadoop_class.temp3 values(1990,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	           // Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command);
			   System.out.println("Inserting temperature "+temp);
}
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));

ResultSet result=null;
		String query = "select max(temp) from hadoop_class.temp3 where years=1990;";
	    result= updrecord.executeQuery(query);
			
               while(result.next()){
			   maxtemp1=result.getInt(1);
		   }



while(( line = (cr.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));
if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }

if(temp==9999){
	
}

else {
	

String command1 = "insert into hadoop_class.temp3 values(1991,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	         //   Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command1);
			   System.out.println("Inserting temperature "+temp);
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));
}
ResultSet result1=null;
		String command2 = "select max(temp) from hadoop_class.temp3 where years=1991;";
	    result1= updrecord.executeQuery(command2);
			
               while(result1.next()){
			   maxtemp2=result1.getInt(1);
		   }


while(( line = (dr.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));

if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }

if(temp==9999){
	
}

else {
	

String query2 = "insert into hadoop_class.temp3 values(1992,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	         //   Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(query2);
			   System.out.println("Inserting temperature "+temp);
}
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));
ResultSet result2=null;
		String command3 = "select max(temp) from hadoop_class.temp3 where years=1992;";
	    result2= updrecord.executeQuery(command3);
			
               while(result2.next()){
			   maxtemp3=result2.getInt(1);
		   }


while(( line = (er.readLine()))!= null){

//temp = Integer.parseInt(line.substring(88, 92));

if (line.charAt(87) == '+') { 
temp = Integer.parseInt(line.substring(88,92));    
 } 
 else 
 {      temp = Integer.parseInt(line.substring(87,92));   
 }
 
if(temp==9999){
	
}

else {
	

String query4 = "insert into hadoop_class.temp3 values(1993,"+temp+","+Integer.parseInt(line.substring(4,10))+","+Integer.parseInt(line.substring(10,15))+","+Integer.parseInt(line.substring(15,23))+","+Integer.parseInt(line.substring(23,27))+","+Integer.parseInt(line.substring(60,63))+","+Integer.parseInt(line.substring(29,34))+","+Integer.parseInt(line.substring(35,41))+","+Integer.parseInt(line.substring(47,51))+","+Integer.parseInt(line.substring(94,98))+");";
	          //  Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(query4);
			   System.out.println("Inserting temperature "+temp);
}
}			   
//filecontent.add(Integer.parseInt(line.substring(88, 92)));
//filecontent.add(Arrays.asList(line.split(",")));

System.out.println("\n Maximum temperature for the year 1990 is "+maxtemp1);
System.out.println("\n Maximum temperature for the year 1991 is "+maxtemp2);
System.out.println("\n Maximum temperature for the year 1992 is "+maxtemp3);

ResultSet result3=null;
		String command4 = "select max(temp) from hadoop_class.temp3 where years=1993;";
	    result3= updrecord.executeQuery(command4);
			
               while(result3.next()){
			   System.out.println("\nMaximum temperature is "+result3.getInt(1));
		   }


}catch(FileNotFoundException e){
System.out.println("*********************************************Alert***********************************************!!!");
System.out.println("The file is not available in the location given . Kindly place the file or correct the file path\n");
System.out.println("Please find below the details of error....\n");
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
e.printStackTrace();
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
}catch(IOException e)
{
e.printStackTrace();
}catch(Exception e){

System.out.println("Error found!!!!");
}
finally {
}

try {
br.close();
} catch (IOException e) {
e.printStackTrace();
}

	
}

/**
public static void connect(){
  String url = "jdbc:mysql://localhost";
  String user = "root";
   String password = "safestsystemever";
        try {
            Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
          /// String command="insert into hadoop_class.temp1 values (?,?)";
          // PreparedStatement pstmt = con.prepareStatement(command);
           for (Integer temp : filecontent){
                         //  pstmt.setInt(1,1990);
			  // pstmt.setInt(2,temp);		    
                          // pstmt.addBatch();
                   String command = "insert into hadoop_class.temp1 values(1990,"+temp+");";
	           Statement updrecord = con.createStatement();
	           updrecord.executeUpdate(command);
		   }
		   
	//	   pstmt.executeBatch();
		   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
**/

/**public  static void getResultSet() {
	
	
	
		
		  String url = "jdbc:mysql://localhost";
  String user = "root";
   String password = "safestsystemever";
   
   try 
{
	
            Connection con;
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
				
		Statement updrecord = con.createStatement();
		
		ResultSet result=null;
		String command = "select max(temp) from hadoop_class.temp2;";
	    result= updrecord.executeQuery(command);
			
               while(result.next()){
			   System.out.println(result.getInt(1));
		   }
		   
	}catch (SQLException e){
		e.printStackTrace();
	}
	
	
	
}**/

public static void main(String args[]){

//getResultSet();

	System.out.println("Enter the operation you want to perform");
	System.out.println("1.Find maximum temperature of set 1990");
	System.out.println("2.Find maximum temperature of set 1990 and 1992");
	System.out.println("3.Find maximum temperature of set 1990,1991,1992 and 1993");
		
	Scanner scan = new Scanner(System.in);
		int user_input = scan.nextInt();
		
		switch(user_input){
		
		case 1: readData();
		        break;
		case 2: readDataset1();
		        break;
	    case 3:readDataset2();
		       break;
		default : System.out.println("Invalid selection");
			      break;
			
		}

}
}
