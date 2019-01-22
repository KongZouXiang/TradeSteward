package com.yunhe.customermanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yunhe.customermanagement.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;


import java.io.Serializable;
import java.util.Collection;
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
     * 根据id删除用户
     * </p>
     *
     * @param id 根据id删除用户
     * @return int
     */
    int deleteCustomer(int id);

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     * @return 删除成功记录数
     */
    int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);

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
    IPage<Customer> selectPage(int current, int size, Customer customer);

    /**
     * <p>
     *      查询所有客户
     * </p>
     *
     * @return 客户列表
     */
    List<Customer> selectCustomer();
}

