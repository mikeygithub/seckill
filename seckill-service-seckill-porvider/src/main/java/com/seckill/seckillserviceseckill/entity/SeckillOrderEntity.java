package com.seckill.seckillserviceseckill.entity;

import java.util.Date;

public class SeckillOrderEntity {
    private Long orderId;

    private Long goodId;

    private Long userId;

    private Integer status;

    private Date createTime;

    public SeckillOrderEntity(Long orderId, Long goodId, Long userId, Integer status, Date createTime) {
        this.orderId = orderId;
        this.goodId = goodId;
        this.userId = userId;
        this.status = status;
        this.createTime = createTime;
    }

    public SeckillOrderEntity() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}