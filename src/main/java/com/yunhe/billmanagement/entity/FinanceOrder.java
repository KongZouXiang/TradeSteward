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
 * 收支订单管理表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("finance_order")
public class FinanceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 单据编号
     */
    @TableField(value = "fo_num_list")
    private String foNumList;

    /**
     * 业务日期
     */
    @TableField(value = "fo_time")
    private String foTime;


    /**
     * 账目类型id
     */
    @TableField(value = "fc_id")
    private Integer fcId;

    /**
     * 金额
     */
    @TableField(value = "fo_money")
    private Double foMoney;

    /**
     * 收入账户
     */
    @TableField(value = "fo_account")
    private String foAccount;

    /**
     * 经手人
     */
    @TableField(value = "fo_person")
    private String foPerson;

    /**
     * 备注
     */
    @TableField(value = "fo_remark")
    private String foRemark;

    /**
     * 图片附件
     */
    @TableField(value = "fo_image")
    private String foImage;

    /**
     * 收支类型 标志 ： 0代表日常支出，1代表日常收入
     */
    @TableField(value = "fo_flag")
    private String foFlag;

}
