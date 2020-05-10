package com.seckill.seckillserviceseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.seckill.seckillserviceseckill.dao")
public class SeckillServiceSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceSeckillApplication.class, args);
    }

}
