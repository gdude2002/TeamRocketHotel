package Hotel.database.rows;

import Hotel.database.Row;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room implements Row {
    private Integer id;
    private Integer roomType;
    private Integer roomCost;
    private Boolean status;

    @Override
    public void setData(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.roomType = resultSet.getInt("roomType");
        this.roomCost = resultSet.getInt("roomCost");
        this.status = resultSet.getBoolean("status");
    }

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(Integer roomCost) {
        this.roomCost = roomCost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    // endregion

    public String toString() {
        return String.format(
                "ID: %s | roomType: %s | roomCost: %s | status: %s",
                this.id, this.roomType, this.roomCost, this.status
        );
    }
}
