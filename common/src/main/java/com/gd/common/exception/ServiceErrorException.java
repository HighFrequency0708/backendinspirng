package com.gd.common.exception;

import com.gd.common.consts.ResultPacketCode;
import com.gd.common.utils.exception.CustomException;


/**
 * @Description:业务异常
 */
public class ServiceErrorException extends CustomException {

    public ServiceErrorException(){
        super(ResultPacketCode.APIResultCode.ServiceErrorException.getCode(),"业务异常!");
    }

    public ServiceErrorException(String message){
        super(ResultPacketCode.APIResultCode.ServiceErrorException.getCode(),message);
    }

}
