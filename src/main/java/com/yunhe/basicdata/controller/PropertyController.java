package com.yunhe.basicdata.controller;


import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.service.IPropertyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性设置 前端控制器
 * </p>
 *
 * @author 唐凯宽,李恒奎
 * @since 2019-01-04
 */
@RestController
@RequestMapping("/basicdata/property")
public class PropertyController {
    @Resource
 private IPropertyService propertyService;

    /**
     * 属性设置列表
     * @param curr 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @PostMapping("/selectProperty")
    public Map selectProperty(){
        return propertyService.selectproperty();
}

    /**
     * 增加商品属性
     * @param property 传入的属性值
     * @return success
     */
    @PostMapping("/addproperty")
    public String addproperty (Property property){
        propertyService.addproperty(property);
        return "success";
}

    /**
     * 删除商品属性
     * @param id 传过来的属性id
     * @return success
     */
    @PostMapping("/deleteproperty")
    public String deleteproperty(int id){
        propertyService.deletepropoerty(id);
        return "success";
}

    /**
     * 修改商品属性
     * @param property 要修改的内容
     * @return success
     */
    @PostMapping("/updateproperty")
public String updateproperty(Property property){
 propertyService.updateproperty(property);
 return "success";
}
}
