package com.seckill.seckillservicesystem.dao;

import com.seckill.seckillservicesystem.entity.SysUserEntity;
import org.springframework.stereotype.Component;

@Component
public interface SysUserEntityMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);

    SysUserEntity selectByUsername(String username);
}