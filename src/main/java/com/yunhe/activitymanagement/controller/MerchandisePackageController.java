package com.yunhe.activitymanagement.controller;


import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品套餐 前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/activitymanagement/merchandise-package")
public class MerchandisePackageController {



    @Resource
    private IMerchandisePackageService merchandisePackageService;

    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return  商品套餐表：分页的结果集合
     */
    @RequestMapping(value = "/selectmpPage",method = RequestMethod.POST)
    public Map selectmpPage(int current, int size, MerchandisePackage merchandisePackage){
        return merchandisePackageService.selectmpPage(current,size,merchandisePackage);
    }



    /**
     * <P>
     *     查询数据
     * </P>
     * @return 商品套餐表：查询的结果集
     */
    public List<MerchandisePackage> selectmp() {
        return merchandisePackageService.selectmp();
    }

}
