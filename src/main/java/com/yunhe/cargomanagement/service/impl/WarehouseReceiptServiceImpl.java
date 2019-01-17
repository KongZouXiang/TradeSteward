package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.WarehouseReceiptMapper;
import com.yunhe.cargomanagement.entity.WarehouseReceipt;
import com.yunhe.cargomanagement.service.IWarehouseReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tradesteward
 * @description: 入库历史
 * @author: 史江浩
 * @create: 2019-01-17 16:29
 **/
@Service("warehouseReceiptService")
public class WarehouseReceiptServiceImpl extends ServiceImpl<WarehouseReceiptMapper, WarehouseReceipt> implements IWarehouseReceiptService {

    @Resource
    private WarehouseReceiptMapper warehouseReceiptMapper;

    @Override
    public Map selectwarehouseReceiptByState(int pageNum, int pageSize, WarehouseReceipt warehouseReceipt) {
        Page page = new Page(pageNum,pageSize);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<WarehouseReceipt> list = warehouseReceiptMapper.selectwarehouseReceiptByState(page,warehouseReceipt);

        Map<String, Object> map = new HashMap<>();
        map.put("pages",page.getPages());
        map.put("total",page.getTotal());
        map.put("list",list);
        return map;
    }
}
