package com.xiaoer.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: mcr
 * @Date: 2020/12/2 17:11
 */
@SpringBootApplication
@Slf4j
public class MainOAuth1001 {
    public static void main(String[] args) {
        SpringApplication.run(MainOAuth1001.class, args);
        log.info("*** MainOAuth1001 启动成功 ***");
    }
}
