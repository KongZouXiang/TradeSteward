package com.yunhe.cargomanagement.controller;

import com.yunhe.cargomanagement.entity.WarehouseReceipt;
import com.yunhe.cargomanagement.service.IWarehouseReceiptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @RequestMapping("/warehouse_receipt")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/warehouse_receipt_list");
        return mv;
    }

    /**
     * 分页查询待入库单数据
     *
     * @param pageNum          当前页
     * @param pageSize         每页条数
     * @param warehouseReceipt 入库历史实体类
     * @return 待入库单以及参数数据
     */
    @RequestMapping("/selectwarehouseReceiptPage")
    public Map selectwarehouseReceiptByState(int pageNum, int pageSize, WarehouseReceipt warehouseReceipt) {
        Map warehouseReceiptPage = warehouseReceiptService.selectwarehouseReceiptByState(pageNum, pageSize, warehouseReceipt);
        return warehouseReceiptPage;
    }

    /**
     * 分页查询入库单数据
     *
     * @param pageNum          当前页
     * @param pageSize         每页条数
     * @param warehouseReceipt 入库历史实体类
     * @return 入库单以及参数数据
     */
    @RequestMapping("/selectwarehouseReceiptTwoPage")
    public Map selectwarehouseReceiptTwoByState(int pageNum, int pageSize, WarehouseReceipt warehouseReceipt) {
        Map warehouseReceiptPage = warehouseReceiptService.selectwarehouseReceiptTwoByState(pageNum, pageSize, warehouseReceipt);
        return warehouseReceiptPage;
    }

    /**
     * 根据ID删除入库单
     * @param warehouseReceipt 入库历史实体类
     * @return int
     */
    @RequestMapping("/deletewarehouseReceiptTwoById")
    public int deletewarehouseReceiptTwoById(WarehouseReceipt warehouseReceipt) {
        System.out.println("id"+warehouseReceipt.getId());
        Map map = new HashMap();
        map.put("id",warehouseReceipt.getId());
        map.put("wre_state","全部入库");
        return warehouseReceiptService.deletewarehouseReceiptTwoById(map);
    }

    ;

}
