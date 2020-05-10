package com.seckill.seckillserviceseckill.dao;

import com.seckill.seckillserviceseckill.entity.SeckillGoodEntity;
import org.springframework.stereotype.Component;

@Component
public interface SeckillGoodEntityMapper {
    int deleteByPrimaryKey(Long goodId);

    int insert(SeckillGoodEntity record);

    int insertSelective(SeckillGoodEntity record);

    SeckillGoodEntity selectByPrimaryKey(Long goodId);

    int updateByPrimaryKeySelective(SeckillGoodEntity record);

    int updateByPrimaryKey(SeckillGoodEntity record);
}