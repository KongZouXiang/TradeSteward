package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesHistory;

import java.util.List;

/**
 * <p>
 * 销售历史 Mapper 接口
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface SalesHistoryMapper extends BaseMapper<SalesHistory> {


    List<SalesHistory> selectSalesHistory(Page page, SalesHistory salesHistory);
}
