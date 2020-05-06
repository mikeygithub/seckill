package com.seckill.seckillservicesystem.controller;

import com.seckill.seckillservicesystem.entity.SysUserEntity;
import com.seckill.seckillservicesystem.form.SysLoginForm;
import com.seckill.seckillservicesystem.service.SysUserService;
import com.seckill.seckillservicesystem.service.SysUserTokenService;
import com.seckill.seckillservicesystem.utils.R;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/6/20 9:41 AM
 * @Version 1.0
 * @Title: UserLoginController
 * @Description:
 **/
@RestController
public class UserLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {

        //用户信息
        SysUserEntity user = sysUserService.findByUsername(form.getUsername());

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getUserId());

        return r;
    }


}
