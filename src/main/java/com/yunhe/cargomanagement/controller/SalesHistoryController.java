package com.yunhe.cargomanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.service.impl.SalesHistoryServiceImpl;
import com.yunhe.cargomanagement.service.impl.SalesOrderHistoryServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售历史 前端控制器
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/sales-history")
public class SalesHistoryController {

    @Resource
    private SalesHistoryServiceImpl salesHistoryService;

    /**
     * 增加一条销售历史 _已测试成功
     * @param salesHistory
     * @return 增加的条数
     */
    @RequestMapping("/addSalesHistory")
    public int addSalesHistory(SalesHistory salesHistory){
        return  salesHistoryService.addSalesHistory(salesHistory);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion){
        System.out.println(id);
        SalesHistory salesHistory = salesHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales",salesHistory);
        return new ModelAndView("/cargomanagement/ceshi2");
    }
    /**
     * 根据id修改销售历史 _已测试成功
     * @param salesHistory
     * @return
     */
    @RequestMapping("/updateSalesHistory")
    public int updateSalesHistory(SalesHistory salesHistory){
        int i = salesHistoryService.updateSalesHistory(salesHistory);
        return i;
    }


    @RequestMapping("/deleteSalesHistory")
    public int deleteSalesHistory(int id){
        return salesHistoryService.deleteSalesHistory(id);
    }

    @RequestMapping("/tiao")
    public ModelAndView tiaozhuan(){
        return new ModelAndView("/cargomanagement/salesHistory");
    }
    /**
     * 分页查询所有的销售历史
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param salesHistory 条件
     * @return map
     */
    @RequestMapping("/quertLikeListSalesHistory")
    public Map quertLikeListSalesHistory(int pageNum, int pageSize, SalesHistory salesHistory, Model m){
        System.out.println(pageNum);
        System.out.println(pageSize);
        Map map = salesHistoryService.queryLikeSalesHistory(pageNum, pageSize, salesHistory);
        List<SalesHistory> list = (List<SalesHistory>) map.get("list");
        m.addAttribute("list",list);
        return map;
    }
}
