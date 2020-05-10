package com.seckill.seckillservicesystem.service.impl;

import com.seckill.seckillservicesystem.dao.SysUserEntityMapper;
import com.seckill.seckillservicesystem.entity.SysUserEntity;
import com.seckill.seckillservicesystem.form.SysLoginForm;
import com.seckill.seckillservicesystem.service.SysUserService;
import com.seckill.seckillservicesystem.utils.R;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /**
     * 用户注册
     * @param form
     * @return
     */
    @Override
    public R save(SysLoginForm form) {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername(form.getUsername());

        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);

        sysUserEntity.setPassword(new Sha256Hash(form.getPassword(), salt).toHex());
        sysUserEntity.setCreateTime(new Date());
        sysUserEntity.setSalt(salt);
        //
        sysUserEntityMapper.insert(sysUserEntity);
        //
        return R.ok();
    }
}
