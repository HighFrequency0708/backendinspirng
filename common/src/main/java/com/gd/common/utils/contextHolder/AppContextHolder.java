package com.gd.common.utils.contextHolder;

/**
 * 认证用threadLocal、存储userId、deviceId
 */
public class AppContextHolder {

    private static final ThreadLocal<String> userIdContextHolder = new ThreadLocal<>();

    // 读取userId
    public static String getUserId() {
        return userIdContextHolder.get();
    }

    // 设置userId
    public static void setUserId(String value) {
        userIdContextHolder.set(value);
    }

    // 清除userId
    public static void removeUserId() {
        userIdContextHolder.remove();
    }

}
