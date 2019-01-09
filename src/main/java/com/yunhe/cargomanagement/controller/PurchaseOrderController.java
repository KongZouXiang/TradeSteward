package com.yunhe.cargomanagement.controller;


import com.github.pagehelper.Page;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.yunhe.cargomanagement.service.IPurchaseOrderService;
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
 * 进货订单历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/purchase-order")
public class PurchaseOrderController {
    @Resource
    private IPurchaseOrderService purchaseOrderService;

    /**
     * 跳转到进货订单历史页面
     * @return 页面
     */
    @RequestMapping("/Test")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("testgetPage");
        return mv;
    }

    /**
     * 增加进货订单历史页面
     * @return 页面
     */
    @RequestMapping("/addPurchase")
    public ModelAndView getaddPurchase(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addPurchase");
        return mv;
    }


    /**
     * 进货订单历史分页
     * @param pageNum 前台传当前页
     * @param pageSize 前台传每页条数
     * @param purchaseOrder  进货订单历史数据
     * @return 进货订单历史分页数据  传到前台 ajax接收
     */
    @RequestMapping("/getPage")
    public Map getPurchaseByPoNumber(int pageNum, int pageSize, PurchaseOrder purchaseOrder) {
        System.out.println("供111***"+purchaseOrder.getPoSupName());
        Map purchaseByPoNumber = purchaseOrderService.getPurchaseByPoNumber(pageNum, pageSize, purchaseOrder);
        System.out.println(purchaseByPoNumber);
        return purchaseByPoNumber;
    }

    /**
     * 增加进货订单历史
     * @param purchaseOrder  进货订单历史实体类数据
     */
    @RequestMapping("/addPurchaseGoTo")
    public void insertPurchaseOrder(PurchaseOrder purchaseOrder){
        System.out.println(purchaseOrder.getPoNumber());
        System.out.println(purchaseOrder.getPoYingMoney());
        System.out.println(purchaseOrder);
        purchaseOrderService.insertPurchaseOrder(purchaseOrder);
    }

    /**
     * 根据id查询进货订单历史 单条数据
     * @param id 进货订单历史表id  前台传的
     * @return
     */
    @RequestMapping("/getPuById")
    public List<PurchaseOrder> getPurchaseById(int id){
        List<PurchaseOrder> list = purchaseOrderService.getPurchaseById(id);
        return list;
    }

    /**
     * 根据id删除进货订单历史
     * @param id  进货订单历史表id  前台传的
     */
    @RequestMapping("/deletePurchaseById")
    public void deletePurchById(int id){
        System.out.println("这条数据的id"+id);
        purchaseOrderService.deleteById(id);
    }

    /**
     * 根据id修改进货订单历史
     * @param purchaseOrder 进货订单历史实体类数据
     */
    @RequestMapping("/updatePurchaseById")
    public void updategetPurchaseById(PurchaseOrder purchaseOrder){
        System.out.println("*******"+purchaseOrder.getId());
        purchaseOrderService.updategetPurchaseById(purchaseOrder);
    }

    /**
     * 根据id查询进货订单历史并把数据存到session到前台的input中
     * @return 跳转页面
     */
    @RequestMapping("/selectById")
    public ModelAndView selectPurchaseById(int id, HttpSession httpSession){
        System.out.println("前台传过来的id:"+id);
        PurchaseOrder purchaseOrder = purchaseOrderService.selectById(id);
        httpSession.setAttribute("purchase",purchaseOrder);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updatePurchase");
        return mv;
    }


    public IPurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    public void setPurchaseOrderService(IPurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }
}
