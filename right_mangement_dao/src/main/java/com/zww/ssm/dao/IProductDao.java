package com.zww.ssm.dao;

import com.zww.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 产品信息数据库操作类
 */
public interface IProductDao {
    /**
     * 查询所有产品
     * @return
     * @throws Exception
     * @param fuzzyName
     */
    @Select({"<script>"+
            "select * from product <where> "+
            "<if test='fuzzyName != null and fuzzyName !=\"\" ' > and productName like concat(concat('%', #{fuzzyName}),'%')</if> " +
            "</where></script>"})
    List<Product> findAll(@Param("fuzzyName") String fuzzyName) throws Exception;

    /**
     * 保存产品
     * @param product
     */
    @Insert("insert into product " +
            "(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "value (#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 根据id查找产品
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    Product findProductById(String id) throws Exception;

    /**
     * 根据id删除产品
     * @param id
     */
    @Delete("delete from product where id = #{id}")
    void deleteById(String id)throws Exception;

    /**
     * 更新产品
     * @param id
     * @return
     */
    @Update("update product set productNum = #{productNum},productName = #{productName},cityName = #{cityName},DepartureTime = #{DepartureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} where id = #{id}")
    Boolean updateProduct(Product product)throws Exception;

    /**
     * 批量删除 sql在ProductSqlProvider拼接完成
     * @param ids
     * @throws Exception
     */
   @DeleteProvider(type = ProductSqlProvider.class,method = "deleteByIds")
    void deleteByIds(@Param("ids")Integer[] ids)throws Exception;
}
