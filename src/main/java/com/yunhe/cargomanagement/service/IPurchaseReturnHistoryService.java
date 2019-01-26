package com.yunhe.cargomanagement.service;

import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 进货退货历史 服务类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-09
 */
public interface IPurchaseReturnHistoryService extends IService<PurchaseReturnHistory> {
     /**
     * 分页查询进货退货历史
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param purchaseReturnHistory 实体类
     * @return 进货退货历史数据集合
     */
     Map selectPurchaseReturnHistoryPage(int pageNum, int pageSize, PurchaseReturnHistory purchaseReturnHistory);

     /**
      * 新增进货退货历史
      * @param purchaseReturnHistory 实体类接收数据
      * @return int
      */
     int insertPurchaseReturnHistoryPage(PurchaseReturnHistory purchaseReturnHistory);

     /**
      * 修改进货退货历史
      * @param purchaseReturnHistory 实体类接收数据
      * @return int
      */
     int updatePurchaseReturnHistory(PurchaseReturnHistory purchaseReturnHistory);

     /**
      * 根据id删除进货退货历史
      * @param id 前台传值id
      * @return int
      */
     int deletePurchaseReturnHistory(Serializable id);

     List<PurchaseReturnHistory> selectPurchaseReturnHistory();

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
}
