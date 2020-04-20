package com.gd.common.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author 作者 yuansf
 * @version 创建时间：2016年11月8日 上午9:32:27 
 * controller权限注解
 */	
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestAuth {
	// 是否是public，默认不是
	boolean isPublic() default false;
}
