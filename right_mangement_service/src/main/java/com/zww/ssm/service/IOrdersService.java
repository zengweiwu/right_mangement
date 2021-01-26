package com.zww.ssm.service;

import com.zww.ssm.domain.Orders;

import java.util.List;

/**
 * orders服务层接口
 */
public interface IOrdersService {
    /**
     * 查询所有的订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll() throws Exception;

    /**
     * 删除订单
     * @param oId
     */
    void deleteOrder(String oId) throws Exception;

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    Orders findById(String id) throws Exception;
}
