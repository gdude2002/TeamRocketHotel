package Hotel.database;

import Hotel.database.tables.Booking;
import Hotel.database.tables.Customer;
import Hotel.database.tables.Room;

import java.sql.*;

public class Connection {
    private final java.sql.Connection connection;
    private static Table customer;
    private static Table booking;
    private static Table room;

    public Connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  // Load JDBC driver

        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", "root", "fastralee"
        );

        Statement statement = this.connection.createStatement();
        statement.execute("CREATE DATABASE IF NOT EXISTS hotel");
        statement.execute("USE hotel");

        Connection.booking = new Booking(this.connection);
        Connection.booking.setup();

        Connection.customer = new Customer(this.connection);
        Connection.customer.setup();

        Connection.room = new Room(this.connection);
        Connection.room.setup();
    }
}
