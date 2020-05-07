package com.seckill.seckillservicesystem.oauth2;


import com.seckill.seckillservicesystem.exception.RRException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

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

    public static void main(String[] args) throws Exception{

    TokenUtils utils = new TokenUtils();
        utils.setSecret("f4e2e52034348f86b67cde581c0f9eb5");
        utils.setExpire(100000L);
        utils.setHeader("authorization");
        String token = utils.generateToken(1L);
        System.out.println("token:"+token);
        Claims claims = utils.parseToken(token);
        System.out.println(claims.getSubject());
        System.out.println(claims);
    }
}
