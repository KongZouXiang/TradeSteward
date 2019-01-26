package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货订单历史 Mapper 接口
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Repository
@Mapper
public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder> {

    /**
     * 查询进货订单历史
     * @param page 分页
     * @param purchaseOrder 进货订单历史实体类
     * @return 查询进货订单历史集合分页
     */
    List<PurchaseOrder> getPurchaseByPoNumber(Page page, PurchaseOrder purchaseOrder);


    /**
     * 根据id 删进货订单历史
     * @param id 进货订单历史表id
     * @return int
     */
    int deleteById(Serializable id);

    /**
     * 进货订单历史详情
     * @param id 进货订单历史表id
     * @return 进货订单历史详情 单条数据
     */
    List<PurchaseOrder> getPurchaseById(Integer id);


    /**
     * 修改进货订单历史
     * @param purchaseOrder 进货订单历史实体类
     */
    void updategetPurchaseById(PurchaseOrder purchaseOrder);


    /**
     * 进货订单历史单条数据 要到修改的页面的input中
     * @param id 进货订单历史表id
     * @return purchaseOrder
     */
    PurchaseOrder selectById(Serializable id);


    /**
     *  增进货订单历史
     * @param purchaseOrder 实体类数据
     * @return int
     */
    int insert(PurchaseOrder purchaseOrder);

    /**
     * 审核进货订单历史
     * @param purchaseOrder 订单状态
     * @return int
     */
    int updateHistState(PurchaseOrder purchaseOrder);





    /***********************************************************以下均为测试*************************************************************/


    /**
     * 测试
     * @param page
     * @return
     */
    //List<PurchaseOrder> gerTest(Page page);

    /**
     * 测试 查
     * @param columnMap
     * @return
     */
    List<PurchaseOrder> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);

    /**
     * 测试 改
     * @param entity
     * @return
     */
    int updateById(@Param(Constants.ENTITY) PurchaseOrder entity);



}
