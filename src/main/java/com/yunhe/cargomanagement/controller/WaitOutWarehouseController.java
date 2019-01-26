package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.dao.WaitOutWarehouseMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.yunhe.cargomanagement.service.ISalesHistoryService;
import com.yunhe.cargomanagement.service.impl.WaitOutWarehouseServiceImpl;
import com.yunhe.cargomanagement.service.impl.WarehouseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 等待出库 前端控制器
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/wait-out-warehouse")
public class WaitOutWarehouseController {

    @Resource
    private WaitOutWarehouseServiceImpl waitOutWarehouseService;

    @Resource
    private ISalesHistoryService salesHistoryService;
    @RequestMapping("/tiao")
    private ModelAndView tiao(){
        return new ModelAndView("/cargomanagement/waitOutWarehouse");
    }

    @RequestMapping("/quertLikeListWaitOutWarehouse")
    public Map quertLikeListWaitOutWarehouse(int pageSize, int pageNum, WaitOutWarehouse waitOutWarehouse){
        waitOutWarehouse.setWoStatus("待出库");
        return waitOutWarehouseService.queryLikeWaitOutWarehouse(pageSize,pageNum,waitOutWarehouse);
    }

    /**
     *detail页面的商品详情
     * @param id
     * @return
     */
    @RequestMapping("/detailList")
    public List<OrderConnectComm> detailList(int id){

        WaitOutWarehouse waitOutWarehouse = waitOutWarehouseService.selectById(id);
        System.out.println(waitOutWarehouse);
        String woNumber = waitOutWarehouse.getWoNumber();
        SalesHistory salesHistory = new SalesHistory();
        salesHistory.setShNumber(woNumber);
        SalesHistory salesHistory1 = salesHistoryService.selectByNumber(salesHistory);
        Integer id1 = salesHistory1.getId();
        return salesHistoryService.detailList(id1);
    }

    /**
     * 跳转到详情页面
     * @param id 根据id定位是哪一条订单
     * @param httpSessionsion
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion){
        WaitOutWarehouse waitOutWarehouse = waitOutWarehouseService.selectById(id);
        httpSessionsion.setAttribute("sales",waitOutWarehouse);
        return new ModelAndView("/cargomanagement/waitOutWarehouse-detail");
    }

    @RequestMapping("/quertLikeListWaitOutWarehouse2")
    public Map quertLikeListWaitOutWarehouse2(int pageSize, int pageNum, WaitOutWarehouse waitOutWarehouse){
        waitOutWarehouse.setWoStatus("已出库");
        return waitOutWarehouseService.queryLikeWaitOutWarehouse(pageSize,pageNum,waitOutWarehouse);
    }
    @RequestMapping("/updateOut")
    public String updateOut(int id){
        WaitOutWarehouse waitOutWarehouse = new WaitOutWarehouse();
        waitOutWarehouse.setId(id);
        waitOutWarehouse.setWoStatus("已出库");
        waitOutWarehouseService.updateOutById(waitOutWarehouse);
        return "true";
    }
}
