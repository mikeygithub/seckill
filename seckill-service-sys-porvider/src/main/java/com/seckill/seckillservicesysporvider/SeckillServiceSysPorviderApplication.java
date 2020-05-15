package com.seckill.seckillservicesysporvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeckillServiceSysPorviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceSysPorviderApplication.class, args);
    }

}
