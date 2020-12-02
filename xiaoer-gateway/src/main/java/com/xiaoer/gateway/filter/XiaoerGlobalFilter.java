package com.xiaoer.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: mcr
 * @Date: 2020/12/2 11:46
 */
@Component
@Slf4j
public class XiaoerGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局拦截器...");
        Mono<WebSession> session = exchange.getSession();
        log.info("session:" + session.toString());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
