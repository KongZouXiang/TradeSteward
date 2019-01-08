package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.service.IFundClientDebtService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 客户应收欠款表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/fund-client-debt")
public class FundClientDebtController {

    @Resource
    private IFundClientDebtService fundClientDebtService;
    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 客户应收欠款表：分页的结果集
     */
    @RequestMapping(value = "/selectFcdPage",method = RequestMethod.POST)
    public Map selectFcdPage(int current,int size) {
        return fundClientDebtService.selectFcdPage(current,size);
    }

}
