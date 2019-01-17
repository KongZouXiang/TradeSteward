package com.yunhe.activitymanagement.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.service.ICommodityListService;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品模板 前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/activitymanagement/commodi-tytemplate")
public class CommodiTytemplateController {


    @Resource
    ICommodiTytemplateService commodiTytemplateService;
    @Resource
    ICommodityListService commodityListService;



    public int insertCt(CommodiTytemplate sa){
        return commodiTytemplateService.insertCt(sa);
    }
    /**
     * 根据id删除模板信息
     * @return
     */
    @RequestMapping("/delete")
    public int delete(int id){
        return commodiTytemplateService.deleteById(id);
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
            commodiTytemplateService.deleteById(id);
        }
        return true;
    }



    /**
     * <P>
     *     修改数据
     * </P>
     * @return  商品模板表：
     */

    @RequestMapping("/update")
    public ModelAndView updateCt(CommodiTytemplate commodiTytemplate){
        int i = commodiTytemplateService.updateCt(commodiTytemplate);
        return new ModelAndView("updateCt");
    }




    @RequestMapping("/shangpinmoban")
    public ModelAndView shangpinmoban () {
        return new ModelAndView("activitymanagement/shangpinmoban");
    }

    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return  商品模板表：分页的结果集合
     */
    @GetMapping("/quertLikeList")
    public Map quertLikeList(int current, int size, CommodiTytemplate commodiTytemplate){
     return commodiTytemplateService.queryLikeList(current,size,commodiTytemplate);
    }









/*

    */
/**
     * <P>
     *     查询商品列表数据
     * </P>
     * @param
     *//*


    @RequestMapping(value = "/selectCl",method = RequestMethod.POST)

    public Map selectCl(int current,int size,CommodityList commodityList) {

        return commodityListService.selectAllcommList(1,3,commodityList);
    }
*/


}
