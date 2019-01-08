package com.yunhe.customermanagement.controller;


import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.service.ICustomerService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 客户管理 前端控制器
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/customermanagement/customer")
public class CustomerController {

    @Resource
    ICustomerService customerService;

    /**
     * <p>
     *  查询并分页
     * </p>
     *
     * @param current  当前页数
     * @param size     每页显示条数
     * @param customer 模糊查询内容
     * @return total 总条数 pages 总页数 customerList 客户表
     */
    @RequestMapping("/selectAllCustomer")
    @ResponseBody
    public Map selectAllCustomer(int current, int size, Customer customer) {
        return customerService.selectAllCustomer(current, size, customer);
    }


    /**
     * <p>
     *     查询所有
     * </p>
     *
     * @param customer 查询客户
     * @return 客户
     */
    @RequestMapping("/selectCustomer")
    @ResponseBody
    public Customer selectAllCustomer(Customer customer) {
        return customer;
    }


    /**
     *<p>
     *     修改客户信息
     *</p>
     * @param customer 客户
     * @return list页面
     */
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);

        return "list";
    }

    /**
     *<p>
     *     新增用户
     *</p>
     * @param  customer 新增用户
     * @return list页面
     */
    @RequestMapping("/insertCustomer")
    @ResponseBody
    public String insertCustomer(Customer customer){
        customerService.insertCustomer(customer);
        return "list";
    }

    /**
     *<p>
     *     根据id删除客户
     *</p>
     * @param id 根据id删除用户
     * @return list页面
     */
    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public String deleteCustomer(int id) {
        customerService.deleteCustomer(id);
        return "list";
    }
}
