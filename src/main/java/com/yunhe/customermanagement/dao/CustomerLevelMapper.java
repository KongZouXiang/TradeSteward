package com.yunhe.customermanagement.dao;

import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.entity.CustomerLevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 客户等级价 Mapper 接口
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
public interface CustomerLevelMapper extends BaseMapper<CustomerLevel> {
    /**
     * <p>
     *     客户等级价
     *</p>
     * @return 客户等级价列表
     */
    List<CustomerLevel> sellectList();
}
