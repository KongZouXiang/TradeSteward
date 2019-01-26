package com.yunhe.billmanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资金流水表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("running_accounts")
public class RunningAccounts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 单据编号
     */
    @TableField(value = "ra_num_list")
    private String raNumList;

    /**
     * 业务日期
     */
    @TableField(value = "ra_time")
    private String raTime;

    /**
     * 往来单位名称
     */
    @TableField(value = "ra_company_name")
    private String raCompanyName;

    /**
     * 收支项目名称
     */
    @TableField(value = "ra_project_name")
    private String raProjectName;

    /**
     * 结算账户
     */
    @TableField(value = "ra_account")
    private String raAccount;

    /**
     * 经手人
     */
    @TableField(value = "ra_person")
    private String raPerson;

    /**
     * 收入
     */
    @TableField(value = "ra_income")
    private Double raIncome;

    /**
     * 支出
     */
    @TableField(value = "ra_outcome")
    private Double raOutcome;

    /**
     * 当前余额
     */
    @TableField(value = "ra_current_balance")
    private Double raCurrentBalance;


}
