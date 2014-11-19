package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer extends Table {
    public Customer(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {
    	 try {
             Statement statement = this.getConnection().createStatement();
             statement.executeUpdate(
            		 "CREATE TABLE IF NOT EXISTS customer" +
            				 "cid INTEGER PRIMARY KEY AUTO_INCREMENT," + 
            				 "fname VARCHAR(255),"+
            				 "lname VARCAR(255)");
            				 
            		 
       
             
         } catch (SQLException e) {
             e.printStackTrace();
         }


    }
}
