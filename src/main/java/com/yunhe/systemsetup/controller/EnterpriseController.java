package com.yunhe.systemsetup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName EnterpriseController
 * @Description TODO
 * @Author 贺裕基
 * @Date 2019/1/10 15:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("/systemsetup/enterprise")
public class EnterpriseController {

    @RequestMapping("/toEnterprise")
    public ModelAndView toEnterprise(){
        return new ModelAndView("/systemsetup/qiyeziliao");
    }
}
