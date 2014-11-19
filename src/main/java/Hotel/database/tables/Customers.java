package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Customers extends Table {
    public Customers(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {
    	 try {
             Statement statement = this.getConnection().createStatement();
             statement.executeUpdate(
            		 "CREATE TABLE IF NOT EXISTS customer(" +
            				 "cid INTEGER PRIMARY KEY AUTO_INCREMENT," + 
            				 "fname VARCHAR(255),"+
            				 "lname VARCHAR(255)" +
            				 ")");
            				 
            		 
       
             
         } catch (SQLException e) {
             e.printStackTrace();
         }


    }
}
