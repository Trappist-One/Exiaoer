package com.xiaoer.sso.utils;

import com.xiaoer.common.constant.SsoConstant;
import com.xiaoer.sso.pojo.RpcAccessToken;
import com.xiaoer.sso.pojo.SessionAccessToken;
import com.xiaoer.sso.pojo.SsoUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Description: Session工具
 * @Author: mcr
 * @Date: 2020/11/27 15:12
 */
public class SessionUtils {

    public static SessionAccessToken getAccessToken(HttpServletRequest request) {
        return (SessionAccessToken) request.getSession().getAttribute(SsoConstant.SESSION_ACCESS_TOKEN);
    }

    public static SsoUser getUser(HttpServletRequest request) {
        return Optional.ofNullable(getAccessToken(request)).map(u -> u.getUser()).orElse(null);
    }

    public static Integer getUserId(HttpServletRequest request) {
        return Optional.ofNullable(getUser(request)).map(u -> u.getId()).orElse(null);
    }

    public static void setAccessToken(HttpServletRequest request, RpcAccessToken rpcAccessToken) {
        SessionAccessToken sessionAccessToken = null;
        if (rpcAccessToken != null) {
            sessionAccessToken = createSessionAccessToken(rpcAccessToken);
        }
        request.getSession().setAttribute(SsoConstant.SESSION_ACCESS_TOKEN, sessionAccessToken);
    }

    private static SessionAccessToken createSessionAccessToken(RpcAccessToken accessToken) {
        long expirationTime = System.currentTimeMillis() + accessToken.getExpiresIn() * 1000;
        return new SessionAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn(),
                accessToken.getRefreshToken(), accessToken.getUser(), expirationTime);
    }

    public static void invalidate(HttpServletRequest request) {
        setAccessToken(request, null);
        request.getSession().invalidate();
    }
}
