package Hotel.database.tables;

import Hotel.database.Table;

import java.sql.Connection;

public class Customer extends Table {
    public Customer(Connection conn) {
        super(conn);
    }

    @Override
    public void setup() {

    }
}
