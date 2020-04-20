package com.gd.common.pojo;

/**
 * api安全用
 * Created by yulxp on 2018/1/17.
 */
public class Security {

    public Security() {
    }

    public Security(String token, String secret) {
        this.token = token;
        this.secret = secret;
    }

    private String token;

    private String secret;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
