package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/Test1")
    public ModelAndView getGoToPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("purchaseHistory");
        return mv;
    }

    /**
     * 这是一个为了上传才写的注释
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
        System.out.println("名称："+purchaseHistory.getPhNumber());
        Map purchaseHistpage = purchaseHistoryService.getPurchaseHistoryByPhNumber(pageNum,pageSize,purchaseHistory);
        System.out.println(purchaseHistpage);
        return purchaseHistpage;
    }

    @RequestMapping("/addPurchaseHistoryGoTo")
    public void addPurchaseHistoryById(PurchaseHistory purchaseHistory){
        
    }

}
