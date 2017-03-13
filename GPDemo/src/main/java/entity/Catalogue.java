package entity;

/**
 * catalogue一级目录表实体类
* (这里用一句话描述这个类的作用)
* @author fudakui
* @date 2017年3月10日
* modify history
 */
public class Catalogue {
	private Integer cid;//分类id
	private String cname;//分类名称

	public Integer getcid() {
		return cid;
	}

	public void setcid(Integer cid) {
		this.cid = cid;
	}

	public String getcname() {
		return cname;
	}

	public void setcname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Catalogue [cid=" + cid + ", cname=" + cname + "]";
	}
	
}

