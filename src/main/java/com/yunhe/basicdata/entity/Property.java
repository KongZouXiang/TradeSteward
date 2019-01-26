package com.yunhe.basicdata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 属性设置
 * </p>
 *
 * @author 唐凯宽,李恒奎
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("property")
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性名的主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 属性名
     */
    @TableField("pr_attributevalue")
    private String prattributevalue;

    /**
     * ID
     */

   /* @TableField("property_value")
    private String propertyvalue;
    *//**
     * 属性名的外键（）
     *//*
    @TableField("pnid")
    private Integer pnid;*/
}
