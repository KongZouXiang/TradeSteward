package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.dao.WaitOutWarehouseMapper;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.yunhe.cargomanagement.service.impl.WaitOutWarehouseServiceImpl;
import com.yunhe.cargomanagement.service.impl.WarehouseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 等待出库 前端控制器
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/wait-out-warehouse")
public class WaitOutWarehouseController {

    @Resource
    private WaitOutWarehouseServiceImpl waitOutWarehouseService;

    @RequestMapping("/tiao")
    private ModelAndView tiao(){
        return new ModelAndView("/cargomanagement/waitOutWarehouse");
    }

    @RequestMapping("/quertLikeListWaitOutWarehouse")
    public Map quertLikeListWaitOutWarehouse(int pageSize, int pageNum, WaitOutWarehouse waitOutWarehouse){
        System.out.println("zoule");
        return waitOutWarehouseService.queryLikeWaitOutWarehouse(pageSize,pageNum,waitOutWarehouse);
    }
}
