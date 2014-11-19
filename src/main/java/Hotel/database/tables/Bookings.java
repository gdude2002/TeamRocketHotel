package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
