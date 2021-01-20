package com.zww.ssm.dao;

import com.zww.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品信息数据库操作类
 */
public interface IProductDao {
    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 保存产品
     * @param product
     */
    @Insert("insert into product " +
            "(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "value (#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
