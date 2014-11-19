package Hotel.database.rows;

import Hotel.database.Row;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Booking implements Row {
    private Integer id;
    private Integer cid;
    private Integer rid;
    private Date arrivalDate;
    private Date departureDate;

    @Override
    public void setData(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.cid = resultSet.getInt("cid");
            this.rid = resultSet.getInt("rid");
            this.arrivalDate = resultSet.getDate("arrival");
            this.departureDate = resultSet.getDate("departure");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    // endregion

    public String toString() {
        return String.format(
                "ID: %s | CID: %s | RID: %s | Arrival: %s | Departure: %s",
                this.id, this.cid, this.rid, this.arrivalDate, this.departureDate
        );
    }
}
