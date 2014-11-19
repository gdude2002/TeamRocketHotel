import database.Connection;

import java.sql.SQLException;

public class Main {

    public static void main(String ... args) {
        Connection conn = null;
        try {
            conn = new Connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(conn.toString());
    }
}
