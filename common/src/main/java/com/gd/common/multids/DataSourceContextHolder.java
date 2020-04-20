package com.gd.common.multids;

import lombok.extern.java.Log;

/**
 * 数据源上下文持有类
 */
@Log
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String key) {
        log.info("切换到数据源: " + key);
        contextHolder.set(key);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
