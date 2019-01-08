package com.yunhe.basicdata.entity;

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
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌
     */
    private String prBrand;

    /**
     * 产地
     */
    private String prPlace;

    /**
     * 自定义属性
     */
    private String prZidingyi;


}
