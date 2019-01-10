package com.yunhe.customermanagement.service;

import com.yunhe.customermanagement.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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
     *<p>
     *     根据id修改用户
     *</p>
     * @param customer 传过来customer对象
     * @return 返回int类型
     */

    int updateCustomer(Customer customer);

    /**
     *<p>
     *     查询并分页
     *</p>
     * @param current 当前页
     * @param size 每页显示的条数
     * @param customer 客户对象
     * @return
     */
    Map selectAllCustomer(int current, int size, Customer customer);

    /**
     *<p>
     *      根据id删除用户
     *</p>
     * @param id 根据id删除用户
     * @return int
     */
    int deleteCustomer(int id);

    /**
     *<p>
     *     插入客户信息
     *</p>
     * @param customer 客户对象
     * @return int
     */
    int insertCustomer(Customer customer);

    /**
     * <p>
     *     excel表格导入导出
     * </p>
     * @return 客户列表
     */
    List<Customer> sellectAll();


}

