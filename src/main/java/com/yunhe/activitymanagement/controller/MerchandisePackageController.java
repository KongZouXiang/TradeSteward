package com.yunhe.activitymanagement.controller;


import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping("/shangpintaocan")
    public ModelAndView shangpintaocan () {
        return new ModelAndView("activitymanagement/shangpintaocan");
    }


    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页
     * @param size 每页条数套餐
     * @return  商品套餐表：分页的结果集合
     */
    @RequestMapping(value = "/quertLikeList")
    public Map quertLikeList(int current, int size, MerchandisePackage merchandisePackage){
        return merchandisePackageService.queryLikeList(current,size,merchandisePackage);
    }


    /**
     * 根据id删除套餐信息
     * @return
     */
    @RequestMapping("/delete")
    public int delete(int id){
        return merchandisePackageService.deleteById(id);
    }

    /**
     * 批量删除
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/deleteAll")
    public boolean deleteAll(HttpServletRequest request, @RequestBody List<Integer> ids)  {
        for (Integer id : ids) {
            merchandisePackageService.deleteById(id);
        }
        return true;
    }

}
