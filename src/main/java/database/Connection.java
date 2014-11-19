package database;

import java.sql.*;

public class Connection {
//    private static Table customer;
//    private static Table booking;
//    private static Table room;

    public Connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        final String username = "root";
        final String password = "fastralee";

        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", username, password);
    }
}
