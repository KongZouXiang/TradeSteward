package com.yunhe.basicdata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunhe.basicdata.entity.Property;
import com.yunhe.basicdata.entity.Propertyval;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
  public List<Propertyval> selectproperty1();

  /**
   * 连表查询
   * @return
   */
  @Select("SELECT py.id AS id,py.pr_attributevalue AS pinpai,GROUP_CONCAT(se.property_value) AS shuxing FROM property py, (SELECT pp.id, pp.pr_attributevalue,pv.property_value FROM property pp LEFT JOIN propertyval pv ON pp.id = pv.`pnid`) se WHERE py.id = se.id GROUP BY py.id")
  List<Map<String,Object>> selectAll();

  /**
   * 改变属性名
   * @return
   */
  int updatename(Property property);

}
