package Hotel.database.tables;

import Hotel.database.Table;
import Hotel.database.rows.Booking;
import Hotel.database.rows.Customer;
import Hotel.database.rows.Room;
import com.sun.istack.internal.NotNull;

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
                Booking row = new Booking();
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

    /**
     * Get a booking by its ID. Returns null if the booking wasn't found.
     *
     * @param id The booking ID to look for
     * @return The Booking if it was found, otherwise null
     */
    public Booking getBooking(
            @NotNull Integer id  // Argument may not be null
    ) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(  // Create a prepared statement
                    "SELECT * FROM booking WHERE id=? LIMIT 1"  // The "?" is replaced later with the ID
            );
            statement.setInt(1, id);  // Replaces the first "?". This is to avoid SQL injection.
            ResultSet set = statement.executeQuery();  // Run the query

            if (set.next()) {  // If there are bookings..
                Booking booking = new Booking();  // Create the Booking object..
                set.first();  // ..Put the result set's pointer at the first row..
                booking.setData(set);  // ..and set the data in the Booking object.

                return booking;  // Return the new Booking object
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Output an error, if there is one
        }

        return null;  // Return null if there was an error or no bookings found
    }

    /**
     * Get a booking by using a Customer to look it up. Returns null if the booking wasn't found.
     *
     * @param customer The Customer object to look up with
     * @return The Booking if it was found, otherwise null
     */
    public Booking getBookingByCustomer(
            @NotNull Customer customer
    ) {
        return this.getBookingByCustomer(customer.getCid());
    }

    /**
     * Get a booking by using a Customer ID to look it up. Returns null if the booking wasn't found.
     *
     * @param id The Customer ID to look up with
     * @return The Booking if it was found, otherwise null
     */
    public Booking getBookingByCustomer(
            @NotNull Integer id
    ) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(  // Create a prepared statement
                    "SELECT * FROM booking WHERE cid=? LIMIT 1"  // The "?" is replaced later with the ID
            );
            statement.setInt(1, id);  // Replaces the first "?". This is to avoid SQL injection.
            ResultSet set = statement.executeQuery();  // Run the query

            if (set.next()) {  // If there are bookings..
                Booking booking = new Booking();  // Create the Booking object..
                set.first();  // ..Put the result set's pointer at the first row..
                booking.setData(set);  // ..and set the data in the Booking object.

                return booking;  // Return the new Booking object
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Output an error, if there is one
        }

        return null;  // Return null if there was an error or no bookings found
    }


    /**
     * Get a booking by using a Room object to look it up. Returns null if the booking wasn't found.
     *
     * @param room The Room to look up with
     * @return The Booking if it was found, otherwise null
     */
    public Booking getBookingByRoom(
            @NotNull Room room
    ) {
        return this.getBookingByRoom(room.getId());
    }


    /**
     * Get a booking by using a Room ID to look it up. Returns null if the booking wasn't found.
     *
     * @param id The Room ID to look up with
     * @return The Booking if it was found, otherwise null
     */
    public Booking getBookingByRoom(
            @NotNull Integer id
    ) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(  // Create a prepared statement
                    "SELECT * FROM booking WHERE rid=? LIMIT 1"  // The "?" is replaced later with the ID
            );
            statement.setInt(1, id);  // Replaces the first "?". This is to avoid SQL injection.
            ResultSet set = statement.executeQuery();  // Run the query

            if (set.next()) {  // If there are bookings..
                Booking booking = new Booking();  // Create the Booking object..
                set.first();  // ..Put the result set's pointer at the first row..
                booking.setData(set);  // ..and set the data in the Booking object.

                return booking;  // Return the new Booking object
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Output an error, if there is one
        }

        return null;  // Return null if there was an error or no bookings found
    }
}
