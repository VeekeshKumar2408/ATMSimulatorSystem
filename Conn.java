package bank.management.system;

 import java.sql.*;

public class Conn {

    /* 5 Steps for JDBC Connectivity
      1. Register the Driver
      2. Create connection
      3. Create statement
      4. Executing Query
      5. Close Connection
    */
    Connection c;
    Statement s;
    public Conn() {
        try{
            //1.Registering the Driver
           //Class.forName(com.mysql.cj.jdbc.Driver);

            // 2. Creating Connection
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","password");

           //3. Create Statement , with this statement we can execute query.
           s = c.createStatement();

        }catch (Exception e){
           System.out.println(e); //Printing the error here.
        }
    }
}
