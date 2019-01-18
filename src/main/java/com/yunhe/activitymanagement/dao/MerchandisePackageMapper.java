package com.yunhe.activitymanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


    /**
     * <P>
     *     商品套餐表
     * </P>

     * @param page 分页的参数存在一个对象里
     * @return 商品套餐表：分页的结果集合
     */
    List<MerchandisePackage> selectmpPage(Page page);
}
