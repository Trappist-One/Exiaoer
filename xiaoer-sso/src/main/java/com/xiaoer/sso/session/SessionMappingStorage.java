package com.xiaoer.sso.session;

import javax.servlet.http.HttpSession;

/**
 * @Author: mcr
 * @Description: 借鉴CAS
 * @Date: 2020/11/27 12:01
 */
public interface SessionMappingStorage {
    HttpSession removeSessionByMappingId(String accessToken);

    void removeBySessionById(String sessionId);

    void addSessionById(String accessToken, HttpSession session);
}
