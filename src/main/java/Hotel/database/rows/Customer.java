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
			this.cid = resultSet.getInt(cid);
	
			this.fName = resultSet.getString(fName);
			this.lName = resultSet.getString(lName);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public String toString(){
		return String.format("CID : %d | firstName : %s | lastName : %s ",this.cid,this.fName,this.lName);
	}
}