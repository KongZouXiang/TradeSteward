package com.yunhe.basicdata.service;

import com.yunhe.basicdata.entity.CommodityList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品列表 服务类
 * </p>
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Repository
public interface ICommodityListService extends IService<CommodityList> {
    /**
     * 查询商品列表 分页
     *  三个参数
     * @param current       当前页
     * @param size          每页的条数
     * @param commodityList 实体类
     * @return f返回商品的信息
     */
    Map selectAllcommList(int current, int size,CommodityList commodityList);
    /**
     * 新增商品列表
     * @param commodityList 新增商品的实体类
     * @return 返回增加的商品
     */
    int insertComm(CommodityList commodityList);

    /**
     * 查询商品的详细信息
     *
     * @param id 查询商品的id
     * @return 返回根据id查询信息
     */
    CommodityList selectCommById(int id);

    /**
     * 更改商品的信息
     *
     * @param commodityList 更改商品的实体类
     * @return 返回更改的信息
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
     * 模糊查询
     *
     * @param data 模糊查询的条件
     * @return 返回模糊查询的信息
     */
    List<CommodityList> selectCommstlist(String data);


    /**
     * @author 史江浩
     * @since 2019-01-14
     * @return 查询商品
     */
    Map selectList();
}
