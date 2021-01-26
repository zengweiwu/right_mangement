package com.zww.ssm.domain;

import com.zww.ssm.utils.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;  //人数
    private String orderDesc;
    private Integer payType;  //支付类型 0 微信支付 1 支付宝支付 2 其他
    private String payTypeStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Product product;
    private Member member;
    private List<Traveller> travellers;


    public String getPayTypeStr() {
        if (payType == 0){
            payTypeStr = "微信支付";
        }
        if (payType == 1){
            payTypeStr = "支付宝支付";
        }
        if (payType == 0){
            payTypeStr = "其他支付";
        }
        return payTypeStr;
    }

    public String getOrderTimeStr() {
        if (orderTime != null){
            orderTimeStr = DateUtil.date2Str(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }


    public String getOrderStatusStr() {
        if (orderStatus == 0){
            orderStatusStr = "关闭";
        }
        if (orderStatus == 1){
            orderStatusStr = "开启";
        }
        return orderStatusStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

