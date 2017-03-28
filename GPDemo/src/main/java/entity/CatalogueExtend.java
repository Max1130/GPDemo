package entity;
/**
 * 二级目录表实体类
* (这里用一句话描述这个类的作用)
* @author fudakui
* @date 2017年3月10日
* modify history
 */
public class CatalogueExtend {
	private String ceid;//二级分类表ID
	private String cid;//上级表ID
	private String cename;//二级分类名称
	public String getCeid() {
		return ceid;
	}
	public void setCeid(String ceid) {
		this.ceid = ceid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCename() {
		return cename;
	}
	public void setCename(String cename) {
		this.cename = cename;
	}
	@Override
	public String toString() {
		return "CatalogueExtend [ceid=" + ceid + ", cid=" + cid + ", cename=" + cename + "]";
	}
	
	
}
