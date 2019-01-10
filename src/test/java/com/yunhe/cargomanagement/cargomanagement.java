package com.yunhe.cargomanagement;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.dao.PurchaseOrderMapper;
import com.yunhe.cargomanagement.dao.SalesOrderHistoryMapper;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.cargomanagement.service.IPurchaseOrderService;
import com.yunhe.cargomanagement.service.impl.SalesOrderHistoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cargomanagement {

    @Resource
    PurchaseOrderMapper purchaseOrderMapper;

    @Resource
    IPurchaseOrderService purchaseOrderService;

    @Resource
    SalesOrderHistoryMapper salesOrderHistoryMapper;

    @Resource
    SalesOrderHistoryServiceImpl salesOrderHistoryService;
    @Test
    public void qq() {
        System.out.println("1");
    }

    @Test
    public void ceshi1(){
        SalesOrderHistory sales = new SalesOrderHistory();
        sales.setId(2);
        sales.setSoClient("yang1");
        int i = salesOrderHistoryService.updateSale(sales);
        System.out.println(i);
        SalesOrderHistory salesOrderHistory = salesOrderHistoryMapper.selectById(2);
        System.out.println(salesOrderHistory);
    }
    @Test
    public void contextLoads() {


        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setPoDate("2019-01-04");
        purchaseOrder.setPoNumber("4156544654");
        purchaseOrder.setPoState(1);
        purchaseOrder.setPoAuditor("老板");
        purchaseOrder.setPoSupName("老板");
        purchaseOrder.setPoClName("大白兔");
        purchaseOrder.setPoQuantityOfPurchase(5);
        purchaseOrder.setPoYingMoney(4.99);
        purchaseOrder.setPoBill("1.jpg");
        purchaseOrder.setPoExperiencedPerson("老板");
        purchaseOrder.setPoSinglePerson("老板");
        purchaseOrder.setPoRemarks("111");
        purchaseOrder.setPoDateOrder("2019-01-04");
        purchaseOrderService.insertPurchaseOrder(purchaseOrder);
        //purchaseOrderMapper.addPurchase(purchaseOrder);
        /*Map<String,Object> map = new HashMap<>();
        Page page = new Page<PurchaseOrder>(1, 1);
        String aa = "";
        map.put("aa",aa);
        map.put("page",page);
        List list = purchaseOrderMapper.getPurchaseByPoNumber(map);

        for (Object o : list) {
            System.out.println(o);
        }*/






        /*Page<PurchaseOrder> page = new Page<PurchaseOrder>(1, 3);
        List<PurchaseOrder> purchaseOrders = purchaseOrderMapper.gerTest(page);
        for (Object o :purchaseOrders ) {
            System.out.println(o);
        }*/

        /**
         * 查
         */
        /*int id=1;
        Map map = new HashMap<>();
        map.put("id",id);
        List list = purchaseOrderMapper.selectByMap(map);

        for (Object o : list) {
            System.out.println(o);
        }*/


        /**
         * 增
         */
        /*PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(3);
        purchaseOrder.setPoDate("2019-01-04");
        purchaseOrder.setPoNumber("JDD20190103002");
        purchaseOrder.setPoState(1);
        purchaseOrder.setPoAuditor("");
        //purchaseOrder.setSupId("1");
        purchaseOrder.setPoClName("大大大啊啊啊啊啊啊啊啊啊");
        purchaseOrder.setPoQuantityOfPurchase(1);
        purchaseOrder.setPoBill("2.jpg");
        purchaseOrder.setPoExperiencedPerson("老板");
        purchaseOrder.setPoSinglePerson("老板");
        purchaseOrder.setPoRemarks("测试");*/

        /*int NumberFactory= purchaseOrderMapper.insert(purchaseOrder);
        System.out.println(NumberFactory);*/


        /**
         * 改
         */
        // purchaseOrderMapper.insert(purchaseOrder);

        //purchaseOrderMapper.deleteById(3);

    }


}

