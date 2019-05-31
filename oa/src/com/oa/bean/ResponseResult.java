package com.oa.bean;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult {
	// 状态码 0表示失败，1表示成功
	private Integer stateCode;
	// 提示信息
	private String message;
	// 返回要给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseResult(Integer stateCode, String message, Map<String, Object> extend) {
		super();
		this.stateCode = stateCode;
		this.message = message;
		this.extend = extend;
	}

	public ResponseResult(Integer stateCode, String message) {
		super();
		this.stateCode = stateCode;
		this.message = message;
	}

	// 请求成功
	public static ResponseResult success(String msg) {
		ResponseResult rr = new ResponseResult();
		rr.setMessage(msg);
		rr.setStateCode(1);
		return rr;
	}

	public static ResponseResult success() {
		ResponseResult rr = new ResponseResult();
		rr.setStateCode(1);
		return rr;
	}

	// 请求失败
	public static ResponseResult fail(String msg) {
		ResponseResult rr = new ResponseResult();
		rr.setMessage(msg);
		rr.setStateCode(0);
		return rr;
	}

	// 以键值对的形式加入对象
	public ResponseResult add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

}
