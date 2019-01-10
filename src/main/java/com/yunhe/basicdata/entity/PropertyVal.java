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
public class PropertyVal {
    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer pvid;
    /**
     * 属性值
     */
    @TableField("propertyvalue")
    private String propertyvalue;
    /**
     * 属性名的外键（）
     */
    @TableField("pnid")
    private Integer pnid;

}
