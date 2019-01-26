package com.yunhe.cargomanagement;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.cargomanagement.dao.PurchaseOrderMapper;
import com.yunhe.cargomanagement.dao.SalesOrderHistoryMapper;
import com.yunhe.cargomanagement.dao.WarehouseReceiptMapper;
import com.yunhe.cargomanagement.entity.*;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import com.yunhe.cargomanagement.service.IWarehouseReceiptService;
import com.yunhe.core.util.DateUtil;
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
    PurchaseOrderMapper purchaseOrderMapper;

    @Resource
    CommodityListServiceImpl commodityListService;

    @Resource
    private IPurchaseHistoryService purchaseHistoryService;

    @Resource
    private IWarehouseReceiptService warehouseReceiptService;

    @Test
    public void text() {

    }

}

