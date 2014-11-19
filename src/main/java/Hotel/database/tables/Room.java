package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Room extends Table {
    public Room(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {
    	 try {
             Statement statement = this.getConnection().createStatement();
             statement.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS room(" +
                             "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                             "roomType INTEGER," +
                             "roomCost INTEGER," +
                             "status BOOLEAN" +
                     ")"
             );
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
