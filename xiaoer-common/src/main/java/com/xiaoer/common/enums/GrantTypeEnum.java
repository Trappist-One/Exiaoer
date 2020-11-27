package com.xiaoer.common.enums;

/**
 * @Description: Oauth2授权方式
 * @Author: mcr
 * @Date: 2020/11/27 11:43
 */
public enum GrantTypeEnum {
    /**
     * 授权码模式
     */
    AUTHORIZATION_CODE("authorization_code"),

    /**
     * 密码模式
     */
    PASSWORD("password");

    private String value;

    private GrantTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
