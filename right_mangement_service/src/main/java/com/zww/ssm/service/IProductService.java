package com.zww.ssm.service;

import com.zww.ssm.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    void save(Product product);
}
