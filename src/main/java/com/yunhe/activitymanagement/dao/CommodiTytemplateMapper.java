package com.yunhe.activitymanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * <P>
     *     商品模板表
     * </P>
     * @param commodiTytemplate 商品模板里面的数据都放在一个对象里
     * @param page 分页的参数存在一个对象里
     * @return 商品模板表：分页的结果集合
     */
    List<CommodiTytemplate> selectAllPage(Page page, CommodiTytemplate commodiTytemplate);




}
