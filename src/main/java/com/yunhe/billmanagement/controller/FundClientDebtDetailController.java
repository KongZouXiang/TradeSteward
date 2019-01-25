package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.yunhe.billmanagement.service.IFundClientDebtDetailService;
import com.yunhe.core.common.annotion.WebLog;
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
    /**
     * <P>
     *    添加客户欠款详细信息
     * </P>
     * @param fundClientDebtDetail 添加客户欠款详细信息的参数存放在对象里
     * @return 是否添加成功
     */
    @WebLog("添加客户欠款详细信息")
    @RequestMapping("/insertFcdd")
    public boolean insertFcdd(FundClientDebtDetail fundClientDebtDetail){
        return fundClientDebtDetailService.save(fundClientDebtDetail);
    }

    /**
     * <P>
     *    客户欠款详细信息分页
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @param fundClientDebtDetail 客户欠款详细信息的条件存放在对象里
     * @return map集合
     */
    @WebLog("查看客户欠款详细信息")
    @RequestMapping(value = "/selectFcddPage")
    public Map selectFoPage(int current, int size, FundClientDebtDetail fundClientDebtDetail){
        return fundClientDebtDetailService.selectFcddPage(current,size,fundClientDebtDetail);
    }
}
