import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

class timecalc {


public static void calcset1(){

String url = "jdbc:mysql://localhost";
String user = "root";
String password = "safestsystemever";
System.out.println("\nData set 1 - 1990");
System.out.println("-----------------");
try {
long startTime = System.currentTimeMillis();
Connection con;
con=DriverManager.getConnection(url,user,password);
Statement updrecord = con.createStatement();

ResultSet result = null;
String command = "Select max(temp) from hadoop_class.temp1;";
result=updrecord.executeQuery(command);

while(result.next()){
System.out.println("\nMaximum temperature is : "+result.getInt(1));
}
long stopTime = System.currentTimeMillis();
System.out.println("Time taken is"+(stopTime - startTime)+"milliseconds");

}catch(Exception e){
e.printStackTrace();
}


}


public static void calcset2(){

long startTime = System.currentTimeMillis();
String url = "jdbc:mysql://localhost";
String user = "root";
String password = "safestsystemever";

System.out.println("\nData set 2 - 1990,1992");
System.out.println("----------------------");
try {

Connection con;
con=DriverManager.getConnection(url,user,password);
System.out.println("Success");
Statement updrecord = con.createStatement();

ResultSet result = null;

String command = "Select max(temp) from hadoop_class.temp2 where years=1990;";
result=updrecord.executeQuery(command);

//String command1 = "Select max(temp) from hadoop_class.temp2 where years=1992;";
//result1=updrecord.executeQuery(command1);

while(result.next()){
System.out.println("\nMaximum temperature of year 1990 is : "+result.getInt(1));

}

ResultSet result1 = null;
String command1 = "Select max(temp) from hadoop_class.temp2 where years=1992;";
result1=updrecord.executeQuery(command1);
while(result1.next()){
System.out.println("\nMaximum temperature of year 1992 is : "+result1.getInt(1));
}

long stopTime = System.currentTimeMillis();
System.out.println("Total time taken is "+(stopTime - startTime)+"milliseconds");
}catch(Exception e){
e.printStackTrace();
}


}

public static void calcset3(){

long startTime = System.currentTimeMillis();
String url = "jdbc:mysql://localhost";
String user = "root";
String password = "safestsystemever";

try {

Connection con;
con=DriverManager.getConnection(url,user,password);
System.out.println("Success");
Statement updrecord = con.createStatement();

ResultSet result = null;
String command = "Select max(temp) from hadoop_class.temp3 where years=1990;";
result=updrecord.executeQuery(command);
while(result.next()){
System.out.println("\nMaximum temperature of year 1990 is : "+result.getInt(1));
}


ResultSet result1 = null;
String command1 = "Select max(temp) from hadoop_class.temp3 where years=1991;";
result1=updrecord.executeQuery(command1);
while(result1.next()){
System.out.println("\nMaximum temperature of year 1991 is : "+result1.getInt(1));
}


ResultSet result2 = null;
String command2 = "Select max(temp) from hadoop_class.temp3 where years=1992;";
result2=updrecord.executeQuery(command2);
while(result2.next()){
System.out.println("\nMaximum temperature of year 1992 is : "+result2.getInt(1));
}

ResultSet result3 = null;
String command3 = "Select max(temp) from hadoop_class.temp3 where years=1993;";
result3=updrecord.executeQuery(command3);
while(result3.next()){
System.out.println("\nMaximum temperature of year 1993 is : "+result3.getInt(1));
}

long stopTime = System.currentTimeMillis();
System.out.println(stopTime - startTime);
}catch(Exception e){
e.printStackTrace();
}
}
public static void main(String args[]){

System.out.println("Enter the operation you want to perform");
System.out.println("1.Find maximum temperature of set 1990");
System.out.println("2.Find maximum temperature of set 1990 and 1992");
System.out.println("3.Find maximum temperature of set 1990,1991,1992 and 1993");

Scanner scan = new Scanner(System.in);
int user_input = scan.nextInt();

switch(user_input){

case 1: calcset1();
        break;
case 2:calcset2();
       break;
case 3:calcset3();
break;
default : System.out.println("Invalid selection");
          break;

}
}

}

