package com.seckill.seckillservicesystem.oauth2;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.seckill.seckillservicesystem.entity.SysUserEntity;
import com.seckill.seckillservicesystem.service.ShiroService;
import io.jsonwebtoken.Claims;
import org.apache.http.HttpStatus;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 14:00
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public boolean supports(AuthenticationToken token) {
//        System.out.println("supports");
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String accessToken = (String) token.getPrincipal();

        Claims claims = tokenUtils.parseToken(accessToken);

        if (ObjectUtils.isNull(claims) || tokenUtils.isTokenExpired(claims.getExpiration())) {
            throw new IncorrectCredentialsException(tokenUtils.getHeader()+"token过期");
        }

        //查询用户信息
        SysUserEntity user = shiroService.queryUser(Long.parseLong(claims.getSubject()));

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());

        return info;
    }
}
