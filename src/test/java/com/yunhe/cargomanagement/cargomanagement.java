package com.yunhe.cargomanagement;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.cargomanagement.dao.SalesOrderHistoryMapper;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.customermanagement.service.ISupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cargomanagement {

    /*    @Resource
        private SalesOrderHistoryMapper salesOrderHistoryMapper;*/

    @Resource
    CommodityListMapper commodityListMapper;

    @Test
    public void text() {
        List<CommodityList> commodityLists = commodityListMapper.selectComclassList1();
        for (CommodityList commodityList : commodityLists) {
            System.out.println(commodityList);
        }
    }


}

