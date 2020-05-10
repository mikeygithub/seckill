package com.seckill.seckillservicesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.seckill.seckillservicesystem.dao")
@SpringBootApplication
public class SeckillServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceSystemApplication.class, args);
    }

}
