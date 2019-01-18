package com.yunhe.customermanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunhe.customermanagement.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户管理 服务类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * <p>
     * 根据id修改用户
     * </p>
     *
     * @param customer 传过来customer对象
     * @return 返回int类型
     */

    int updateCustomer(Customer customer);

    /**
     * <p>
     * 查询并分页
     * </p>
     *
     * @param current  当前页
     * @param size     每页显示的条数
     * @param customer 客户对象
     * @return
     */
    Map selectAllCustomer(int current, int size, Customer customer);

    /**
     * <p>
     * 根据id删除用户
     * </p>
     *
     * @param id 根据id删除用户
     * @return int
     */
    int deleteCustomer(int id);

    /**
     * <p>
     * 插入客户信息
     * </p>
     *
     * @param customer 客户对象
     * @return int
     */
    int insertCustomer(Customer customer);

    /**
     * <p>
     * 查询全部信息并分页
     * </p>
     *
     * @return 客户列表
     */
    Map sellectAll(int current, int size);

    /**
     * <p>
     * excel表格导入导出
     * </p>
     *
     * @return 客户列表
     */
    List sellectAllExcel();

    /**
     * <p>
     *     模糊查询分页
     * </p>
     * @param customer
     * @return 模糊查询分页list
     */
    List<Customer> selectLikeCustomer(Customer customer);

    IPage<Customer> selectPage(int current, int size, Customer customer);
}

