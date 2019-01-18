package com.yunhe.cargomanagement;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.cargomanagement.dao.SalesOrderHistoryMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cargomanagement {

/*    @Resource
    private SalesOrderHistoryMapper salesOrderHistoryMapper;
    @Test
    public void text(){
        List<SalesOrderHistory> list = salesOrderHistoryMapper.selectAbc(1);
        for (SalesOrderHistory salesOrderHistory : list) {
            List<OrderConnectComm> orderConnectComms = salesOrderHistory.getOrderConnectComms();
            for (OrderConnectComm comm : orderConnectComms) {
                CommodityList commodityList = comm.getCommodityList();
                System.out.println(commodityList);
            }
        }
    }*/


}

