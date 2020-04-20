package com.gd.common.utils.exception;

import com.gd.common.consts.ConstantUtil;
import com.gd.common.consts.ResultPacketCode;
import com.gd.common.pojo.APIResult;
import com.gd.common.utils.date.DateUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * @author 作者 yuansf
 * @version 创建时间：2016年7月22日 下午7:03:35
 * 类说明
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public APIResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        APIResult<Exception> result = new APIResult<>();
        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        result.setCode(ResultPacketCode.APIResultCode.FormConfirmFail.getCode());
        result.setMessage(message);
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public APIResult operateExp(RuntimeException ex, HttpServletRequest request) {
        APIResult<Exception> result = new APIResult<Exception>();
        String exceptionName = ex.getClass().getSimpleName();
        String exceptionSuperName = ex.getClass().getSuperclass().getSimpleName();
        // 若异常的父类或者自身是自定义异常,则自定义code与报错信息
        if (ConstantUtil.GLOBAL_EXCEPTION_NAME.equals(exceptionSuperName)
                || ConstantUtil.GLOBAL_EXCEPTION_NAME.equals(exceptionName)) {
            result.setCode(((CustomException) ex).getCode());
            result.setMessage(ex.getMessage());
            return result;
        }
        result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
        result.setResult(ex);
        String now = DateUtils.formatNowDateTime();
//        result.setMessage("接口" + request.getRequestURI() + ",时间:" + now);
        result.setMessage("操作失败！");
        return result;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResult ExceptionHandler(Exception e) {
        APIResult<Exception> result = new APIResult<>();
        result.setCode(ResultPacketCode.APIResultCode.FormConfirmFail.getCode());
        result.setMessage("未知异常");
        return result;
    }
}
