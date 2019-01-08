package com.yunhe.basicdata.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    private Integer pnid;
    /**
     * 属性名
     */
    @TableField("propertyname")
    private String propertyname;
    /**
     *外表
     */




}
