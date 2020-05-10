package com.seckill.seckillserviceseckill.service;

import com.seckill.seckillserviceseckill.entity.SeckillGoodEntity;
import com.seckill.seckillservicesystem.utils.R;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/9/20 4:40 PM
 * @Version 1.0
 * @Title: SeckillGoodService
 * @Description:
 **/

public interface SeckillGoodService {

    /**
     * 保存
     * @param seckillGoodEntity
     * @return
     */
    R save(SeckillGoodEntity seckillGoodEntity);

    /**
     * 秒杀
     * @param userId
     * @param goodId
     * @return
     */
    R secKill(Long userId,Long goodId);

}
