package com.yunhe.cargomanagement.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.cargomanagement.service.impl.SalesOrderHistoryServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 销售订单历史 前端控制器
 * </p>
 *
 * @author lyq
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/sales-order-history")
public class SalesOrderHistoryController {

    @Resource
    private SalesOrderHistoryServiceImpl salesOrderHistoryService;

    /**
     *主页面的页面跳转
     * @return web页面
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("ceshi3");
    }

    /**
     * 新增页面的跳转
     * @return web页面
     */
    @RequestMapping("/ceshi1")
    public ModelAndView ceshi1(){
        return new ModelAndView("ceshi1");
    }

    /**
     * 修改销售订单信息
     * @param id 销售订单的id
     * @return int 是否成功
     */
    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion){
        System.out.println(id+"id");
        SalesOrderHistory salesOrderHistory = salesOrderHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales",salesOrderHistory);
        return new ModelAndView("ceshi2");
    }

    /**
     * 根据id删除销售订单信息
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(){
        return new ModelAndView("edit");
    }
    /**
     * 分页查询销售订单历史
     * @param pageNum
     * @param pageSize
     * @param salesOrderHistory
     * @return
     */
    @RequestMapping("/quertLikeList")
    public Map quertLikeList(int pageNum, int pageSize, SalesOrderHistory salesOrderHistory){
        Map map=new HashMap();
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);
        map.put("salesOrderHistory", salesOrderHistory);
        System.out.println(salesOrderHistory.getSoClient());
        Page page=salesOrderHistoryService.queryLikeList(map);
        map.put("page", page.getRecords());
        map.put("totalPage",page.getPages());
        return map;
    }
}
