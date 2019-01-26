package com.yunhe.customermanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.customermanagement.entity.Supplier;

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
     *<p>
     *     查询并分页的dao接口
     *</p>
     * @param page 分页
     * @param supplier 客户
     * @return 供应商列表
     */
    List<Supplier> selectAllSupplier(Page page, Supplier supplier);


    /**
     * <p>
     *     excel表格导入导出
     *</p>
     * @return 供应商列表
     */
    List<Supplier> selectAllExcel();

    /**
     * <p>
     *     查询并分页
     * </p>
     * @param page
     * @return 供应商列表
     */
    List<Supplier> selectAll(Page page);


}
