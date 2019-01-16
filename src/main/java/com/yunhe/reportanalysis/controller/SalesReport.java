package com.yunhe.reportanalysis.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.ICommodityListService;
import com.yunhe.billmanagement.entity.FundClientDebt;
import com.yunhe.billmanagement.service.IFundClientDebtService;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.service.ISalesHistoryService;
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
    ISalesHistoryService salesHistoryService;
    @Resource
    ICommodityListService commodityListService;
    @Resource
    ISalesHistoryService salesOrderHistoryService;
    @Resource
    IFundClientDebtService fundClientDebtService;

    /**
     * <p>
     *     销售报表商品查询，前半段
     * </p>
     * @param size
     * @param current
     * @param commodityList
     * @return
     */
    @PostMapping("/getallbypurch")
    @ResponseBody
    public Map selectbyallcomm(int size, int current, CommodityList commodityList){
        return commodityListService.selectAllcommList(current,size,commodityList);
    }

    /**
     * <p>
     *     销售报表商品查询，后半段
     * </p>
     * @param size
     * @param current
     * @param salesHistory
     * @return
     */
    @PostMapping("/getSales")
    @ResponseBody
    public Map selectSalesHistory(int size, int current, SalesHistory salesHistory){
        return salesHistoryService.queryLikeSalesHistory(current,size,salesHistory);
    }

    /**
     * <p>
     *     销售历史
     * </p>
     * @param cond
     * @return
     */
    @PostMapping("/getSalesOrd")
    @ResponseBody
    public Page queryLikeList(int cond){
        return salesOrderHistoryService.queryLikeSalesHistory(cond);
    }

    /**
     * <p>
     *     客户表
     * </p>
     * @param current
     * @param size
     * @param fundClientDebt
     * @return
     */
    @PostMapping("/getFcPage")
    @ResponseBody
    public Map selectFcdPage(int current, int size, FundClientDebt fundClientDebt){
        return fundClientDebtService.selectFcdPage(1,2,fundClientDebt);
    }

}
