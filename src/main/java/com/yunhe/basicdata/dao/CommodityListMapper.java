package com.yunhe.basicdata.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.Commclass;
import com.yunhe.basicdata.entity.CommodityList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.basicdata.entity.WarehouseManagement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

/**
 * <p>
 * 商品列表 Mapper 接口
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Repository
@Mapper
public interface CommodityListMapper extends BaseMapper<CommodityList> {
    /**
     * 商品列表的分页
     *
     * @param page 分页插件
     * @return 返回商品的信息
     */
    List<CommodityList> selectAllCommmList(Page page);

    /**
     * 增加商品的信息
     *
     * @param commodityList 商品列表实体类
     * @return 无返回
     */
    int insertComm(CommodityList commodityList);

    /**
     * 查询商品的详细信息
     *
     * @param id 查询商品的id
     * @return 根据id返回的商品信息
     */
    CommodityList selectCommById(int id);

    /**
     * 更改商品的信息
     *
     * @param commodityList 更改商品的实体类
     * @return 返回更改后的商品信息
     */
    int updateComm(CommodityList commodityList);

    /**
     * 删除商品的信息
     *
     * @param commodityList 删除商品的实体类
     * @return 无返回
     */
    int deleteComm(CommodityList commodityList);

    /**
     * 导出excel文件
     *
     * @return
     */
    List<CommodityList> selectExcel();

    /**
     * 查询仓库名
     *
     * @param id 传的是商品列表的id
     * @return
     */
    WarehouseManagement selectwmandcomm(int id);

    /**
     * 查询的是分类
     *
     * @param id 传的是商品列表的id
     * @return
     */
    Commclass selectComclassAndCommdity(int id);

    /**
     * @return 查询商品
     * @author 史江浩
     * @since 2019-01-21
     */
    List<CommodityList> selectComclassList1();


    /**
     * @return 根据商品名查询商品
     * @author 史江浩
     * @since 2019-01-21
     */
    CommodityList selectListByClName(String clName);
}

