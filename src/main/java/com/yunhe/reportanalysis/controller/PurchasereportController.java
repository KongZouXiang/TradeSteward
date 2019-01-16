package com.yunhe.reportanalysis.controller;

import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.ICommodityListService;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.cargomanagement.service.IPurchaseOrderService;
import com.yunhe.cargomanagement.service.ISalesOrderHistoryService;
import com.yunhe.cargomanagement.service.impl.PurchaseOrderServiceImpl;
import com.yunhe.customermanagement.service.ISupplierService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 进货报表 前端控制器
 * </p>
 *
 * @author 邓亮
 * @since 2019-01-06
 *
 */

@RestController
@RequestMapping(value = "/reportanalysis/Purch")
public class PurchasereportController {


    @Resource
    ICommodityListService commodityListService;
    @Resource
    ISupplierService supplierService;
    @Resource
    IPurchaseOrderService purchaseOrderService;
    @Resource
    ISalesOrderHistoryService salesOrderHistoryService;

    @GetMapping("/rep_admin_list")
    public ModelAndView rep_admin_list(ModelAndView view){
        view.setViewName("/reportanalysis/rep_admin_list");
        return view;
    }
    /**
     *
     * @param size 每页显示的条数
     * @param current 当前页
     * @param commodityList 实体类
     * @return
     */
    @PostMapping("/getallbypurch")
    @ResponseBody
    public Map selectbyallcomm(int size, int current, CommodityList commodityList){

        return commodityListService.selectAllcommList(current,size,commodityList);
    }
    @GetMapping("/selectall")
    @ResponseBody
    public Map selectAll(){
        List<SalesOrderHistory> list = salesOrderHistoryService.selectAll();
        Map map=new HashMap();
        map.put("commclass",list);
        return map;
    }

 /*   @PostMapping("/selectallsupp")
    @ResponseBody
    public Map selectbyallSupplier(){
        Map list=();
        Map map=new HashMap();
        map.put("commclass",list);
        return map;
    }*/



    /*@PostMapping("/getallbySupp")
    @ResponseBody
    public Map selectbyallSupplier(int size, int current, CommodityList commodityList){
        return supplierService.(current,size,commodityList);
    }*/

    @PostMapping("/getallbyDocu")
    @ResponseBody
    public Map getPurchaseByPoNum(int pageSize, int pageNum, PurchaseOrder purchaseOrder){
        return purchaseOrderService.getPurchaseByPoNumber(pageSize,pageNum,purchaseOrder);
    }


    /*@Resource
    PurchasereportServiceImpl purchasereportService;

    *//**
     * 查询进货的信息 分页
     *
     * @param size          每页显示的条数
     * @param current       当前页
     * @param purchasereport 进货列表的对象
     * @return 进货的信息
    *//*
    @RequestMapping(value = "getpage",method = RequestMethod.POST)
    @ResponseBody
    public Map selectpurchPage(int size, int current, Purchasereport purchasereport){
        return purchasereportService.selectAllPurchasereport(size, current, purchasereport);
    }
    *//**
     * 查询进货的详细信息
     *
     * @param id 传过来的编号
     * @return 返回该订单进货详情
     *//*
    @RequestMapping(value = "getPuchList",method = RequestMethod.POST)
    @ResponseBody
    public Map selectPurchasereportById(int id){
        Map map = new HashMap();
        Purchasereport purchasereport = purchasereportService.selectPurchasereportById(id);
        map.put("purchasereport",purchasereport);
        return map;
    }

    *//**
     * 模糊查询
     *
     * @param data 传过来的商品信息
     * @return 返回该订单进货详情
     *//*
    @RequestMapping(value = "/vaguelist",method = RequestMethod.POST)
    @ResponseBody
    public Map vaguePurchasereportList(String data){
        List list = (List) purchasereportService.selectPurchasereport(data);
        Map map = new HashMap();
        map.put("data",list);
        return map;
    }*/


}
