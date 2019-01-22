package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.dao.SalesHistoryMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.service.ISalesHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售历史 服务实现类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Service
public class SalesHistoryServiceImpl extends ServiceImpl<SalesHistoryMapper, SalesHistory> implements ISalesHistoryService {

    @Resource
    private SalesHistoryMapper salesHistoryMapper;
    @Override
    public int addSalesHistory(SalesHistory salesHistory) {
        return  salesHistoryMapper.insert(salesHistory);
    }

    @Override
    public int deleteSalesHistory(int id) {
        return salesHistoryMapper.deleteById(id);
    }

    @Override
    public int updateSalesHistory(SalesHistory salesHistory) {

        return salesHistoryMapper.updateById(salesHistory);
    }

    @Override
    public SalesHistory selectById(int id) {
        SalesHistory salesHistory = salesHistoryMapper.selectSaleById(id);
        return salesHistory;
    }

    @Override
    public Map queryLikeSalesHistory(int pageNum,int pageSize,SalesHistory salesHistory) {
        //SalesHistory salesHistory = new SalesHistory();
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<SalesHistory> list = salesHistoryMapper.selectSalesHistory(page, salesHistory);
        Map<String, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        return map;
    }

    @Override
    public List<OrderConnectComm> detailList(int id) {
        List<OrderConnectComm> arr=null;
        List<SalesHistory> salesHistories = salesHistoryMapper.selectAbc(id);
        for (SalesHistory salesHistory : salesHistories) {
            List<OrderConnectComm> orderConnectComms = salesHistory.getOrderConnectComms();
            arr=orderConnectComms;
        }
        return arr;
    }


}
