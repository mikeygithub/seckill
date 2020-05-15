package com.seckill.seckillzuulgateway.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.seckill.seckillzuulgateway.util.R;
import com.seckill.seckillzuulgateway.util.TokenUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/10/20 7:02 AM
 * @Version 1.0
 * @Title: AccessFilter
 * @Description: 访问权限控制
 * 削峰，流控
 **/
@Component
public class AccessFilter extends ZuulFilter {


    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private TokenUtils tokenUtils;

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";//前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;// 过滤器的执行顺序，数字越大优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    /**
     * 路由拦截
     * @return
     */
    @Override
    public Object run() {

        logger.info("路由拦截-验证Token");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        // 详细认证逻辑...
        String token = request.getHeader("token");

        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }
        //解析toke
        if(!StringUtils.isBlank(token)){//校验
            //
            try {
                Claims claims = tokenUtils.parseToken(token);
                // 添加额外的请求参数start
                String userId = claims.getSubject();
                Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
                ArrayList<String> params = new ArrayList<>();
                //add param
                params.add(userId);
                //set
                requestQueryParams.put("userId",params);
                ctx.setRequestQueryParams(requestQueryParams);
                // 添加额外的请求参数end

            }catch (Exception e){
                ctx.setSendZuulResponse(false); // 过滤该请求，不进行路由
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody(R.error("认证失败").toString()); // 返回前端内容
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            }

        }else{//校验未通过
            ctx.setSendZuulResponse(false); // 过滤该请求，不进行路由
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setResponseBody(R.error("Token缺失").toString()); // 返回前端内容
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }
        return null;
    }
}