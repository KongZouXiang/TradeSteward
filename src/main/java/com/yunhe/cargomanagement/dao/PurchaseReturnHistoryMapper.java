package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 进货退货历史 Mapper 接口
 * </p>
 *
 * @since 2019-01-09
 * @author 史江浩
 */
@Repository
@Mapper
public interface PurchaseReturnHistoryMapper extends BaseMapper<PurchaseReturnHistory> {

    /**
     * 分页查询进货退货历史
     * @param page mybatis分页插件
     * @param purchaseReturnHistory 实体类
     * @return 进货退货历史数据集合
     */
    List<PurchaseReturnHistory> selectPurchaseReturnHistoryPage(Page page, PurchaseReturnHistory purchaseReturnHistory);

    /**
     * 进货退货历史详情
     * @param id 根据id查询
     * @return 进货退货历史详情
     */
    PurchaseReturnHistory selectOrderXiangList(int id);

    /**
     * 一对一查询进货退货历史关联商品
     * @return 商品信息
     */
    List<PurComm> selectOrderHistZhong(int id);

    /**
     * 根据退货订单号查询
     * @param prhNumber 退货订单号
     * @return 退货订单详情
     */
    PurchaseReturnHistory selectRurchaseReturnHistByNum(String prhNumber);

    /**
     * 查询所有
     * @return 所有
     */
    List<PurchaseReturnHistory> selectPurchaseReturnHistory();
}
