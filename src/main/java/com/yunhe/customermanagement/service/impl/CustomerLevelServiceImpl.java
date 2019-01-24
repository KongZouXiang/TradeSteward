package com.yunhe.customermanagement.service.impl;

import com.yunhe.customermanagement.entity.CustomerLevel;
import com.yunhe.customermanagement.dao.CustomerLevelMapper;
import com.yunhe.customermanagement.service.ICustomerLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 客户等级价 服务实现类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Service
public class CustomerLevelServiceImpl extends ServiceImpl<CustomerLevelMapper, CustomerLevel> implements ICustomerLevelService {

    @Resource
    CustomerLevelMapper customerLevelMapper;

    @Override
    public List<CustomerLevel> selectCustomerLevel() {
        return customerLevelMapper.sellectList();
    }
}
