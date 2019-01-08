package com.yunhe.basicdata.service.impl;

import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.dao.PropertyMapper;
import com.yunhe.basicdata.service.IPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 属性设置 服务实现类
 * </p>
 *
 * @author 唐凯宽，李恒奎
 * @since 2019-01-05
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements IPropertyService {

}
