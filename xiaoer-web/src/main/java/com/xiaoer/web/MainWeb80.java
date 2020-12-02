package com.xiaoer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: Http请求 工具类
 * @Author: mcr
 * @Date: 2020/11/27 15:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainWeb80 {
    private static final Logger log = LoggerFactory.getLogger(MainWeb80.class);

    public static void main(String[] args) {
        SpringApplication.run(MainWeb80.class, args);

        log.info("*** MainWeb80 启动成功 ***");
    }
}
