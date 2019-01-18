package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.cargomanagement.dao.SalesOrderHistoryMapper;
import com.yunhe.cargomanagement.service.ISalesOrderHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售订单历史 服务实现类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-05
 */
@Service
public class SalesOrderHistoryServiceImpl extends ServiceImpl<SalesOrderHistoryMapper, SalesOrderHistory> implements ISalesOrderHistoryService {

    @Resource
    private SalesOrderHistoryMapper salesOrderHistoryMapper;

    @Override
    public Page queryLikeList(Map cond) {
        int pageNum = (int) cond.get("pageNum");
        int pageSize = (int) cond.get("pageSize");
        SalesOrderHistory salesOrderHistory = (SalesOrderHistory) cond.get("salesOrderHistory");
        Page<SalesOrderHistory> page = new Page<SalesOrderHistory>(pageNum,pageSize);
        List<SalesOrderHistory> list = salesOrderHistoryMapper.selectSaleList(page,salesOrderHistory);
        page.setRecords(list);
        return page;
    }

    @Override
    public int updateSale(SalesOrderHistory salesOrderHistory) {

        return salesOrderHistoryMapper.updateSale(salesOrderHistory);
    }

    @Override
    public int deleteById(Serializable id) {
        return salesOrderHistoryMapper.deleteById(id);
    }

    @Override
    public int insertSale(SalesOrderHistory salesOrderHistory) {
        return salesOrderHistoryMapper.insert(salesOrderHistory);
    }

    @Override
    public SalesOrderHistory selectById(int id) {
        SalesOrderHistory sale = salesOrderHistoryMapper.selectSaleById(id);
        return sale;
    }

    @Override
    public List<SalesOrderHistory> selectAll() {
        return salesOrderHistoryMapper.selectAll();
    }

    @Override
    public List<OrderConnectComm> detailList(int id) {
       /* ArrayList<CommodityList> commodityLists = new ArrayList<>();
        List<SalesOrderHistory> list = salesOrderHistoryMapper.selectAbc(id);
        for (SalesOrderHistory salesOrderHistory : list) {
            List<OrderConnectComm> orderConnectComms = salesOrderHistory.getOrderConnectComms();
            for (OrderConnectComm comm : orderConnectComms) {
                CommodityList commodityList = comm.getCommodityList();
                commodityLists.add(commodityList);
            }
        }
        return commodityLists;*/
        List<OrderConnectComm> arr=null;
        List<SalesOrderHistory> list = salesOrderHistoryMapper.selectAbc(id);
        for (SalesOrderHistory salesOrderHistory : list) {
            List<OrderConnectComm> orderConnectComms = salesOrderHistory.getOrderConnectComms();
            arr =orderConnectComms;
        }
        return arr;
    }

}
