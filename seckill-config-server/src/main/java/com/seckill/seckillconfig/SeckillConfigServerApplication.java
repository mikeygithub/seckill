package com.seckill.seckillconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SeckillConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillConfigServerApplication.class, args);
    }

}
