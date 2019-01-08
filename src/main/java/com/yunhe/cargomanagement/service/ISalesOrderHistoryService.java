package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.logging.log4j.util.PropertySource;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售订单历史 服务类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-05
 */
public interface ISalesOrderHistoryService extends IService<SalesOrderHistory> {
    /**
     * <p>
     *     条件查询销售历史
     * </p>
      * @param cond
     * @return 销售历史
     */
    Page queryLikeList(Map cond);

    /**
     * 更新销售订单历史
     * @param salesOrderHistory 要更新的销售历史记录的信息
     * @return int
     */
    int updateSale(SalesOrderHistory salesOrderHistory);

    /**
     * 根据id删除销售历史记录
     * @param id 当前销售记录的id
     * @return int
     */
    int deleteById(Serializable id);

    /**
     * 插入新的销售订单历史
     * @param salesOrderHistory 要插入的销售历史记录的信息
     * @return int
     */
    int insertSale(SalesOrderHistory salesOrderHistory);

    /**
     * 根据id查询对应的销售
     * @param id
     * @return
     */
    SalesOrderHistory selectById(int id);

    /**
     * 查询所有的
     * @return
     */
    List<SalesOrderHistory> selectAll();

}
