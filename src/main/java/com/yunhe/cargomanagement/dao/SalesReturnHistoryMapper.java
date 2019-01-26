package com.yunhe.cargomanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;

import java.util.List;

/**
 * <p>
 * 销售退货历史 Mapper 接口
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
public interface SalesReturnHistoryMapper extends BaseMapper<SalesReturnHistory> {

    List<SalesReturnHistory> QueryLikeSalesReturnHistory(Page page,SalesReturnHistory salesReturnHistory);

    SalesReturnHistory selectById(int id);
}
