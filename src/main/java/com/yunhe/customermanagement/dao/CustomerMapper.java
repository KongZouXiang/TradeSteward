package com.yunhe.customermanagement.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.customermanagement.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 客户管理 Mapper 接口
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */

public interface CustomerMapper extends BaseMapper<Customer> {


    /**
     *<p>
     *     查新并分页的dao接口
     *</p>
     * @param page 分页
     * @param customer 客户
     * @return 客户列表
     */
    List<Customer> selectAllCustomer(Page page, Customer customer);

    /**
     * <p>
     *     分页
     *</p>
     * @return 客户列表
     */
    List<Customer> sellectAll(Page page);

/**
 * <p>
 *     导出excel
 *</p>
 * @return 客户列表
 */
List<Customer> sellectAllExcel();
}

