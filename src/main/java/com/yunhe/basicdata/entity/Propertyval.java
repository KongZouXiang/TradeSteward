package com.yunhe.basicdata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 属性值
 * @author 李恒逵 唐凯宽
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("propertyval")
public class Propertyval {
    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 属性值
     */
    @TableField("property_value")
    private String propertyvalue;
    /**
     * 属性名的外键（）
     */
    @TableField("pnid")
    private Integer pnid;


}
