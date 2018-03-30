//Checking to see if we can connect to our MySQL database using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Connectivity //create class Connectivity
{ 
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 
     static final String DB_URL = "jdbc:mysql://localhost/demo"; // server=localhost, databse name=demo
 
     //  Database credentials
     static final String USER = "root" ;
     static final String PASS = "root";
    
     public static void main(String[] args) //main method
     {
      Connection conn = null;//create object of Connection and define it null //Connection is class in SQL package
      try //try block
      {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        //print on console
      System.out.println("Connected database successfully...");      
                }
      catch(SQLException se) //catch block
      {
      //Handle errors for JDBC
      se.printStackTrace();
      }
      catch(Exception e) //catch block
      {
      //Handle errors for Class.forName
      e.printStackTrace();
      }
      finally  //finally block
      {
      //finally block used to close resources
      try  //try block
      {
      if(conn!=null)//condition
      conn.close(); //close connection
      }
      catch(SQLException se)//Handle errors
      {
      se.printStackTrace();
      }//end finally try
      }//end try
      System.out.println("Goodbye!"); //print on console
     }//end main
}