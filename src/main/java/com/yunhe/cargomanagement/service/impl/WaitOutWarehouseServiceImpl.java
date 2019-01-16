package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.yunhe.cargomanagement.dao.WaitOutWarehouseMapper;
import com.yunhe.cargomanagement.service.IWaitOutWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 等待出库 服务实现类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Service
public class WaitOutWarehouseServiceImpl extends ServiceImpl<WaitOutWarehouseMapper, WaitOutWarehouse> implements IWaitOutWarehouseService {

    @Resource
    private WaitOutWarehouseMapper waitOutWarehouseMapper;
    @Override
    public int insertWaitOutWarehouse(WaitOutWarehouse waitOutWarehouse) {
        return waitOutWarehouseMapper.insert(waitOutWarehouse);
    }

    @Override
    public int deleteWaitOutWarehouse(int id) {
        return waitOutWarehouseMapper.deleteById(id);
    }

    @Override
    public int updateWaitOutWarehouse(WaitOutWarehouse waitOutWarehouse) {
        return waitOutWarehouseMapper.updateById(waitOutWarehouse);
    }

    @Override
    public Map queryLikeWaitOutWarehouse(int pageSize, int pageNum, WaitOutWarehouse waitOutWarehouse) {
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<WaitOutWarehouse> list = waitOutWarehouseMapper.queryLikeWaitOutWarehouse(page, waitOutWarehouse);
        HashMap<String, Object>  map= new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        return map;
    }
}
