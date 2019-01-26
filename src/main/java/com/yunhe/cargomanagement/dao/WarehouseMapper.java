package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.Warehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

    /**
     * <p>
     * 库存查询 Mapper 接口
     * </p>
     *
     * @author 耿旺
     * @since 2019-01-02
     */
    @Repository
    public interface WarehouseMapper extends BaseMapper<Warehouse> {


        /**
         * <p>
         *  查询所有库存信息并分页
         * </p>
         *
         * @param page
         * @return list集合
         */
        List<Warehouse> selectAll(Page page);

        /**
         * <p>
         *  模糊查询
         * </p>
         *
         * @param cond 集合
         * @return list集合
         */
        List<Warehouse> selectWareHouseLike(Map<String, Object> cond);

        /**
         * <p>
         *  查询所有库存信息
         * </p>
         *
         * @return list集合
         */
        List<Warehouse> selectAll();

        /**
         * 根据商品名查询
         * @author 史江浩
         * @since 2019-01-25
         * @param waSpName 商品名
         * @return 库存数据
         */
        Warehouse selectWarehouseByWaSpName(String waSpName);


        /**
         * 根据商品名查询
         * @author 史江浩
         * @since 2019-01-25
         * @param waSpCurrentInventory 库存数量
         * @param waTotalSum 总金额
         * @param waSpName 商品名
         * @return int
         */
        int updateWarehouseByWaSpName(int waSpCurrentInventory,double waTotalSum,String waSpName);
}
