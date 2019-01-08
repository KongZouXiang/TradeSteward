package com.yunhe.billmanagement.entity;

import java.io.Serializable;
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
public class RunningAccounts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务日期
     */
    private String raNumList;

    /**
     * 单据编号
     */
    private String raTime;

    /**
     * 往来单位名称
     */
    private String raCompanyName;

    /**
     * 收支项目名称
     */
    private String raProjectName;

    /**
     * 结算账户
     */
    private String raAccount;

    /**
     * 经手人
     */
    private String raPerson;

    /**
     * 收入
     */
    private Double raIncome;

    /**
     * 支出
     */
    private Double raOutcome;

    /**
     * 当前余额
     */
    private Double raCurrentBalance;


}
