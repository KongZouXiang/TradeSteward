package com.yunhe.activitymanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TemplateDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 商品名称
     */
    private String tdName;

    /**
     * 商品编号
     */
    private String tdNumber;

    /**
     * 商品属性
     */
    private String tdProperty;

    /**
     * 数量
     */
    private Integer tdSum;

    /**
     * 单位
     */
    private String tdCompany;

    /**
     * 商品模板id
     */
    private Integer ctId;
}
