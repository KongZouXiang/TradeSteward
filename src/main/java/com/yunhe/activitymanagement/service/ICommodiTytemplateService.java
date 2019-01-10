package com.yunhe.activitymanagement.service;

import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.basicdata.entity.CommodityList;

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
     * <P>
     *     商品模板表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @param commodiTytemplate 查询条件放在对象里
     * @return 商品模板表：分页的结果集
     */
    Map selectAllPage(int current, int size, CommodiTytemplate commodiTytemplate);


    /**
     * <P>
     *     查询数据
     * </P>
     * @return 商品模板表：查询的结果集
     */
    List<CommodiTytemplate> selectAllCt();

    /**
     * <P>
     *     查询商品模板详情
     * </P>
     * @return 商品模板表：查询的结果集
     */
    List<CommodityList> selectCt(Integer ctId);



    /**
     * <P>
     *     增加数据
     * </P>
     * @param commodiTytemplate 查询条件放在对象里
     * @return  商品模板表：增加是否成功
     */
    List<Integer> insertCt(CommodiTytemplate commodiTytemplate);



    /**
     * <P>
     *     增加数据
     * </P>
     * @param commodiTytemplate 查询条件放在对象里
     * @return  商品模板表：增加是否成功
     */
    int updateCt(CommodiTytemplate commodiTytemplate);


    /**
     * <P>
     *     删除数据
     * </P>
     * @param commodiTytemplate 查询条件放在对象里
     * @return  商品套餐表：删除是否成功
     */
    int deleteCt(CommodiTytemplate commodiTytemplate);
}
