package com.seckill.seckillservicesystem.controller;

import com.seckill.seckillservicesystem.entity.SysUserEntity;
import com.seckill.seckillservicesystem.form.SysLoginForm;
import com.seckill.seckillservicesystem.oauth2.TokenUtils;
import com.seckill.seckillservicesystem.service.SysUserService;
import com.seckill.seckillservicesystem.utils.R;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    private TokenUtils tokenUtils;

    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form){
        //用户信息
        SysUserEntity user = sysUserService.findByUsername(form.getUsername());

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }
        return R.ok().put("token", tokenUtils.generateToken(user.getUserId()));
    }

    @PostMapping("/sys/register")
    public Map<String, Object> register(@RequestBody SysLoginForm form){
        //用户信息
        R r = sysUserService.save(form);
        return r;
    }


}
