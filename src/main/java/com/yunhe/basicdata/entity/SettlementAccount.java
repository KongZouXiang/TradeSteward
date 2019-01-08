package com.yunhe.basicdata.entity;

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
 * 结算帐户
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("settlement_account")
public class SettlementAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    /**
     * 账户名称
     */
    @TableField("sa_name")
    private String saName;

    /**
     * 开户银行
     */
    @TableField("sa_bank")
    private String saBank;

    /**
     * 账户余额
     */
    @TableField("sa_balance")
    private Double saBalance;

    /**
     * 状态（是否启用）
     */
    @TableField("sa_state")
    private Integer saState;
    /**
     * 银行账号
     */
    @TableField("sa_banknumber")
    private String saBankNumber;
    /**
     * 期初余额
     */
    @TableField("sa_beginbalance")
    private String saBeginBalance;
}
