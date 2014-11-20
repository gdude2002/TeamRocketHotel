package Hotel.database.tables;

import Hotel.database.Table;
import Hotel.database.rows.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Rooms extends Table {
    public Rooms(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {
    	 try {
             Statement statement = this.getConnection().createStatement();

             statement.executeUpdate(
                 "CREATE TABLE IF NOT EXISTS room(" +
                     "id INTEGER PRIMARY KEY," +
                     "roomType INTEGER," +
                     "roomCost INTEGER," +
                     "status BOOLEAN" +
                 ")"
             );

             System.out.println("== Rooms (if any) ==");

             ResultSet r = statement.executeQuery("SELECT * FROM room");

             while (r.next()) {
                 Room row = new Room();
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
