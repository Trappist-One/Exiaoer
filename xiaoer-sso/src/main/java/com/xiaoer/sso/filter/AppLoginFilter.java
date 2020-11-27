package com.xiaoer.sso.filter;

import com.xiaoer.common.constant.SsoConstant;
import com.xiaoer.sso.pojo.SessionAccessToken;
import com.xiaoer.sso.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: APP单点登录Filter
 * @Author: mcr
 * @Date: 2020/11/27 17:03
 */
public class AppLoginFilter extends LoginFilter {
    @Override
    public boolean isAccessAllowed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SessionAccessToken sessionAccessToken = SessionUtils.getAccessToken(request);
        // 本地Session中已存在，且accessToken没过期或者refreshToken成功，直接返回
        if (sessionAccessToken != null && (!sessionAccessToken.isExpired()
                || refreshToken(sessionAccessToken.getRefreshToken(), request))) {
            return true;
        }
        responseJson(response, SsoConstant.NO_LOGIN, "未登录或已超时");
        return false;
    }
}
