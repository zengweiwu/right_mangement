package com.zww.ssm.service;

import com.zww.ssm.domain.Product;

import java.util.List;


public interface IProductService {
    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
     List<Product> findAll() throws Exception;

    /**
     * 保存产品
     */
    void save(Product product)throws Exception;

    /**
     * 根据id删除产品
     * @param id
     */
    void deleteById(String id)throws Exception;

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    Product findById(String id) throws Exception;

    /**
     * 更新产品
     * @param id
     * @return
     */
    Boolean updateProduct(Product product)throws Exception;
}
