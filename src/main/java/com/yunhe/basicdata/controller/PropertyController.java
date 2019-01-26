package com.yunhe.basicdata.controller;


import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.entity.Propertyval;
import com.yunhe.basicdata.service.IPropertyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
   @RequestMapping("/propertylist")
   public ModelAndView propertylist(){
       return new ModelAndView("basicdata/property.html");
   }
    @RequestMapping("/insertproperty")
    public ModelAndView insertproperty(int id){
        System.out.println("id=="+id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("ss",id);
        mv.setViewName("basicdata/addproperty.html");
        return mv;
    }
   @RequestMapping("/editproperty")
    public int editproperty(Property property){
       System.out.println("pp:==="+property.getPrattributevalue());

        return propertyService.updatename(property);
    }
    @RequestMapping("/selectbyid")
    public ModelAndView selectbyid(int id){
        System.out.println("id"+id);
        Property property=propertyService.selectbyid(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("ss",property);
        mv.setViewName("basicdata/editProperty.html");
        return mv;
    }



    /**
     * 属性设置列表
     * @return
     */
    @PostMapping("/selectProperty")
    public List selectProperty(){
        Map map=new HashMap();
        //List<Property> propertyList=propertyService.selectproperty();
       // map.put("propertyList",propertyList);
        List<Map<String,Object>> list = propertyService.selectAll();
        System.out.println("list:"+list);
        return list;
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
@PostMapping("/insertvalue")
    public int insertvalue(Propertyval propertyval){
        return propertyService.insertvalue(propertyval);
}
}
