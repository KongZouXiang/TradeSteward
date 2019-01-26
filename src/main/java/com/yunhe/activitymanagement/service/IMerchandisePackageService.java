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
     * @return  商品模板表：删除是否成功
     */
    int deleteById(Serializable id);

    /**
     * 获取id（通过套餐名字）
     * @param merchandisePackage
     * @return
     */
    public int huoquid(MerchandisePackage merchandisePackage);


    /**
     * <P>
     *     增加数据
     * </P>
     * @param merchandisePackage 查询条件放在对象里
     * @return  商品模板表：增加是否成功
     */
    int insertCt(MerchandisePackage merchandisePackage);



    /**
     * <P>
     *     通过id查找数据，显示详情
     * </P>
     * @param id  查询数据的条件
     * @return FinanceOrder对象
     */
    MerchandisePackage selectById(int id);

}
