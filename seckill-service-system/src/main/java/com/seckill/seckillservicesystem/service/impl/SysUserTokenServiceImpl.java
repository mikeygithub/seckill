package com.seckill.seckillservicesystem.service.impl;

import com.seckill.seckillservicesystem.dao.SysUserTokenEntityMapper;
import com.seckill.seckillservicesystem.oauth2.TokenUtils;
import com.seckill.seckillservicesystem.service.SysUserTokenService;
import com.seckill.seckillservicesystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl  implements SysUserTokenService {

	@Autowired
	private TokenUtils TokenUtils;

	/**
	 * 登入创建token
	 * @param userId  用户ID
	 * @return
	 */
	@Override
	public R createToken(long userId) {
		//生成一个token
		String token = TokenUtils.generateToken(userId);

		R r = R.ok().put("token", token).put("expire", new Date().getTime() + TokenUtils.getExpire() * 1000);

		return r;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
//		String token = TokenUtils.generateValue();
//
//		//修改token
//		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
//		tokenEntity.setUserId(userId);
//		tokenEntity.setToken(token);
//		sysUserTokenEntityMapper.updateByPrimaryKey(tokenEntity);
	}
}
