package com.xiaoer.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MainGateway9001 {

    public static void main(String[] args) {
            SpringApplication.run(MainGateway9001.class, args);
            log.info("*** MainGateway9001 启动成功 ***");
        }
}
