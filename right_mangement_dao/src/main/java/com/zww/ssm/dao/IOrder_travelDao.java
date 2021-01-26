package com.zww.ssm.dao;

import org.apache.ibatis.annotations.Delete;

/**
 * 订单游客表dao
 */
public interface IOrder_travelDao {
    /**
     * 根据orderid删除
     * @param orderId
     * @throws Exception
     */
    @Delete("delete from order_traveller where orderId = #{orderId}")
    void deleteByOrderId(String orderId) throws Exception;

}
