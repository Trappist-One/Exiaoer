package com.xiaoer.sso.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: APP单点登出Filter
 * @Author: mcr
 * @Date: 2020/11/27 17:05
 */
public class AppLogoutFilter extends LogoutFilter{
    @Override
    public boolean isAccessAllowed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (getLogoutParam(request) != null) {
            request.getSession().invalidate();
            return false;
        }
        return true;
    }
}
