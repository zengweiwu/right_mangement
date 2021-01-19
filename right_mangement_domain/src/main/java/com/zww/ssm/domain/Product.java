package com.zww.ssm.domain;

import java.util.Date;

/**
 * 产品信息类
 */
public class Product {
    private String id;  //产品id
    private String productNum;  //产品编号
    private String productName;  //产品名称
    private  String cityName;  //出发城市
    private Date DepartureTime;  //出发时间
    private String DepartureTimeStr;
    private Double productPrice;  //产品价格
    private  String productDesc;  //产品描述
    private  Integer productStatus;  //状态 0 关闭 1 开启
    private  String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        return DepartureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        DepartureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
