package com.zww.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zww.ssm.domain.Orders;
import com.zww.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单前端控制器
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    //查询所有订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        //使用分页插件
        PageHelper.startPage(page, size);
        List<Orders> ordersList = ordersService.findAll();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    //根据id删除订单
    @RequestMapping("/deleteOrder.do")
    public String deleteOrder(@RequestParam(name = "id", required = true) String oId) throws Exception {
        ordersService.deleteOrder(oId);
        return "redirect:findAll.do";
    }

    //查询订单详情
    @RequestMapping("/findById.do")
    public String findById(@RequestParam(name = "id", required = true) String id, Model model) throws Exception {
        Orders orders = ordersService.findById(id);
        model.addAttribute("orders", orders);
        return "order-show";
    }
}
