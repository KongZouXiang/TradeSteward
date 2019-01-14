package com.yunhe.activitymanagement.service;

import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.baomidou.mybatisplus.extension.service.IService;

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



    /**
     * <P>
     *     商品模板表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @param merchandisePackage 查询条件放在对象里
     * @return 商品模板表：分页的结果集
     */
    Map selectmpPage(int current, int size, MerchandisePackage merchandisePackage);

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 商品模板表：查询的结果集
     */
    List<MerchandisePackage> selectmp();
}
