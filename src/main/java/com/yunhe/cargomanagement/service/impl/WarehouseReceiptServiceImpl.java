package com.yunhe.cargomanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.cargomanagement.dao.WarehouseReceiptMapper;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.WarehouseReceipt;
import com.yunhe.cargomanagement.service.IWarehouseReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
        Page page = new Page(pageNum, pageSize);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<WarehouseReceipt> list = warehouseReceiptMapper.selectwarehouseReceiptByState(page, warehouseReceipt);

        Map<String, Object> map = new HashMap<>();
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", list);
        return map;
    }

    @Override
    public Map selectwarehouseReceiptTwoByState(int pageNum, int pageSize, WarehouseReceipt warehouseReceipt) {
        Page page = new Page(pageNum, pageSize);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        List<WarehouseReceipt> list = warehouseReceiptMapper.selectwarehouseReceiptTwoByState(page, warehouseReceipt);

        Map<String, Object> map = new HashMap<>();
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", list);
        return map;
    }

    @Override
    public int deletewarehouseReceiptTwoById(Map warehouseReceipt) {
        return warehouseReceiptMapper.deleteByMap(warehouseReceipt);
    }

    @Override
    public WarehouseReceipt selectWarhouseXiangList(int id) {
        return warehouseReceiptMapper.selectWarhouseXiangList(id);
    }

    @Override
    public WarehouseReceipt selectWarhouseXiangTwoList(int id) {
        return warehouseReceiptMapper.selectWarhouseXiangTwoList(id);
    }

    @Override
    public List<PurComm> selectWarHouseZhong(int id) {
        return warehouseReceiptMapper.selectWarHouseZhong(id);
    }

    @Override
    public int insertWarHouseByHistory(WarehouseReceipt warehouseReceipt) {
        return warehouseReceiptMapper.insert(warehouseReceipt);
    }

    @Override
    public WarehouseReceipt selectWarhouseByNumber(String wreNumber) {
        return warehouseReceiptMapper.selectWarhouseByNumber(wreNumber);
    }

    @Override
    public int updateWareHouseById(String wreState, int id) {
        return warehouseReceiptMapper.updateWareHouseById(wreState,id);
    }
}
