package com.yunhe.cargomanagement.service;


import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货订单历史 服务类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */

public interface IPurchaseOrderService extends IService<PurchaseOrder> {
    /**
     * ‘分页’查询进货订单历史
     * @param purchaseOrder 进货订单历史实体类
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @return 进货订单的数据
     *
     */
    Map getPurchaseByPoNumber(int pageNum, int pageSize, PurchaseOrder purchaseOrder);



    /**
     * 增加进货订单历史
     * @param purchaseOrder 进货订单历史实体类
     *
     */
    int insertPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 根据id 删进货订单历史
     * @param id 进货订单历史表id
     * @return
     */
    int deleteById(Serializable id);

    /**
     * 修改订货订单历史
     * @param purchaseOrder 进货订单历史实体类
     */
    void updategetPurchaseById(PurchaseOrder purchaseOrder);

    /**
     * 进货订单历史单条数据 要到修改的页面的input中
     * @param id 进货订单历史表id
     * @return 一条进货订单的数据
     */
    PurchaseOrder selectById(Serializable id);



    /**
     * 进货订单历史详情 单条数据
     * @param id 进货订单历史表id
     * @return 单条数据
     */
    PurchaseOrder getPurchaseById(Integer id);

    /**
     * 审核进货订单历史
     * @param purchaseOrder 订单状态
     * @return int
     */
    int updateHistState(PurchaseOrder purchaseOrder);

    int updateHistStateByid(PurchaseOrder purchaseOrder);

    /**
     * 查询所有
     * @return
     */
    List<PurchaseOrder> selectPurchaseOrder();

    /**
     * 进货订单历史详情
     * @param purchaseOrder 实体类数据
     * @return 历史详情
     */
    List<PurComm> selectPuOrder(PurchaseOrder purchaseOrder);

    /**
     * 一对一
     * @return 商品信息
     */
    List<PurComm> selectComZhong(int id);

    /**
     * 根据订单编号查询
     * @param poNumber 订单编号
     * @return 单条进货订单历史
     */
    PurchaseOrder selectPurOrderByPoNumber(String poNumber);

}
