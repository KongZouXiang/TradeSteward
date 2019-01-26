package com.yunhe.customermanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.yunhe.customermanagement.entity.Supplier;
import com.yunhe.customermanagement.dao.SupplierMapper;
import com.yunhe.customermanagement.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
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
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return supplierMapper.deleteBatchIds(idList);
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
    public IPage<Supplier> selectPage(int current, int size, Supplier supplier) {
        return supplierMapper.selectPage(new Page<>(current, size),
                new QueryWrapper<Supplier>().like("sup_compname", supplier.getSupCompname())
                        .or().like("sup_tele", supplier.getSupTele()).or().like("sup_number",supplier.getSupNumber()));
    }

    @Override
    public Map selectList() {
        List<Supplier> list = supplierMapper.selectList(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    @Override
    public int maxId() {
        return supplierMapper.maxId();
    }
}

