package com.gd.common.logger.entity;

import java.io.Serializable;

/**
 * 日志基础信息
 */
public class LogAbstract implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 操作IP地址
     */
    private String remoteIp;


    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String oprateType;

    /**
     * 方法类
     */
    private String methodClass;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法
     */
    private String method;

    /**
     * 执行时间
     */
    private String time;

    /**
     * 创建时间
     */
    protected String createTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getOprateType() {
        return oprateType;
    }

    public void setOprateType(String oprateType) {
        this.oprateType = oprateType;
    }

    public String getMethodClass() {
        return methodClass;
    }

    public void setMethodClass(String methodClass) {
        this.methodClass = methodClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LogAbstract{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", oprateType='" + oprateType + '\'' +
                ", methodClass='" + methodClass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", method='" + method + '\'' +
                ", time='" + time + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
