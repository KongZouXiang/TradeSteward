package com.yunhe.customermanagement.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.dao.CustomerMapper;
import com.yunhe.customermanagement.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户管理 服务实现类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    CustomerMapper customerMapper;

    @Override
    public int updateCustomer(Customer customer) {

        return customerMapper.updateById(customer);
    }


    @Override
    public Map selectAllCustomer(int current, int size, Customer customer) {
        Page page = new Page(current, size);
        List<Customer> customerList = customerMapper.selectAllCustomer(page, customer);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("customerList", customerList);
        return map;
    }

    @Override
    public int deleteCustomer(int id) {
        return customerMapper.deleteById(id);
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public List<Customer> sellectAll() {


        return customerMapper.sellectAll();
    }


}
