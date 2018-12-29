package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersService {
    //遍历订单
    List<Orders> findAll() throws Exception;

    Orders findById(String id) throws Exception;
   List<Orders> findAllByPage(Integer pageNum,Integer pageSize) throws Exception;

    void deleteById(String id);
}
