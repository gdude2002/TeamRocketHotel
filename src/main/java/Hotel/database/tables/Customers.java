package Hotel.database.tables;

import Hotel.database.Table;
import Hotel.database.rows.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
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

             System.out.println("== Customers (if any) ==");

             ResultSet r = statement.executeQuery("SELECT * FROM customer");

             while (r.next()) {
                 Customer row = new Customer();
                 row.setData(r);
                 System.out.println(row);
             }

             // Do cleanup
             r.close();
             statement.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }


    }
}
