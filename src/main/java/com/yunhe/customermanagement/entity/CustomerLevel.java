package com.yunhe.customermanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 客户级别
     */
    @TableField(value ="cl_level")
    private String clLevel;

    /**
     * 对应等级价
     */
    @TableField(value ="cl_corresponding_grade")
    private String clCorrespondingGrade;

    /**
     * 折扣
     */
    @TableField(value ="cl_discount")
    private Integer clDiscount;


}
