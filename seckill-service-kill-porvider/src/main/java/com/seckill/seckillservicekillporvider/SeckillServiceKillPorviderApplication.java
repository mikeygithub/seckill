package com.seckill.seckillservicekillporvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeckillServiceKillPorviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceKillPorviderApplication.class, args);
    }

}
