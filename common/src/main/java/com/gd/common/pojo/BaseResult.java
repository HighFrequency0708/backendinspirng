package com.gd.common.pojo;
/** 
 * @author 作者 yuansf 
 * @version 创建时间：2017年9月3日 下午3:35:30 
 * 类说明 
 */
public class BaseResult {
	
	protected Integer code;
	
	protected String message;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
 