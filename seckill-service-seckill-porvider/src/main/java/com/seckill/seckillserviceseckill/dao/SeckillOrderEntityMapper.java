package com.seckill.seckillserviceseckill.dao;

import com.seckill.seckillserviceseckill.entity.SeckillOrderEntity;
import org.springframework.stereotype.Component;

@Component
public interface SeckillOrderEntityMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(SeckillOrderEntity record);

    int insertSelective(SeckillOrderEntity record);

    SeckillOrderEntity selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(SeckillOrderEntity record);

    int updateByPrimaryKey(SeckillOrderEntity record);
}