package com.zww.ssm.dao;

import com.zww.ssm.domain.Member;
import com.zww.ssm.domain.Orders;
import com.zww.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * orders表数据库操作层
 */
public interface IOrdersDao {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.zww.ssm.dao.IProductDao.findProductById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据id删除订单
     * @param oId
     */
    @Delete("delete from orders where id = #{id}")
    void deleteOredrById(String id);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.zww.ssm.dao.IProductDao.findProductById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.zww.ssm.dao.IMemberDao.findMemberById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zww.ssm.dao.TravellerDao.findTravellersById"))
    })
    Orders findById(String id);
}
