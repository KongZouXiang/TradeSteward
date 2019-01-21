package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.service.impl.SalesHistoryServiceImpl;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * 从销售订单跳转到添加页面
     * @return 页面
     */
    @RequestMapping("/saleAdd")
    public ModelAndView ceshi1(){
        return new ModelAndView("cargomanagement/salesHistory-add");
    }

    @RequestMapping("/nimabo")
    @ResponseBody
    public String sumbiiiit(HttpServletResponse response, String[] soClient, String[] clNumber){
        for (int i=0;i<soClient.length;i++){
            SalesHistory salesHistory = new SalesHistory();
            salesHistory.setShClient(soClient[i]);
            System.out.println(salesHistory.getShClient());
        }
        return "haha";
    }
    /**
     * 增加一条销售历史 _已测试成功
     *
     * @param salesHistory
     * @return 增加的条数
     */
    @RequestMapping("/addSalesHistory")
    public int addSalesHistory(SalesHistory salesHistory) {
        return salesHistoryService.addSalesHistory(salesHistory);
    }
    /**
     * 修改页面跳转--根据id获取当前订单的所有信息
     * @param id 销售订单的id
     * @return int 是否成功
     */
    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion) {
        System.out.println(id);
        SalesHistory salesHistory = salesHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales", salesHistory);
        return new ModelAndView("/cargomanagement/salesHistory-detail");
    }


    /**
     * 批量删除
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/deleteAll")
    public boolean deleteAll(HttpServletRequest request, @RequestBody List<Integer> ids)  {
        for (Integer id : ids) {
            salesHistoryService.deleteSalesHistory(id);
        }
        return true;
    }
    /**
     * 根据id修改销售历史 _已测试成功
     *
     * @param salesHistory
     * @return
     */
    @RequestMapping("/updateSalesHistory")
    public int updateSalesHistory(SalesHistory salesHistory) {
        int i = salesHistoryService.updateSalesHistory(salesHistory);
        return i;
    }


    @RequestMapping("/deleteSalesHistory")
    public int deleteSalesHistory(int id) {
        return salesHistoryService.deleteSalesHistory(id);
    }


    @RequestMapping("/tiao")
    public ModelAndView tiaozhuan() {
        return new ModelAndView("/cargomanagement/salesHistory");
    }
    /**
     *
     * @param pageNum      当前页
     * @param pageSize     每页条数
     * @param salesHistory 条件
     * @return map
     */
    @RequestMapping("/quertLikeListSalesHistory")
    public Map quertLikeListSalesHistory(int pageNum, int pageSize, SalesHistory salesHistory) {
        Map map = salesHistoryService.queryLikeSalesHistory(pageNum, pageSize, salesHistory);
        return map;
    }
}
