package com.gd.common.utils.exception;


import com.gd.common.consts.ResultPacketCode;

/**
 * @author 作者 yuansf
 * @version 创建时间：2016年7月24日 上午8:38:36 
 * 权限Exception 
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -2951242561051566828L;

	private Integer code;

    public CustomException(){
        super();
    }

    public CustomException(String message){
    	super(message);
    	this.code = ResultPacketCode.APIResultCode.Fail.getCode();
    }

    public CustomException(Integer code, String message){
    	super(message);
    	this.code = code;
    }

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
