package util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.Catalogue;

public class JsonResult<T> implements Serializable{
	private int code;
	private T data;
	private long ts;//服务器时间
	private String msg;//
	
	
	public final static Integer SUCCESS = 0;
	public final static Integer FAILURE = 1;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T map) {
		this.data = map;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
