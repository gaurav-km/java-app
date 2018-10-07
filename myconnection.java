
import java.sql.Connection;
import java.sql.DriverManager;

 
 import java.sql.*;
public class myconnection {
 

     
   public static Connection getconnection()
    {
        
          
      
      Connection conn=null;
      try {
          
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("hurrey");
          
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javacontactapp","root","");
      }
      
      catch(Exception ex)
      {
          System.out.println(ex.getMessage());
          
      }
      return conn;
    }

}

     
    

     //  return conn; 
        
    
    

    
    

   
   
     


  

