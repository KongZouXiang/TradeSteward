package com.yunhe.reportanalysis;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.billmanagement.service.impl.FundClientDebtServiceImpl;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.service.impl.SalesHistoryServiceImpl;
import com.yunhe.cargomanagement.service.impl.SalesOrderHistoryServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 进货报表 前端控制器
 * </p>
 *
 * @author 邓亮
 * @since 2019-01-07
 *
 */
@RestController
@RequestMapping("/reportanalysis/Sales")
public class SalesReport {
    @Resource
    SalesHistoryServiceImpl salesHistoryService;
    CommodityListServiceImpl commodityListService;
    SalesOrderHistoryServiceImpl salesOrderHistoryService;
    FundClientDebtServiceImpl fundClientDebtService;

    /*销售报表商品查询，前半段*/
    @PostMapping("/getallbypurch")
    @ResponseBody
    public Map selectbyallcomm(int size, int current, CommodityList commodityList){
        return commodityListService.selectAllCommList(current,size,commodityList);
    }
    /*销售报表商品查询，后半段*/
    @PostMapping("/getSales")
    @ResponseBody
    public Map selectSalesHistory(int size, int current, SalesHistory salesHistory){
        return salesHistoryService.queryLikeSalesHistory(current,size,salesHistory);
    }
    /*销售历史*/
    @PostMapping("/getSalesOrd")
    @ResponseBody
    public Page queryLikeList(Map cond){
        return salesOrderHistoryService.queryLikeList(cond);
    }

    /*客户表*/
    @PostMapping("/getFcPage")
    @ResponseBody
    public Map selectFcdPage(int current, int size){
        return fundClientDebtService.selectFcdPage(current,size);
    }

}
