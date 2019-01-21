package com.yunhe.customermanagement.service;

import com.yunhe.customermanagement.entity.CustomerLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户等级价 服务类
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface ICustomerLevelService extends IService<CustomerLevel> {


    /**
     * <p>
     *      查询客户等级价
     * </p>
     *
     * @return 客户等级价列表
     */
    List<CustomerLevel> selectCustomerLevel();
}
