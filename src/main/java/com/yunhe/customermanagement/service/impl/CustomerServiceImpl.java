package com.yunhe.customermanagement.service.impl;

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
import java.util.ArrayList;
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
    public Map sellectAll(int current,int size) {

        Map map = new HashMap();
        Page<Customer> page = new Page(current, size);
        List<Customer> list = customerMapper.sellectAll(page);

        map.put("list",list);
        map.put("current",current);
        map.put("size",size);
        map.put("totalPage", page.getPages());
       // map.put("pages", page.getPages());
        return  map;
    }

    @Override
    public List sellectAllExcel() {
        return customerMapper.sellectAllExcel();
    }


}
