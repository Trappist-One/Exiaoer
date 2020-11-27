package com.xiaoer.sso.filter;

import com.xiaoer.common.constant.SsoConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: 单点退出Filter
 * @Author: mcr
 * @Date: 2020/11/27 16:58
 */
public class LogoutFilter extends SSOFilter{
    @Override
    public boolean isAccessAllowed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accessToken = getLogoutParam(request);
        if (accessToken != null) {
            destroySession(accessToken);
            return false;
        }
        return true;
    }

    protected String getLogoutParam(HttpServletRequest request) {
        return request.getHeader(SsoConstant.LOGOUT_PARAMETER_NAME);
    }

    private void destroySession(String accessToken) {
        final HttpSession session = getSessionMappingStorage().removeSessionByMappingId(accessToken);
        if (session != null) {
            session.invalidate();
        }
    }
}
