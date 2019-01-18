package com.yunhe.cargomanagement.controller;

import com.yunhe.cargomanagement.entity.WarehouseReceipt;
import com.yunhe.cargomanagement.service.IWarehouseReceiptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: tradesteward
 * @description: 入库历史
 * @author: 史江浩
 * @create: 2019-01-17 16:30
 **/
@RestController
@RequestMapping("/cargomanagement/warehouse-receipt")
public class WarehouseReceiptController {

    @Resource
    private IWarehouseReceiptService warehouseReceiptService;

    /**
     * 分页查询待入库单数据
     * @param pageNum 当前页
     * @param pageSize 每页条数
     * @param warehouseReceipt 入库历史实体类
     * @return 待入库单以及参数数据
     */
    @RequestMapping("/selectwarehouseReceiptPage")
    public Map selectwarehouseReceiptByState(int pageNum, int pageSize, WarehouseReceipt warehouseReceipt){
        Map warehouseReceiptPage = warehouseReceiptService.selectwarehouseReceiptByState(pageNum,pageSize,warehouseReceipt);
        return warehouseReceiptPage;
    }
}
