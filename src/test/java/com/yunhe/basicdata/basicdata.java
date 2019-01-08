package com.yunhe.basicdata;

import com.yunhe.basicdata.entity.WarehouseManagement;
import com.yunhe.basicdata.service.impl.WarehouseManagementServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class basicdata {
    @Resource
    private WarehouseManagementServiceImpl warehouseManagementService;
    @Test
    public void contextLoads() {
        WarehouseManagement warehouseManagement = warehouseManagementService.getById(1);
        System.out.println("输出");
        System.out.println(warehouseManagement.getWmAddress());
    }

    public WarehouseManagementServiceImpl getWarehouseManagementService() {
        return warehouseManagementService;
    }

    public void setWarehouseManagementService(WarehouseManagementServiceImpl warehouseManagementService) {
        this.warehouseManagementService = warehouseManagementService;
    }
}

