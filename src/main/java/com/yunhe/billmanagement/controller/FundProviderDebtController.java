package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FundProviderDebt;
import com.yunhe.billmanagement.service.IFundProviderDebtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 供应商应付欠款表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/fund_provider_debt")
public class FundProviderDebtController {
    @Resource
    private IFundProviderDebtService fundProviderDebtService;

    /**
     * <P>
     *    进入供应商应付欠款页面
     * </P>
     * @return 进入bill-FundProviderDebt.html
     */
    @RequestMapping("/toFpd")
    public ModelAndView toFpd(){
        System.out.println("toFpd进入controller");
        return new ModelAndView("billmanagement/bill-FundProviderDebt");
    }

    /**
     * <P>
     *     供应商应付欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 供应商应付欠款表：分页的结果集
     */
    @GetMapping("/selectFpdPage")
    public Map selectFpdPage(int current, int size,FundProviderDebt fundProviderDebt) {
        return fundProviderDebtService.selectFpdPage(current,size,fundProviderDebt);
    }

    /**
     * <P>
     *    进入增加页面
     * </P>
     * @return 进入FPD_add.html
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        System.out.println("toadd进入controller");
        return new ModelAndView("billmanagement/bill-FPD-add");
    }

    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundProviderDebt 新增付款的参数存在一个对象里
     * @return  供应商应付欠款表：增加是否成功
     */
    @PostMapping("/insertFpd")
    public int insertFcd(FundProviderDebt fundProviderDebt) {
        return fundProviderDebtService.insertFpd(fundProviderDebt);
    }

    /**
     * <P>
     *    进入详情页面
     * </P>
     * @return 进入bill-FPD-detail.html
     */
    @RequestMapping("/toDetail")
    public ModelAndView toDetail(int id,HttpSession session){
        System.out.println("toDetail进入controller");
        FundProviderDebt fundProviderDebt = fundProviderDebtService.selectFpd(id);
        session.setAttribute("fundProviderDebt",fundProviderDebt);
        return new ModelAndView("billmanagement/bill-FPD-detail");
    }

    /**
     * <P>
     *     查看数据详情
     * </P>
     * @param id 要查看的数据的id
     * @return  一行或多行数据
     */
    @PostMapping("/selectFpd")
    public FundProviderDebt selectFpd(int id) {
        System.out.println("要查看的数据的id："+id);
        return fundProviderDebtService.selectFpd(id);
    }
}
