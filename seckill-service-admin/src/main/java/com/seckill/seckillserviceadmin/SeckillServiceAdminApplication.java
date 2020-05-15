package com.seckill.seckillserviceadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeckillServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceAdminApplication.class, args);
    }

}
