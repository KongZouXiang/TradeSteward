package com.yunhe.basicdata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.basicdata.dao.PropertyMapper;
import com.yunhe.basicdata.dao.PropertyvalMapper;
import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.entity.Propertyval;
import com.yunhe.basicdata.service.IPropertyService;
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
    @Resource
    private PropertyvalMapper propertyvalMapper;


    @Override
    public Map selectproperty() {
        Map map=new HashMap();
        List<Property> propertyList= propertyMapper.selectproperty();
        List<Propertyval> propertyvalList= propertyvalMapper.selectall();
        map.put("propertyList",propertyList);
        map.put("propertyvalList",propertyvalList);
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

    @Override
    public List<Map<String, Object>> selectAll() {
        return propertyMapper.selectAll();
    }

    @Override
    public int updatename(Property property) {
        return propertyMapper.updatename(property);

    }

    @Override
    public Property selectbyid(int id) {
        return propertyMapper.selectById(id);
    }

    @Override
    public int insertvalue(Propertyval propertyval) {
        return propertyvalMapper.insert(propertyval);
    }
}
