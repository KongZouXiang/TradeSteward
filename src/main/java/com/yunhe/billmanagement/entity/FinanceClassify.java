package com.yunhe.billmanagement.entity;

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
 * 收支分类管理表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("finance_classify")
public class FinanceClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 账目类型
     */
    @TableField(value = "fc_type")
    private String fcType;

    /**
     * 账目类别
     */
    @TableField(value = "fc_sort")
    private String fcSort;

    /**
     * 备注
     */
    @TableField(value = "fc_remark")
    private String fcRemark;


}
