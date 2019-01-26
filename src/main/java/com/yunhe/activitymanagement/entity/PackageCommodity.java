package com.yunhe.activitymanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PackageCommodity implements Serializable {

    @TableId(value ="id",type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    private String pcName;

    /**
     * 商品编号
     */
    private String pcNumber;

    /**
     * 商品属性
     */
    private String pcProperty;

    /**
     * 数量
     */
    private Integer pcSum;

    /**
     * 单位
     */
    private String pcCompany;

    /**
     * 商品套餐id
     */
    private Integer pcId;

}
