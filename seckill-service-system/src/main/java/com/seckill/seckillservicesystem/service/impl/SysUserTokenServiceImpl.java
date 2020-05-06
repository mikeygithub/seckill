package com.seckill.seckillservicesystem.service.impl;

import com.seckill.seckillservicesystem.dao.SysUserTokenEntityMapper;
import com.seckill.seckillservicesystem.entity.SysUserTokenEntity;
import com.seckill.seckillservicesystem.oauth2.TokenGenerator;
import com.seckill.seckillservicesystem.service.SysUserTokenService;
import com.seckill.seckillservicesystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl  implements SysUserTokenService {
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;

	@Autowired
	private SysUserTokenEntityMapper sysUserTokenEntityMapper;

	@Override
	public R createToken(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserTokenEntity tokenEntity = sysUserTokenEntityMapper.selectByPrimaryKey(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			sysUserTokenEntityMapper.insert(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			sysUserTokenEntityMapper.updateByPrimaryKey(tokenEntity);
		}

		R r = R.ok().put("token", token).put("expire", EXPIRE);

		return r;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//修改token
		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		sysUserTokenEntityMapper.updateByPrimaryKey(tokenEntity);
	}
}
