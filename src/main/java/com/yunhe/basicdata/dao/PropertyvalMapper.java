package com.yunhe.basicdata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.basicdata.entity.Propertyval;

import java.util.List;

/**
 * <p>
 * 属性值 Mapper 接口
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-23
 */
public interface PropertyvalMapper extends BaseMapper<Propertyval> {
List<Propertyval> selectall();

}
