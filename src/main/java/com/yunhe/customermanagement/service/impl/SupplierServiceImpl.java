package com.yunhe.customermanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.customermanagement.dao.SupplierMapper;
import com.yunhe.customermanagement.entity.Supplier;
import com.yunhe.customermanagement.service.ISupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商管理 服务实现类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    SupplierMapper supplierMapper;

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }



    @Override
    public int deleteSupplier(int id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public int insertSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    @Override
    public List<Supplier> selectAllExcel() {
        return supplierMapper.selectAllExcel();
    }

    @Override
    public Map selectAll(int current, int size) {
        Map map = new HashMap();
        Page<Supplier> page = new Page(current,size);
        List<Supplier> list = supplierMapper.selectAll(page);

        map.put("list",list);
        map.put("current",current);
        map.put("size",size);
        map.put("totalPage", page.getPages());

        return map;
    }

    @Override
    public Map selectList() {
        List<Supplier> list = supplierMapper.selectList(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }
}

