package com.yunhe.activitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品套餐 服务类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
public interface IMerchandisePackageService extends IService<MerchandisePackage> {


    IPage selectLikePage(int current, int size, MerchandisePackage merchandisePackage);


    List<MerchandisePackage> selectAll();
    /**
     * <P>
     *     删除数据
     * </P>
     * @param
     * @return  商品套餐表：删除是否成功
     */
    int deleteById(Serializable id);


}
