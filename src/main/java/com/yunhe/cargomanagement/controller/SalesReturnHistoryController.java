package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;
import com.yunhe.cargomanagement.service.impl.SalesReturnHistoryServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 销售退货历史 前端控制器
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/sales-return-history")
public class SalesReturnHistoryController {

    @Resource
    private SalesReturnHistoryServiceImpl salesReturnHistoryService;

    @RequestMapping("/insertSalesReturnHistory")
    public int insertSalesReturnHistory(SalesReturnHistory salesReturnHistory){
        return  salesReturnHistoryService.insertSalesReturnHistory(salesReturnHistory);
    }

    @RequestMapping("/deleteSalesReturnHistory")
    public int deleteSalesReturnHistory(int id){
        return salesReturnHistoryService.deleteSalesReturnHistory(id);
    }

    @RequestMapping("/updateSalesReturnHistory")
    public int updateSalesReturnHistory(SalesReturnHistory salesReturnHistory){
        return salesReturnHistoryService.updateSalesReturnHistory(salesReturnHistory);
    }

    @RequestMapping("/tiao")
    public ModelAndView tiao(){
        return new ModelAndView("cargomanagement/salesReturnHistory");
    }
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param salesReturnHistory
     * @return
     */
    @RequestMapping("/queryLikeSalesReturnHistory")
    public Map queryLikeSalesReturnHistory(int pageSize, int pageNum, SalesReturnHistory salesReturnHistory){
        return  salesReturnHistoryService.queryLikeSalesReturnHistory(pageSize,pageNum,salesReturnHistory);
    }
}
