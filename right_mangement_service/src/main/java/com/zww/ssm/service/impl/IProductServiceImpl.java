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
    public List<Product> findAll(String fuzzyName) throws Exception {
        return productDao.findAll(fuzzyName);
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void deleteById(String id) throws Exception {
        productDao.deleteById(id);
    }

    @Override
    public Product findById(String id) throws Exception {
        return productDao.findProductById(id);
    }

    @Override
    public Boolean updateProduct(Product product) throws Exception {
        return productDao.updateProduct(product);
    }

    @Override
    public void deleteByIdStr(String idStr) throws Exception{
        String[] idStrs = idStr.split(",");
        Integer[] ids = new Integer[idStrs.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = Integer.parseInt(idStrs[i]);
        }
        productDao.deleteByIds(ids);
    }
}
