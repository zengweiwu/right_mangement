package com.zww.ssm.service.impl;

import com.zww.ssm.dao.IProductDao;
import com.zww.ssm.domain.Product;
import com.zww.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 产品服务层
 */
@Service
@Transactional
public class IProductServiceImpl implements IProductService {
    //自动注入dao
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
