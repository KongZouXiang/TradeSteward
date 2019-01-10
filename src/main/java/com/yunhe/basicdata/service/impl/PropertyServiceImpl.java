package com.yunhe.basicdata.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.dao.PropertyMapper;
import com.yunhe.basicdata.entity.PropertyVal;
import com.yunhe.basicdata.service.IPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private   PropertyMapper propertyMapper;


    @Override
    public Map selectproperty() {

        Map map=new HashMap();
       List<Property> list= propertyMapper.selectproperty();
       List<PropertyVal> list1=propertyMapper.selectproperty1();
       map.put("list",list);
       map.put("list1",list1);
        System.out.println(map);
        return map;
    }

    @Override
    public void addproperty(Property property) {
        propertyMapper.insert(property);
    }

    @Override
    public void deletepropoerty(int id) {
        propertyMapper.deleteById(id);
    }

    @Override
    public void updateproperty(Property property) {
        propertyMapper.updateById(property);
    }
}
