package com.yunhe.billmanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账户转账表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("account_transfer")
public class AccountTransfer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 转出账户
     */
    @TableField(value = "at_out_account")
    private String atOutAccount;

    /**
     * 转出日期
     */
    @TableField(value = "at_out_time")
    private String atOutTime;

    /**
     * 转入账户
     */
    @TableField(value = "at_into_account")
    private String atIntoAccount;

    /**
     * 到账日期
     */
    @TableField(value = "at_into_time")
    private String atIntoTime;

    /**
     * 金额
     */
    @TableField(value = "at_money")
    private Double atMoney;

    /**
     * 手续费
     */
    @TableField(value = "at_charge")
    private Double atCharge;

    /**
     * 手续费支付方
     */
    @TableField(value = "at_charge_person")
    private String atChargePerson;

    /**
     * 备注
     */
    @TableField(value = "at_person")
    private String atPerson;

    /**
     * 经手人
     */
    @TableField(value = "at_remark")
    private String atRemark;


}
