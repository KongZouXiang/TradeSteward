package com.yunhe.activitymanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品套餐 Mapper 接口
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
public interface MerchandisePackageMapper extends BaseMapper<MerchandisePackage> {



    List<MerchandisePackage> selectAll();




    /**
     * 通过模板名称获取id
     * @param merchandisePackage
     * @return
     */
    public int huoquid(MerchandisePackage merchandisePackage);


}


