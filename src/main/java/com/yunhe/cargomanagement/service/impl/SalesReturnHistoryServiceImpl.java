package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.SalesReturnHistoryMapper;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;

import com.yunhe.cargomanagement.service.ISalesReturnHistoryService;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 销售退货历史 服务实现类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Service
public class SalesReturnHistoryServiceImpl extends ServiceImpl<SalesReturnHistoryMapper, SalesReturnHistory> implements ISalesReturnHistoryService {

    private SalesReturnHistoryMapper salesReturnHistoryMapper;

    @Override
    public int insertSalesReturnHistory(SalesReturnHistory salesReturnHistory) {
        salesReturnHistoryMapper.insert(salesReturnHistory);
        return 0;
    }

    @Override
    public int deleteSalesReturnHistory(int id) {
        return 0;
    }

    @Override
    public int updateSalesReturnHistory(SalesReturnHistory salesReturnHistory) {
        return 0;
    }

    @Override
    public Map QueryLikeSalesReturnHistory(int pageSize, int pageNum, SalesReturnHistory salesReturnHistory) {
        return null;
    }
}
