package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 进货历史 Mapper 接口
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
public interface PurchaseHistoryMapper extends BaseMapper<PurchaseHistory> {
    /**
     * 进货历史数据分页查询
     * @param page 分页插件
     * @param purchaseHistory 进货历史实体类数据
     * @return 进货历史分页数据
     */
    List<PurchaseHistory> getPurchaseHistoryByPhNumber(Page page,PurchaseHistory purchaseHistory);
}
