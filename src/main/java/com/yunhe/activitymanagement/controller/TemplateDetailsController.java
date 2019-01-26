package com.yunhe.activitymanagement.controller;


import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.yunhe.activitymanagement.service.ITemplateDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-10
 */
@RestController
@RequestMapping("/activitymanagement/template-details")
public class TemplateDetailsController {



    @Resource
    ITemplateDetailsService TemplateDetailsService;

    @Resource
    ICommodiTytemplateService commodiTytemplateService;



    @RequestMapping("/savemoban")
    public boolean insertTemplateDetails(String[] list ,CommodiTytemplate commodiTytemplate) {

        System.out.println(list.length);
        System.out.println(commodiTytemplate.getCtTytemplateName());
        System.out.println(commodiTytemplate.getCtTemplateNumber());
        int s =commodiTytemplateService.insertCt(commodiTytemplate);
        if (s==1){
          int cid=  commodiTytemplateService.huoquid(commodiTytemplate);
        }
        for (int a =0;a<list.length;a++){
            TemplateDetails templateDetails =new TemplateDetails();
            String []arr=list[a].split(",");
            for (int b =0;b<arr.length;b++){

                templateDetails.setTdName(arr[1]);
                templateDetails.setTdNumber(arr[2]);
                templateDetails.setCtId(s+1);

            }
            TemplateDetailsService.save(templateDetails);
        }
        return true;
    }
}
