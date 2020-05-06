package com.seckill.seckillservicesystem.service.impl;

import com.seckill.seckillservicesystem.dao.SysUserEntityMapper;
import com.seckill.seckillservicesystem.entity.SysUserEntity;
import com.seckill.seckillservicesystem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/6/20 10:07 AM
 * @Version 1.0
 * @Title: SysUserServiceImpl
 * @Description:
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserEntityMapper sysUserEntityMapper;

    /**
     * 账号查找
     * @param username
     * @return
     */
    @Override
    public SysUserEntity findByUsername(String username) {
        return sysUserEntityMapper.selectByUsername(username);
    }
}
