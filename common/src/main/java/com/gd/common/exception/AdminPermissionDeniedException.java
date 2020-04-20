package com.gd.common.exception;


import com.gd.common.consts.ResultPacketCode;

/**
 * @author 作者 yuansf
 * @version 创建时间：2016年7月24日 上午8:38:36 
 * 权限Exception 
 */
public class AdminPermissionDeniedException extends CustomException {

	public AdminPermissionDeniedException() {
	}

	public AdminPermissionDeniedException(String message) {
		super(ResultPacketCode.APIResultCode.AuthFail.getCode(), message);
	}
}
