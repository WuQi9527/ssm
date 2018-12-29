package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
   /* @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Orders> ordersList = ordersService.findAll();

        model.addAttribute("ordersList",ordersList);
        return "orders-list";
    }*/
    @RequestMapping("/findAll")
    public String findAllByPage(@RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "5") Integer pageSize, Model model) throws Exception {
        List<Orders> ordersList = ordersService.findAllByPage(pageNum,pageSize);
        PageInfo page=new PageInfo(ordersList);



        model.addAttribute("page",page);
        return "orders-list";
    }
    //根据ID查询订单详情
    @RequestMapping("/findById")
    public String findOrdersById(String id,Model model) throws Exception {
        Orders orders=ordersService.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
    @RequestMapping("/deleteById")
    public String deleteById(String id, Model model) throws Exception{
        ordersService.deleteById(id);

        return "orders-list";

    }
}
