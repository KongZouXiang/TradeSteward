package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 销售订单历史 Mapper 接口
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-05
 */
public interface SalesOrderHistoryMapper extends BaseMapper<SalesOrderHistory> {
        /**
         * <p>
         *     查询销售历史记录
         * </p>
         * @param page
         * @return  分页查询销售历史记录
         */
        List<SalesOrderHistory> selectSaleList(Page page, SalesOrderHistory salesOrderHistory);

        /**
         * 插入新的销售历史
         * @param salesOrderHistory
         * @return 插入是否成功0/1
         */
        @Override
        int insert(SalesOrderHistory salesOrderHistory);


        /**
         * <p>
         *     删除销售历史记录
         * </p>
         * @param serializable
         * @return 删除是否成功0/1
         */
        @Override
        int deleteById(Serializable serializable);

        /**
         * <p>
         *     更新销售历史记录
         * </p>
         * @param salesOrderHistory
         * @return
         */
        int updateSale(SalesOrderHistory salesOrderHistory);

        List<SalesOrderHistory> selectAll();

        List<SalesOrderHistory> selectAbc(int id);

        SalesOrderHistory selectSaleById(int id);
}