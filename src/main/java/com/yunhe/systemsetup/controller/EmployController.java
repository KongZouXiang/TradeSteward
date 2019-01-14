package com.yunhe.systemsetup.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.Employ;
import com.yunhe.systemsetup.service.impl.EmployServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工管理 前端控制器
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/systemsetup/employ")
public class EmployController {
    @Autowired
    private EmployServiceImpl employService;


    @RequestMapping(value = "/selectpage")
    public Map selectPage(Integer pageSize, Integer pageNum, Employ employ){
        System.out.println("进入Controleer");
        System.out.println(employ.getEmUsername());
        Page page = new Page();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        List<Employ> list =employService.selectPageEmploy(page,employ);
        System.out.println(list);
        Map map = new HashMap();
        map.put("page",page);
        map.put("list",list);
        map.put("totalPage",page.getPages());
        return map;
    }

    @RequestMapping(value = "/list")
    public ModelAndView toList(){
        return new ModelAndView("/systemsetup/admin" );
    }
    @RequestMapping(value = "/addempl")
    public ModelAndView toAdd(){

        return new ModelAndView("/systemsetup/admin-add");
    }

    @RequestMapping(value = "/insertempl")
    public String inserEmploy(Employ employ){

        employService.insertEmploy(employ);

        return  null;
    }
}
