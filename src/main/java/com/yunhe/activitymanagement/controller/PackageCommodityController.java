package com.yunhe.activitymanagement.controller;


import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.entity.PackageCommodity;
import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import com.yunhe.activitymanagement.service.IPackageCommodityService;
import com.yunhe.activitymanagement.service.ITemplateDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
@RestController
@RequestMapping("/activitymanagement/package-commodity")
public class PackageCommodityController {





    @Resource
    IPackageCommodityService packageCommodityService;

    @Resource
    IMerchandisePackageService merchandisePackageService;



    @RequestMapping("/savemoban")
    public boolean insertTemplateDetails(String[] list , MerchandisePackage merchandisePackage) {

        System.out.println(list.length);
        System.out.println(merchandisePackage.getMpPackageName());
        System.out.println(merchandisePackage.getMpPackageNumber());
        int s =merchandisePackageService.insertCt(merchandisePackage);
        if (s==1){
            int cid=  merchandisePackageService.huoquid(merchandisePackage);
        }
        for (int a =0;a<list.length;a++){
            PackageCommodity packageCommodity =new PackageCommodity();
            String []arr=list[a].split(",");
            for (int b =0;b<arr.length;b++){

                packageCommodity.setPcName(arr[1]);
                packageCommodity.setPcNumber(arr[2]);
                packageCommodity.setPcId(s+1);

            }
            packageCommodityService.save(packageCommodity);
        }
        return true;
    }
}
