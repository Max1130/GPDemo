package util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.Catalogue;

public class JsonResult<T> implements Serializable{
	private int code;
	private Map<String, List<Catalogue>> data;
	private long time;//服务器时间
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Map<String, List<Catalogue>> getData() {
		return data;
	}
	public void setData(Map<String, List<Catalogue>> map) {
		this.data = map;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", data=" + data + ", time=" + time + "]";
	}
	
}
