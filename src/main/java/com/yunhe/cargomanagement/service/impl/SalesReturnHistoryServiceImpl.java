package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.SalesReturnHistoryMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;

import com.yunhe.cargomanagement.service.ISalesReturnHistoryService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private SalesReturnHistoryMapper salesReturnHistoryMapper;

    @Override
    public int insertSalesReturnHistory(SalesReturnHistory salesReturnHistory) {
        salesReturnHistoryMapper.insert(salesReturnHistory);
        return 0;
    }

    @Override
    public int deleteSalesReturnHistory(int id) {

        return salesReturnHistoryMapper.deleteById(id);
    }

    @Override
    public int updateSalesReturnHistory(SalesReturnHistory salesReturnHistory) {
        return salesReturnHistoryMapper.updateById(salesReturnHistory);
    }

    @Override
    public Map queryLikeSalesReturnHistory(int pageSize, int pageNum, SalesReturnHistory salesReturnHistory) {
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<SalesReturnHistory> list = salesReturnHistoryMapper.QueryLikeSalesReturnHistory(page, salesReturnHistory);
        Map<String, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        return map;
    }

    @Override
    public SalesReturnHistory selectById(int id) {

        return salesReturnHistoryMapper.selectById(id);


    }

    @Override
    public List<OrderConnectComm> detailList(int id) {
        List<OrderConnectComm> arr=null;
        return null;
    }
}
