package Hotel.database.tables;

import Hotel.database.Table;
import Hotel.database.rows.Booking;

import java.sql.*;

public class Bookings extends Table {
    public Bookings(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {
        try {
            Statement statement = this.getConnection().createStatement();
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS booking(" +
                            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                            "cid INTEGER," +
                            "rid INTEGER," +
                            "arrival DATE NOT NULL," +
                            "departure DATE NOT NULL" +
                            ")"
            );

            System.out.println("== Bookings (if any) ==");

            ResultSet r = statement.executeQuery("SELECT * FROM booking");

            while (r.next()) {
                Booking b = new Booking();
                b.setData(r);
                System.out.println(b);
            }

            // Do cleanup
            r.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
