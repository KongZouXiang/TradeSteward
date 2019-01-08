package com.yunhe.customermanagement.service.impl;

import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.dao.CustomerMapper;
import com.yunhe.customermanagement.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
