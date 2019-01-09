package com.yunhe.customermanagement.service;

import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商管理 服务类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface ISupplierService extends IService<Supplier> {
    /**
     * <p>
     *根据id修改供应商
     * </p>
     *
     * @param传过来supplier对象
     * @return返回int类型
     */
    int updateSupplier(Supplier supplier);

    /**
     * <p>
     *     查询并分页
     * </p>
     * @param current  当前页
     * @param size     每页显示的条数
     * @param supplier 供应商对象
     * @return
     */
    Map selectAllSupplier(int current, int size, Supplier supplier);

    /**
     * <p>
     *        根据id删除供应商
     *    </p>
     * @param id 传过来id值
     * @return int
     */
    int deleteSupplier(int id);

    /**
     * <p>
     *     插入供应商信息
     * </p>
     * @param supplier 供应商对象
     * @return int
     */
    int insertSupplier(Supplier supplier);



}
