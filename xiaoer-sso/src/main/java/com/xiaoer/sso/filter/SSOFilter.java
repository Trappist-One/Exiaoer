package com.xiaoer.sso.filter;

import com.xiaoer.sso.listener.LogoutListener;
import com.xiaoer.sso.pojo.FilterParam;
import com.xiaoer.sso.session.SessionMappingStorage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: mcr
 * @Description:
 * @Date: 2020/11/27 11:50
 */
public abstract class SSOFilter extends FilterParam implements Filter {

    public abstract boolean isAccessAllowed(HttpServletRequest request, HttpServletResponse response)
            throws IOException;

    protected SessionMappingStorage getSessionMappingStorage() {
        if (sessionMappingStorage == null) {
            sessionMappingStorage = LogoutListener.getSessionMappingStorage();
        }
        return sessionMappingStorage;
    }



    private SessionMappingStorage sessionMappingStorage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
