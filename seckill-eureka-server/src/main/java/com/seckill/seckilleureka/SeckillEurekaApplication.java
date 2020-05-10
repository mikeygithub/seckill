package com.seckill.seckilleureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SeckillEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillEurekaApplication.class, args);
    }

}
