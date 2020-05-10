package com.seckill.seckillserviceseckill.service;

import com.seckill.seckillservicesystem.entity.SysUserEntity;

import java.util.Set;

public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);


    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}

