package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.cargomanagement.entity.SuccOutWarehouse;
import com.yunhe.cargomanagement.dao.SuccOutWarehouseMapper;
import com.yunhe.cargomanagement.service.ISuccOutWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 出库单 服务实现类
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Service
public class SuccOutWarehouseServiceImpl extends ServiceImpl<SuccOutWarehouseMapper, SuccOutWarehouse> implements ISuccOutWarehouseService {

    @Resource
     private SuccOutWarehouseMapper succOutWarehouseMapper;


    @Override
    public int insertSuccOutWarehouse(SuccOutWarehouse succOutWarehouse) {

        return succOutWarehouseMapper.insert(succOutWarehouse);
    }

    @Override
    public int deleteSuccOutWarehouse(int id) {

        return succOutWarehouseMapper.deleteById(id);
    }

    @Override
    public int updateSuccOutWarehouse(SuccOutWarehouse succOutWarehouse) {
        succOutWarehouseMapper.updateById(succOutWarehouse);
        return 0;
    }

    @Override
    public Map queryLikeSuccOutWarehouse(int pageSize, int pageNum, SuccOutWarehouse succOutWarehouse) {
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<SuccOutWarehouse> list = succOutWarehouseMapper.queryLikeSuccOutWarehouse(page, succOutWarehouse);
        Map<String, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("list",list);
        return map;
    }
}
