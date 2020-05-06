package com.seckill.seckillservicesystem.dao;

import com.seckill.seckillservicesystem.entity.SysUserTokenEntity;
import org.springframework.stereotype.Component;

@Component
public interface SysUserTokenEntityMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(SysUserTokenEntity record);

    int insertSelective(SysUserTokenEntity record);

    SysUserTokenEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserTokenEntity record);

    int updateByPrimaryKey(SysUserTokenEntity record);

    SysUserTokenEntity selectByToken(String token);
}