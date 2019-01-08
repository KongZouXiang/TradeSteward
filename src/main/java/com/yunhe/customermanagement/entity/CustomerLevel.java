package com.yunhe.customermanagement.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 客户等级价
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomerLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户级别
     */
    private String clLevel;

    /**
     * 对应等级价
     */
    private String clCorrespondingGrade;

    /**
     * 折扣
     */
    private Integer clDiscount;


}
