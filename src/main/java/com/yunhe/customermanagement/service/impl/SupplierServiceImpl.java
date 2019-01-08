package com.yunhe.customermanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.customermanagement.entity.Supplier;
import com.yunhe.customermanagement.dao.SupplierMapper;
import com.yunhe.customermanagement.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public Map selectAllSupplier(int current, int size, Supplier supplier) {
        Page page = new Page(current, size);
        List<Supplier> supplierList =supplierMapper.selectAllSupplier(page, supplier);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("List", supplierList);
        return map;

    }

    @Override
    public int deleteSupplier(int id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public int insertSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }
}

