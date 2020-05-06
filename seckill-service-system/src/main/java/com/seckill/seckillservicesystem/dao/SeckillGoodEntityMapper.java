package com.seckill.seckillservicesystem.dao;

import com.seckill.seckillservicesystem.entity.SeckillGoodEntity;
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