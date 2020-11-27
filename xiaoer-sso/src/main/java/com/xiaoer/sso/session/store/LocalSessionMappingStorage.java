package com.xiaoer.sso.session.store;

import com.xiaoer.sso.session.SessionMappingStorage;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mcr
 * @Description: 借鉴CAS
 * @Date: 2020/11/27 12:07
 */
public class LocalSessionMappingStorage implements SessionMappingStorage {

    private final Map<String, HttpSession> tokenSessionMap = new HashMap<>();
    private final Map<String, String> sessionTokenMap = new HashMap<>();

    @Override
    public HttpSession removeSessionByMappingId(String accessToken) {
        final HttpSession httpSession = tokenSessionMap.get(accessToken);
        if (httpSession != null) {
            removeBySessionById(httpSession.getId());
        }
        return httpSession;
    }

    @Override
    public void removeBySessionById(String sessionId) {
        final String accessToken = sessionTokenMap.get(sessionId);
        tokenSessionMap.remove(accessToken);
        sessionTokenMap.remove(sessionId);
    }

    @Override
    public void addSessionById(String accessToken, HttpSession session) {
        sessionTokenMap.put(session.getId(), accessToken);
        tokenSessionMap.put(accessToken, session);
    }
}
