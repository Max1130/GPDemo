package entity;
/**
 * 二级目录表实体类
* (这里用一句话描述这个类的作用)
* @author fudakui
* @date 2017年3月10日
* modify history
 */
public class CatalogueExtend {
	private Integer ceid;//二级分类表ID
	private Integer cid;//上级表ID
	private String cename;//二级分类名称
	public Integer getCeid() {
		return ceid;
	}
	public void setCeid(Integer ceid) {
		this.ceid = ceid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
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
