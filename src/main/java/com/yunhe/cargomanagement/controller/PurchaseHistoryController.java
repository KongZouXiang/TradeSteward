package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 进货历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/cargomanagement/purchase-history")
public class PurchaseHistoryController {

    @Resource
    private IPurchaseHistoryService purchaseHistoryService;



    @RequestMapping("/purchasehistoryList")
    public ModelAndView getGoToPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/purhistory-list");
        return mv;
    }

    /**
     * 这是一个为了上传才写的注释....
     * @return
     */
    @RequestMapping("/addPurchaseHistory")
    public ModelAndView getPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addPurchaseHistory");
        return mv;
    }

    /**
     * 进货历史分页
     * @param pageNum 前台传过来的当前页数据
     * @param pageSize 前台传过来的每页条数数据
     * @param purchaseHistory 进货历史条件查询的数据
     * @return 进货历史分页数据 传到前台 ajax接收
     */
    @RequestMapping("/getPurchaseHistoryPage")
    public Map getPurchaseHistoryByPhNumber(int pageNum, int pageSize, PurchaseHistory purchaseHistory){
        System.out.println(purchaseHistory.getPhNumber()+"*******"+purchaseHistory.getPhSupname());
        Map purchaseHistpage = purchaseHistoryService.getPurchaseHistoryByPhNumber(pageNum,pageSize,purchaseHistory);
        return purchaseHistpage;
    }

    /**
     * 新增进货历史
     * @param purchaseHistory 进货历史实体类接收的数据
     * @return int
     */
    @RequestMapping("/addPurchaseHistoryGoTo")
    public int addPurchaseHistoryById(PurchaseHistory purchaseHistory){
        System.out.println(purchaseHistory+"..............");
        return purchaseHistoryService.insertPurchaseHistory(purchaseHistory);
    }

    /**
     * 根据id删除进货历史
     * @param id 前台传值id
     * @return int
     */
    @RequestMapping("/deletePurchaseHistoryById")
    public int deletePurchaseHistoryById(int id){
        System.out.println("*******"+id);
        return purchaseHistoryService.deleteById(id);
    }

    /**
     * 根据id修改进货历史
     * @param purchaseHistory 进货历史实体类接收的数据
     * @return int
     */
    @RequestMapping("/updatePurchaseHistoryById")
    public int updatePurchaseHistoryById(PurchaseHistory purchaseHistory){
        System.out.println("*****"+purchaseHistory.getId());
        return purchaseHistoryService.updatePurchaseHistoryById(purchaseHistory);
    }


    public IPurchaseHistoryService getPurchaseHistoryService() {
        return purchaseHistoryService;
    }

    public void setPurchaseHistoryService(IPurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

}
