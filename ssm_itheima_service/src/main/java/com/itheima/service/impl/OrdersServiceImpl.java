package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrdersMapper;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> findAll() throws Exception {
          return ordersMapper.findAll();
    }

    public Orders findById(String id) throws Exception {
        return ordersMapper.findById(id);
    }

    public List<Orders> findAllByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return ordersMapper.findAllByPage();
    }

    public void deleteById(String id) {
        ordersMapper.deleteById(id);
    }
}
