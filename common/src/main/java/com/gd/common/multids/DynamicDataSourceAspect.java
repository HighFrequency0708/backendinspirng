package com.gd.common.multids;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切换数据源的切面
 */
@Component
@Aspect
@Order(1) //这是关键，要让该切面调用先于AbstractRoutingDataSource的determineCurrentLookupKey()
public class DynamicDataSourceAspect {

    @Before("execution(* com.gd.*.service..*.*(..))")
    public void before(JoinPoint point) {
        try {
            DataSource annotationOfClass = point.getTarget().getClass().getAnnotation(DataSource.class);
            String methodName = point.getSignature().getName();
            Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();
            Method method = point.getTarget().getClass().getMethod(methodName, parameterTypes);
            DataSource methodAnnotation = method.getAnnotation(DataSource.class);
            methodAnnotation = methodAnnotation == null ? annotationOfClass : methodAnnotation;
            ContextConst.DataSourceType dataSourceType = methodAnnotation != null
                    && methodAnnotation.value() != null ? methodAnnotation.value() : ContextConst.DataSourceType.PRIMARY;

            DataSourceContextHolder.setDataSource(dataSourceType.name());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("execution(* com.gd.*.service..*.*(..))")
    public void after(JoinPoint point) {
        DataSourceContextHolder.clearDataSource();
    }


}