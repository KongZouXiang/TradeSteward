package com.yunhe.cargomanagement.controller;


import com.yunhe.cargomanagement.entity.Warehouse;
import com.yunhe.cargomanagement.service.IWarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 库存查询 前端控制器
 * </p>
 *
 * @author  耿旺
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/warehouse")
public class WarehouseController {

    @Resource
    IWarehouseService warehouseService;

    /**
     * <p>
     *  查询所有库存信息并分页
     * </p>
     *
     * @param current 当前页
     * @param size 每页显示条数
     * @param warehouse 实体类
     * @return list集合
     */
    @RequestMapping("/getPage")
    @ResponseBody
    public Map selectWareHousePage(int current, int size, Warehouse warehouse){

        return warehouseService.selectWareHousePage(current,size,warehouse);
    }

    @RequestMapping("/selectWareHouse")
    @ResponseBody
    public  Warehouse selectWareHousePage(Warehouse warehouse){

        return warehouse;
    }

}
