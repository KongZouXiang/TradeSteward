package com.yunhe.customermanagement.controller;


import com.yunhe.customermanagement.entity.CustomerLevel;
import com.yunhe.customermanagement.service.ICustomerLevelService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户等级价 前端控制器
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/customermanagement/customer-level")
public class CustomerLevelController {

    @Resource
    ICustomerLevelService customerLevelService;

    @RequestMapping("/custLevel")
    @ResponseBody
    public ModelAndView selectAllCustomer1() {
        return new ModelAndView("customermanagement/costomerLevel.html");
    }

    @RequestMapping("/selectLevel")
    @ResponseBody
    public Map getLevel(){
        System.out.println("gasdkjadg"+customerLevelService.selectCustomerLevel());
        Map map = new HashMap();
        List<CustomerLevel> list = customerLevelService.selectCustomerLevel();
        map.put("list",list);
        return map;

    }

}
