package com.yunhe.customermanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.dao.CustomerMapper;
import com.yunhe.customermanagement.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.io.Serializable;
import java.util.*;

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
    public int deleteCustomer(int id) {
        return customerMapper.deleteById(id);
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {

        return customerMapper.deleteBatchIds(idList);
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }



    @Override
    public List sellectAllExcel() {
        return customerMapper.sellectAllExcel();
    }


    @Override
    public IPage<Customer> selectPage(int current, int size, Customer customer) {

        return customerMapper.selectPage(new Page<>(current, size),
                new QueryWrapper<Customer>().like("cus_compname", customer.getCusCompname())
                        .or().like("cus_tele", customer.getCusTele()));

    }

    @Override
    public List<Customer> selectCustomer() {
        return customerMapper.selectList(null);
    }


}
