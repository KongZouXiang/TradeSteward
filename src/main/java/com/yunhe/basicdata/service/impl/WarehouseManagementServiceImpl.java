package com.yunhe.basicdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.WarehouseManagement;
import com.yunhe.basicdata.dao.WarehouseManagementMapper;
import com.yunhe.basicdata.service.IWarehouseManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 仓库管理 服务实现类
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Service
public class WarehouseManagementServiceImpl extends ServiceImpl<WarehouseManagementMapper, WarehouseManagement> implements IWarehouseManagementService {
    @Resource
    private WarehouseManagementMapper warehouseManagementMapper;

    @Override
    public Map selectWareList(int pageSize, int pageNum) {
        Page<WarehouseManagement> page = new Page<WarehouseManagement>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        List<WarehouseManagement> list = warehouseManagementMapper.selectWareList(page);
        Map map = new HashMap();
        map.put("pagenum", pageNum);
        map.put("pageSize", pageSize);
        map.put("list", list);
        return map;
    }

    @Override
    public void deleteByid(int id) {

        warehouseManagementMapper.deleteById(id);
    }


    @Override
    public void update(WarehouseManagement warehouseManagemen) {
        warehouseManagementMapper.updateById(warehouseManagemen);
    }

    @Override
    public WarehouseManagement selectByid(int id) {
        return warehouseManagementMapper.selectById(id);
    }

    @Override
    public List<WarehouseManagement> vagueselect1(String data) {

        List<WarehouseManagement> warehouseManagements = (List<WarehouseManagement>) warehouseManagementMapper.selectList(new QueryWrapper<WarehouseManagement>().like("wm_number", data).or().like("wm_person", data).or().like("wm_tel", data)
        );
        return warehouseManagements;
    }
}
