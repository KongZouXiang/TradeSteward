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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cargomanagement {


    @Test
    public void text() {
        Date date = new Date();
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMddHHmm");
        String hehe = yyyyMMdd.format( date );
        System.out.println(hehe);
    }


}

