package com.xiaoer.sso.listener;

import com.xiaoer.sso.session.SessionMappingStorage;
import com.xiaoer.sso.session.store.LocalSessionMappingStorage;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description: 单点登出Listener
 *               注：用于本地session过期，删除accessToken和session的映射关系
 * @Author: mcr
 * @Date: 2020/11/27 14:37
 */
@Slf4j
public class LogoutListener implements HttpSessionListener {
    private static SessionMappingStorage sessionMappingStorage = new LocalSessionMappingStorage();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("sessionCreated...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        sessionMappingStorage.removeBySessionById(session.getId());
        log.info("sessionDestroyed..." + session.getId());
    }

    public void setSessionMappingStorage(SessionMappingStorage sms){
        sessionMappingStorage = sms;
    }

    public static SessionMappingStorage getSessionMappingStorage() {
        return sessionMappingStorage;
    }

}
