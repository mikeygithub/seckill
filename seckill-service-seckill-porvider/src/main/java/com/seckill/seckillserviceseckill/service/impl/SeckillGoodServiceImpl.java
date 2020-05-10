package com.seckill.seckillserviceseckill.service.impl;

import com.seckill.seckillserviceseckill.dao.SeckillGoodEntityMapper;
import com.seckill.seckillserviceseckill.dao.SeckillOrderEntityMapper;
import com.seckill.seckillserviceseckill.entity.SeckillGoodEntity;
import com.seckill.seckillserviceseckill.entity.SeckillOrderEntity;
import com.seckill.seckillserviceseckill.service.SeckillGoodService;
import com.seckill.seckillservicesystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/9/20 6:49 PM
 * @Version 1.0
 * @Title: SeckillGoodServiceImpl
 * @Description:
 **/
@Transactional
@Service
public class SeckillGoodServiceImpl implements SeckillGoodService {

    @Autowired
    private SeckillGoodEntityMapper seckillGoodEntityMapper;
    @Autowired
    private SeckillOrderEntityMapper seckillOrderEntityMapper;

    /**
     * 发布
     * @param seckillGoodEntity
     * @return
     */
    @Override
    public R save(SeckillGoodEntity seckillGoodEntity) {

        seckillGoodEntityMapper.insert(seckillGoodEntity);

        return R.ok();
    }

    /**
     * 抢购
     * @param userId
     * @param goodId
     * @return
     */
    @Override
    public synchronized R secKill(Long userId, Long goodId) {

        //查询存货
        SeckillGoodEntity seckillGoodEntity = seckillGoodEntityMapper.selectByPrimaryKey(goodId);

        if (seckillGoodEntity.getGoodNumber()<=0)return R.error("存货为空");

        if (new Date().before(seckillGoodEntity.getStartTime())) return R.error("未到抢购时间");

        SeckillOrderEntity seckillOrderEntity = new SeckillOrderEntity();

        seckillOrderEntity.setCreateTime(new Date());
        seckillOrderEntity.setGoodId(seckillGoodEntity.getGoodId());
        seckillOrderEntity.setUserId(userId);


        seckillOrderEntityMapper.insert(seckillOrderEntity);

        return R.ok();
    }
}
