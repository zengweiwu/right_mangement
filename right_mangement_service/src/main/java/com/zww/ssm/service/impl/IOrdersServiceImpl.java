package com.zww.ssm.service.impl;

import com.zww.ssm.dao.IOrdersDao;
import com.zww.ssm.domain.Orders;
import com.zww.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
