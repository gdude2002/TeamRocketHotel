package Hotel.database.tables;

import Hotel.database.Table;
import Hotel.database.rows.Room;

import java.sql.*;

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

    public Room getRoom(Integer id) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(
                    "SELECT * FROM room WHERE id=? LIMIT 1"
            );

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Room customer = new Room();
                result.first();
                customer.setData(result);

                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
