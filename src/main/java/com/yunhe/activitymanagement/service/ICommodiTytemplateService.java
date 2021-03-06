package com.yunhe.activitymanagement.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;


import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品模板 服务类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
public interface ICommodiTytemplateService extends IService<CommodiTytemplate> {


    /**
     *  模糊查询，分页
     * @param current
     * @param size
     * @param commodiTytemplate
     * @return
     */
    IPage selectLikePage(int current, int size, CommodiTytemplate commodiTytemplate);
     /**
     * <P>
     *     查询所有商品模板数据
     * </P>
     * @return 商品模板表：查询的结果集
/*     */

     List<CommodiTytemplate> selectAll();


    /**
     * 查询所有商品
     * @param current
     * @param size
     * @param commodityList
     * @return
     */


    /**
     * <P>
     *     查询商品模板详情
     * </P>
     * @return 商品模板表：查询的结果集
     */



    /**
     * <P>
     *     通过id查找数据，显示详情
     * </P>
     * @param id  查询数据的条件
     * @return FinanceOrder对象
     */
    CommodiTytemplate selectById(int id);



    /**
     * <P>
     *     增加数据
     * </P>
     * @param commodiTytemplate 查询条件放在对象里
     * @return  商品模板表：增加是否成功
     */
    int insertCt(CommodiTytemplate commodiTytemplate);


    /**
     * <P>
     *      更改数据
     * </P>
     * @param commodiTytemplate 条件放在对象里
     * @return  商品模板表：更改是否成功
     */
    int updateCt(CommodiTytemplate commodiTytemplate);


    /**
     * <P>
     *     删除数据
     * </P>
     * @param
     * @return  商品模板表：删除是否成功
     */
    int deleteById(Serializable id);


}
