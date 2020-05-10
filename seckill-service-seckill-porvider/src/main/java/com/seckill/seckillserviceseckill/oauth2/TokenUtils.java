package com.seckill.seckillserviceseckill.oauth2;


import com.seckill.seckillservicesystem.exception.RRException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 生成token
 */
@Component
public class TokenUtils {

    @Value(value = "${secktll.jwt.secret}")
    private String secret;
    @Value(value = "${secktll.jwt.expire}")
    private Long expire;
    @Value(value = "${secktll.jwt.header}")
    private String header;

    /**
     * 生成token
     * @return
     */
    public String generateToken (Long userId) {

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expire * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 解析Token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        try {

            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            throw new RRException("解析token出错");
        }
    }

    /**
     * 是否过期
     * @param expiprationTime
     * @return
     */
    public boolean isTokenExpired(Date expiprationTime){
        return expiprationTime.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
