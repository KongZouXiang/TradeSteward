package com.yunhe.cargomanagement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 进货历史 服务类
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
public interface IPurchaseHistoryService extends IService<PurchaseHistory> {

    /**
     * ‘分页’查询进货历史
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param purchaseHistory 进货历史实体类
     * @return 进货历史的数据
     */
    Map getPurchaseHistoryByPhNumber(int pageNum, int pageSize, PurchaseHistory purchaseHistory);
}
