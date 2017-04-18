package entity;

public class UserBean {
	String id;
	String upsd;
	String uname;
	
	public UserBean(String id, String upsd, String uname) {
		super();
		this.id = id;
		this.upsd = upsd;
		this.uname = uname;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getUpsd() {
		return upsd;
	}

	public void setUpsd(String upsd) {
		this.upsd = upsd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}
