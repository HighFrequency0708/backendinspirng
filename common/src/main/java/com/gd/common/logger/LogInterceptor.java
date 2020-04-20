package com.gd.common.logger;

import com.gd.common.consts.ResultPacketCode;
import com.gd.common.exception.AdminPermissionDeniedException;
import com.gd.common.exception.PermissionDeniedException;
import com.gd.common.pojo.APIResult;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
@Aspect
@Order(value = 2)
public class LogInterceptor {

	@Pointcut("execution(* com.gd.*.rest.*.*(..))")
	public void log() {
	}

	@Around("log()")
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		// 查看权限是否验证通过
		if (request.getAttribute("permission") != null) {
			APIResult<String> apiResult = (APIResult<String>) request.getAttribute("permission");
            // 在这里抛出，下面的afterThrowing才会执行
			if(apiResult.getCode().equals(ResultPacketCode.APIResultCode.FrequentFail.getCode())) {
				//放开请求频繁限制
//                throw new TooFrequentException(apiResult.getMessage());
            } else if (apiResult.getCode().equals(ResultPacketCode.APIResultCode.AuthFail.getCode())) {
                throw new AdminPermissionDeniedException(apiResult.getMessage());
            } else {
				throw new PermissionDeniedException(apiResult.getMessage());
			}
		}
		return joinPoint.proceed();
	}

	@AfterThrowing(value = "log()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {

//		String filePath = this.getClass().getResource("/").getPath();
		//找到log4j.properties配置文件所在的目录(已经创建好)
//		filePath = filePath.substring(1).replace("bin", "src");
		//获得日志类logger的实例
//		Logger logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
		//logger所需的配置文件路径
//		PropertyConfigurator.configure(filePath + "log4j.properties");
//		logger.error(StringUtils.EMPTY, e);
	}
}