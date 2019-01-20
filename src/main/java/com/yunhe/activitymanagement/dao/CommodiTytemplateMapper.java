package com.yunhe.activitymanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.basicdata.entity.CommodityList;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * <p>
 * 商品模板 Mapper 接口
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Repository
public interface CommodiTytemplateMapper extends BaseMapper<CommodiTytemplate> {

    /**
     * <p>
     * 查询商品模板
     * </p>
     *
     * @return
     */
    List<CommodiTytemplate> selectAll();





    /**
     * <P>
     *     商品模板表
     * </P>
     * @param page 分页的参数存在一个对象里
     * @return 商品模板表：分页的结果集合
     */




    /**
     * 插入新的模板
     * @param commodiTytemplate
     * @return 插入是否成功0/1
     */


    /**
     * <p>
     *    根据id 删除商品模板
     * </p>
     * @param serializable
     * @return 删除是否成功0/1
     */

    /**
     * <p>
     *     更改商品模板
     * </p>
     * @param commodiTytemplate
     * @return
     */





}
