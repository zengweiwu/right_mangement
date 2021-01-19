package com.zww.ssm.dao;

import com.zww.ssm.domain.Product;
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
}
