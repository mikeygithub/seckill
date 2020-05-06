package com.seckill.seckillservicesystem.service;

import com.seckill.seckillservicesystem.entity.SysUserEntity;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/6/20 10:06 AM
 * @Version 1.0
 * @Title: SysUserService
 * @Description:
 **/

public interface SysUserService {

    SysUserEntity findByUsername(String username);

}
