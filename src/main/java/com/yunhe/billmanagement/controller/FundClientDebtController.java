package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FundClientDebt;
import com.yunhe.billmanagement.service.IFundClientDebtService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
     *    进入客户应收欠款页面
     * </P>
     * @return 进入FinanceOrder.html
     */
    @GetMapping("/toFcd")
    public ModelAndView toFcd(){
        System.out.println("toFcd进入controller");
        return new ModelAndView("billmanagement/bill-FundClientDebt");
    }
    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 客户应收欠款表：分页的结果集
     */
    @RequestMapping(value = "/selectFcdPage",method = RequestMethod.POST)
    public Map selectFcdPage(int current,int size,FundClientDebt fundClientDebt) {
        return fundClientDebtService.selectFcdPage(current,size,fundClientDebt);
    }

    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundClientDebt 新增收款的参数存在一个对象里
     * @return  客户应收欠款表：增加是否成功
     */
    @PostMapping("/insertFcd")
    public int insertFcd(FundClientDebt fundClientDebt){
        return fundClientDebtService.insertFcd(fundClientDebt);
    }
}
