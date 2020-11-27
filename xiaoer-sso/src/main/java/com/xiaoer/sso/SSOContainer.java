package com.xiaoer.sso;

import com.xiaoer.common.constant.SsoConstant;
import com.xiaoer.sso.filter.SSOFilter;
import com.xiaoer.sso.pojo.FilterParam;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: mcr
 * @Date: 2020/11/27 17:37
 */
public class SSOContainer extends FilterParam implements Filter {
    /** 排除URL */
    protected String excludeUrls;

    private SSOFilter[] filters;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filters == null || filters.length == 0) {
            throw new IllegalArgumentException("filters不能为空");
        }
        for (SSOFilter filter : filters) {
            filter.setAppId(getAppId());
            filter.setAppSecret(getAppSecret());
            filter.setServerUrl(getServerUrl());
            filter.init(filterConfig);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (isExcludeUrl(httpRequest.getServletPath())) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        for (SSOFilter filter : filters) {
            if (!filter.isAccessAllowed(httpRequest, httpResponse)) {
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isExcludeUrl(String url) {
        if (excludeUrls == null || excludeUrls.isEmpty())
            return false;

        Map<Boolean, List<String>> map = Arrays.stream(excludeUrls.split(","))
                .collect(Collectors.partitioningBy(u -> u.endsWith(SsoConstant.URL_FUZZY_MATCH)));
        List<String> urlList = map.get(false);
        if (urlList.contains(url)) { // 优先精确匹配
            return true;
        }
        urlList = map.get(true);
        for (String matchUrl : urlList) { // 再进行模糊匹配
            if (url.startsWith(matchUrl.replace(SsoConstant.URL_FUZZY_MATCH, ""))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        if (filters == null || filters.length == 0)
            return;
        for (SSOFilter filter : filters) {
            filter.destroy();
        }
    }

    public void setExcludeUrls(String excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    public void setFilters(SSOFilter... filters) {
        this.filters = filters;
    }
}
