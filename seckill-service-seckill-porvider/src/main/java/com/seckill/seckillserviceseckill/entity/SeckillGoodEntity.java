package com.seckill.seckillserviceseckill.entity;

import java.util.Date;

public class SeckillGoodEntity {
    private Long goodId;

    private Integer goodNumber;

    private Double goodPrice;

    private Integer status;

    private Date startTime;

    public SeckillGoodEntity(Long goodId, Integer goodNumber, Double goodPrice, Integer status, Date startTime) {
        this.goodId = goodId;
        this.goodNumber = goodNumber;
        this.goodPrice = goodPrice;
        this.status = status;
        this.startTime = startTime;
    }

    public SeckillGoodEntity() {
        super();
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}