package Hotel.database.rows;

import Hotel.database.Row;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer implements Row {

	private String fName ;
	private String lName;
	private Integer cid;

	@Override
	public void setData(ResultSet resultSet) {

		try {
			this.cid = resultSet.getInt("cid");

			this.fName = resultSet.getString("fname");
			this.lName = resultSet.getString("lname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getfirstName() {
		return fName;
	}

	public void setfirstName(String firstName) {
		this.fName = firstName;
	}

	public String getlastName() {
		return lName;
	}

	public void setlastName(String lastName) {
		this.lName = lastName;
	}

	public Integer getCid() {
		return cid;
	}

	public String toString(){
		return String.format(
				"CID: %d | firstName: %s | lastName: %s ",
				this.cid, this.fName, this.lName
		);
	}
}
