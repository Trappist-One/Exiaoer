package com.xiaoer.sso.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description: 存Session中AccessToken
 * @Author: mcr
 * @Date: 2020/11/27 15:20
 */
public class SessionAccessToken extends RpcAccessToken{
    private static final long serialVersionUID = 4507869346123296527L;

    /**
     * AccessToken过期时间
     */
    @Getter
    @Setter
    private long expirationTime;

    public boolean isExpired() {
        return expirationTime < System.currentTimeMillis();
    }

    public SessionAccessToken(String accessToken, int expiresIn, String refreshToken, SsoUser user,
                              long expirationTime) {
        super(accessToken, expiresIn, refreshToken, user);
        this.expirationTime = expirationTime;
    }
}
