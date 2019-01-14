package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.Warehouse;
import com.yunhe.cargomanagement.dao.WarehouseMapper;
import com.yunhe.cargomanagement.service.IWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 库存查询 服务实现类
 * </p>
 *
 * @author 耿旺
 * @since 2019-01-02
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {
    @Resource
    WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> selectExcel() {

        return warehouseMapper.selectAll();

    }

    @Override
    public int insertWareHouse(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    @Override
    public int updateWareHouse(Warehouse warehouse) {

        return warehouseMapper.updateById(warehouse);
    }

    @Override
    public int deleteWareHouese(int id) {
        return warehouseMapper.deleteById(id);
    }

    @Override
    public Warehouse selectWareHouseById(int id) {
        return warehouseMapper.selectById(id);
    }

    @Override
    public Map selectWareHousePage(int current, int size) {
        Map map=new HashMap();
        Page<Warehouse> page=new Page<>(current,size);
        List<Warehouse> list=warehouseMapper.selectAll();
        map.put("list",list);
        map.put("current",current);
        map.put("size",size);
        map.put("totalPage",page.getPages());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总分页数："+page.getPages());
        return map;
    }

}
