package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.yunhe.billmanagement.service.IFundClientDebtDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 欠款详细表 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/billmanagement/fund-client-debt-detail")
public class FundClientDebtDetailController {

    @Resource
    IFundClientDebtDetailService fundClientDebtDetailService;

    @RequestMapping("/insertFcdd")
    public boolean insertFcdd(FundClientDebtDetail fundClientDebtDetail){
        return fundClientDebtDetailService.save(fundClientDebtDetail);
    }

    @RequestMapping(value = "/selectFcddPage")
    public Map selectFoPage(int current, int size, FundClientDebtDetail fundClientDebtDetail){
        return fundClientDebtDetailService.selectFcddPage(current,size,fundClientDebtDetail);
    }
}
