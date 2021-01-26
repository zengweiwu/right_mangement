package com.zww.ssm.service.impl;

import com.zww.ssm.dao.IOrder_travelDao;
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
    @Autowired
    private IOrder_travelDao order_travelDao;
    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public void deleteOrder(String oId) throws Exception {
        ordersDao.deleteOredrById(oId);
        order_travelDao.deleteByOrderId(oId);
    }

    @Override
    public Orders findById(String id) throws Exception{
        return ordersDao.findById(id);
    }
}
