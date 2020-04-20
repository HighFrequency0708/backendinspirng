package com.gd.common.logger.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {

    /**
     * 日志内容
     *
     * @return {String}
     */
    String value() default "日志记录";

    String type() default "操作";

}
