package com.yunhe.basicdata.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.Property;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.basicdata.entity.PropertyVal;

import java.util.List;

/**
 * <p>
 * 属性设置 Mapper 接口
 * </p>
 *
 * @author 唐凯宽，李恒奎
 * @since 2019-01-05
 */
public interface PropertyMapper extends BaseMapper<Property> {
  /**
   * 查询属性列表
   * @return  属性名
   */
  public List<Property> selectproperty();
  /**
   * 查询属性列表
   * @return  属性值
   */
  public List<PropertyVal> selectproperty1();
}
