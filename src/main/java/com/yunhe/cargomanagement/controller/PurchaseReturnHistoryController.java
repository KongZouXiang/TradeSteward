package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import com.yunhe.cargomanagement.service.IPurchaseReturnHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 进货退货历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/purchase-return-history")
public class PurchaseReturnHistoryController {

    @Resource
    private IPurchaseReturnHistoryService purchaseReturnHistoryService;

    @RequestMapping("/purchaseReturnHistoryList")
    public ModelAndView getGoToPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/purreturnhistory-list");
        return mv;
    }


    /**
     * 条件分页查询进货退货历史
     * @param pageNum 当前页
     * @param pageSize 总条数
     * @param purchaseReturnHistory 实体类接收数据
     * @return 进货历史和分页数据的 数据集合
     */
    @RequestMapping("/selectPurchaseReturnHistoryPage")
    public Map selectPurchaseReturnHistoryPage(int pageNum, int pageSize, PurchaseReturnHistory purchaseReturnHistory){
        System.out.println("****"+purchaseReturnHistory.getPrhNumber());
        System.out.println("********"+pageNum);
        System.out.println("**********"+pageSize);
        Map purchaseReturnHistoryPage = purchaseReturnHistoryService.selectPurchaseReturnHistoryPage(pageNum, pageSize, purchaseReturnHistory);
        return purchaseReturnHistoryPage;
    }

    /**
     * 新增进货退货历史
     * @param purchaseReturnHistory 实体类接收数据
     * @return int
     */
    @RequestMapping("/insertPurchaseReturnHistoryPage")
    public int insertPurchaseReturnHistoryPage(PurchaseReturnHistory purchaseReturnHistory){
        System.out.println(purchaseReturnHistory.getPrhNumber());
        return purchaseReturnHistoryService.insertPurchaseReturnHistoryPage(purchaseReturnHistory);
    }

    /**
     * 根据id修改进货退货历史
     * @param purchaseReturnHistory 实体类接收数据
     * @return int
     */
    @RequestMapping("/updatePurchaseReturnHistory")
    public int updatePurchaseReturnHistory(PurchaseReturnHistory purchaseReturnHistory){
        System.out.println("*****"+purchaseReturnHistory.getId());
        return purchaseReturnHistoryService.updatePurchaseReturnHistory(purchaseReturnHistory);
    }



    /**
     * 根据id删除进货退货历史
     * @param id
     * @return
     */
    @RequestMapping("/deletePurchaseReturnHistory")
    public int deletePurchaseReturnHistory(int id){
        return purchaseReturnHistoryService.deletePurchaseReturnHistory(id);
    }

    public IPurchaseReturnHistoryService getPurchaseReturnHistoryService() {
        return purchaseReturnHistoryService;
    }

    public void setPurchaseReturnHistoryService(IPurchaseReturnHistoryService purchaseReturnHistoryService) {
        this.purchaseReturnHistoryService = purchaseReturnHistoryService;
    }
}
