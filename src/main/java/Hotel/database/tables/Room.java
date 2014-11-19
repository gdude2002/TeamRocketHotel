package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;

public class Room extends Table {
    public Room(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {

    }
}
