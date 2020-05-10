package com.seckill.seckillserviceseckill.controller;

import com.seckill.seckillserviceseckill.dao.SeckillGoodEntityMapper;
import com.seckill.seckillserviceseckill.entity.SeckillGoodEntity;
import com.seckill.seckillserviceseckill.service.SeckillGoodService;
import com.seckill.seckillservicesystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/9/20 4:37 PM
 * @Version 1.0
 * @Title: SecKillGoodController
 * @Description:
 **/
@RestController
public class SecKillGoodController {

    @Autowired
    private SeckillGoodService seckillGoodService;

    @PostMapping("/seckill/publish")
    public Map<String, Object> publish(@RequestBody SeckillGoodEntity seckillGoodEntity){

        //用户信息
        R r = seckillGoodService.save(seckillGoodEntity);

        return r;
    }

    @PostMapping("/seckill/seckill")
    public Map<String, Object> secKill(@RequestParam Map<String,Object> param){

        Long userId = (Long) param.get("userId");
        Long goodId = (Long) param.get("goodId");
        //用户信息
        R r = seckillGoodService.secKill(userId,goodId);

        return r;
    }
}
