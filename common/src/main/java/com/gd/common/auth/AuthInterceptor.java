package com.gd.common.auth;

import com.gd.common.cache.ICached;
import com.gd.common.consts.ConstantUtil;
import com.gd.common.consts.ResultPacketCode;
import com.gd.common.pojo.APIResult;
import com.gd.common.utils.contextHolder.AppContextHolder;
import com.gd.common.utils.encrypt.AESUtil;
import com.gd.common.utils.encrypt.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 * 权限验证
 */
@Component
@Aspect
@Order(1)
public class AuthInterceptor {

    private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Resource
    private ICached cached;

    @Pointcut("execution(* com.gd.*.rest.*.*(..))")
    public void auth() {
    }

    @SuppressWarnings("rawtypes")
    @Before("auth()")
    public void before(JoinPoint joinPoint) throws Exception {

        // 如果标示了公有的方法则不需要验证签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RestAuth restAuth = method.getDeclaredAnnotation(RestAuth.class);
        if (!ObjectUtils.isEmpty(restAuth) && restAuth.isPublic()) {
            return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String token = request.getParameter("token");
        String sign = request.getParameter("sign");
        String timestamp = request.getParameter("timestamp");

        //验证参数的正确性
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(sign) || StringUtils.isEmpty(timestamp)) {
            request.setAttribute("permission", new APIResult(ResultPacketCode.APIResultCode.AuthFail.getCode(), "验证参数不正确"));
            return;
        }

        //验证请求是否过期（五分钟过期） 动态配置
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, - ConstantUtil.TIME_FIVE_MINUTE);
        if (Long.parseLong(timestamp) < calendar.getTimeInMillis()) {
            request.setAttribute("permission", new APIResult(ResultPacketCode.APIResultCode.AuthFail.getCode(), "非法请求"));
            return;
        }

        // 获取userId
        String userId = AESUtil.decrypt(token, AESUtil.SECRET2);
        // 存储userId
        AppContextHolder.setUserId(userId.substring(AESUtil.CLIENT_ID_PREFIX_DIGIT));

        // 验证sign的重复性
        String signCached = cached.getString("sign_" + userId + sign);
        if (StringUtils.isNotEmpty(signCached) && signCached.equals(sign)) {
            request.setAttribute("permission", new APIResult(ResultPacketCode.APIResultCode.FrequentFail.getCode(), "请求过于频繁"));
            return;
        }

        // 验证签名秘钥与token是否失效，以及token的正确性
        String tokenCached = cached.getString(ConstantUtil.TOKEN_PREFIX + userId);
        String secretCached = cached.getString(ConstantUtil.SECRET_PREFIX + userId);
       if (StringUtils.isEmpty(tokenCached) || StringUtils.isEmpty(secretCached) || !tokenCached.equals(token)) {
            request.setAttribute("permission", new APIResult(ResultPacketCode.APIResultCode.AuthFail.getCode(), "登录已失效，请重新登陆"));
            return;
        }

        // 验证sign的正确性
        String signCalc = "";
        if(StringUtils.isNotEmpty(secretCached)){
            signCalc = SignUtil.findSign(request.getRequestURI(), request.getQueryString(), secretCached);
        }

        if (!sign.equalsIgnoreCase(signCalc)) {
            request.setAttribute("permission", new APIResult(ResultPacketCode.APIResultCode.AuthFail.getCode(), "签名认证失败，可以取消继续留在该页面，或者重新登录"));
            return;
        }
        // 更新token的过期时间
        cached.set(ConstantUtil.TOKEN_PREFIX + userId, token, ConstantUtil.TIME_THREE_DAYS);

        // 缓存每次的sign，确保请求不会重复提交（5分钟）
        cached.set(ConstantUtil.SIGN_PREFIX + userId + sign, sign, ConstantUtil.TIME_FIVE_MINUTE);

    }

}
