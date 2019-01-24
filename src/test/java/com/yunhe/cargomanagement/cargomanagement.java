package com.yunhe.cargomanagement;


import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.entity.CommodityList;
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

