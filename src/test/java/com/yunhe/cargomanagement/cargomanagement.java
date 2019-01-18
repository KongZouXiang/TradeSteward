package com.yunhe.cargomanagement;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.dao.PurchaseReturnHistoryMapper;
import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class cargomanagement {
    @Resource
    private PurchaseReturnHistoryMapper purchaseReturnHistoryMapper;

    @Test
    public void ceshi(){
        PurchaseReturnHistory purchaseReturnHistory = new PurchaseReturnHistory();
        purchaseReturnHistory.setPrhNumber("");
        purchaseReturnHistory.setPrhSupname("");
        Page page = new Page();
        page.setCurrent(1);
        page.setSize(1);
        List<PurchaseReturnHistory> purchaseReturnHistories = purchaseReturnHistoryMapper.selectPurchaseReturnHistoryPage(page, purchaseReturnHistory);
        for (PurchaseReturnHistory returnHistory : purchaseReturnHistories) {
            System.out.println(returnHistory);
        }
    }




}

