package com.yunhe.reportanalysis.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("reportanalysis/purchaserViewContro")
public class purchasereportViewContro {


    /**
     * <p>
     *     跳转进货报表主页面
     * </p>
     * @return  商品详情查询界面
     */
    @RequestMapping("/login")
    public ModelAndView Login(){
         return new ModelAndView("reportanalysis/rep_admin_list.html");
    }

    /**
     * <p>
     *     根据供应商查询界面
     * </p>
     * @return 供应商查询界面
     */
    @RequestMapping("/selctAllSupp")
    public ModelAndView selctAllSupp(){
        return new ModelAndView("reportanalysis/rep_supp_list.html");
    }

    /**
     * <p>
     *     根据单据查询界面
     * </p>
     * @return  单据查询界面
     */
    public ModelAndView selctAllDocument(){
        return new ModelAndView("reportanalysis/re_docu_list.html");
    }
}
