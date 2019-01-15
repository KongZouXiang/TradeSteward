package com.yunhe.activitymanagement.controller;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.ICommodityListService;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return  商品模板表：分页的结果集合
     */
    @RequestMapping(value = "/selectAllPage",method = RequestMethod.POST)
    public Map selectAllPage(int current, int size, CommodiTytemplate commodiTytemplate){
        return commodiTytemplateService.selectAllPage(current,size,commodiTytemplate);
    }



    /**
     * <P>
     *     增加数据
     * </P>
     * @param commodiTytemplate 增加的信息放在对象里
     * @return  增加模板表：增加是否成功
     */
    /*@RequestMapping("/insertCt")
    public int insertCt(CommodiTytemplate commodiTytemplate){
        return  commodiTytemplateService.insertCt(commodiTytemplate);
    }*/

    /**
     * <P>
     *     删除数据
     * </P>
     * @param commodiTytemplate 查询条件放在对象里
     * @return  商品模板表：删除是否成功
     */
    @RequestMapping(value = "/deleteCt",method = RequestMethod.POST)
    public int deleteCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateService.deleteCt(commodiTytemplate);
    }


    /**
     * <P>
     *     修改数据
     * </P>
     * @return  商品模板表：
     */
    @RequestMapping(value = "/updateCt",method = RequestMethod.POST)
    public int updateCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateService.updateCt(commodiTytemplate);
    }



    /**
     * <P>
     *     查询数据
     * </P>
     * @return 商品模板表：查询所有模板的结果集
     */
    @RequestMapping(value = "/selectAllCt",method = RequestMethod.POST)
    public List<CommodiTytemplate> selectAllCt() {
        return commodiTytemplateService.selectAllCt();
    }




    /**
     * <P>
     *     查询商品列表数据
     * </P>
     * @param
     */

    @RequestMapping(value = "/selectCl",method = RequestMethod.POST)

    public Map selectCl(int current,int size,CommodityList commodityList) {

        return commodityListService.selectAllCommList(1,3,commodityList);
    }





}
