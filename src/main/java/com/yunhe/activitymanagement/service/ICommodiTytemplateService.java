package com.yunhe.activitymanagement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.yunhe.basicdata.entity.CommodityList;
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



 Map queryLikeList(int current,int size,CommodiTytemplate commodiTytemplate);
    /**
     * <P>
     *     查询所有商品模板数据
     * </P>
     * @return 商品模板表：查询的结果集
/*     *//*
    List<CommodiTytemplate> selectAllCt();*/


    /**
     * 根据id查询对应的销售
     * @param id
     * @return
     */
    CommodiTytemplate selectById(int id);

    /**
     * <P>
     *     查询商品模板详情
     * </P>
     * @return 商品模板表：查询的结果集
     */
   /* List<CommodityList> selectCt(Integer ctId);*/



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
