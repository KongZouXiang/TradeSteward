package com.yunhe.customermanagement.dao;


import com.yunhe.customermanagement.entity.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 供应商管理 Mapper 接口
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface SupplierMapper extends BaseMapper<Supplier> {



    /**
     * <p>
     *     excel表格导入导出
     *</p>
     * @return 供应商列表
     */
    List<Supplier> selectAllExcel();



}
