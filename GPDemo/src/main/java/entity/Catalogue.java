package entity;

public class Catalogue {
	private Integer c_id;//分类id
	private String c_name;//分类名称
	private String c_status;//分类区分状态值

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_status() {
		return c_status;
	}

	public void setC_status(String c_status) {
		this.c_status = c_status;
	}

	@Override
	public String toString() {
		return "Catalogue [c_id=" + c_id + ", c_name=" + c_name + ", c_status=" + c_status + "]";
	}
	
}

