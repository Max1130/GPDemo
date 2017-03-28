package entity;

/**
 * (这里用一句话描述这个类的作用)  三级目录表实体类
 * @author fudakui
 * @date 2017年3月14日
 * modify history
 */
public class CatalogueThree {
	private String tid;//three_id
	private String ceid;//c_e_id
	private String tname;//three_name
	private String purl;//picture_url图片地址
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCeid() {
		return ceid;
	}
	public void setCeid(String ceid) {
		this.ceid = ceid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	@Override
	public String toString() {
		return "CatalogueThree [tid=" + tid + ", ceid=" + ceid + ", tname=" + tname + ", purl=" + purl + "]";
	}
	
	
}
