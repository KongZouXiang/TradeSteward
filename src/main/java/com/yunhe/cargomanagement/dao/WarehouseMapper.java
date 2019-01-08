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

        /*List<Warehouse> selectAll();*/

        /**
         * <p>
         *  查询所有库存信息并分页
         * </p>
         *
         * @param page      实体类
         * @param warehouse 实体类
         * @return list集合
         */
        List<Warehouse> selectAll(Page page, Warehouse warehouse);

        /**
         * <p>
         *  模糊查询
         * </p>
         *
         * @param cond 集合
         * @return list集合
         */
        List<Warehouse> selectWareHouseLike(Map<String, Object> cond);

}
