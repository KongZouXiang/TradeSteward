package com.yunhe.billmanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 欠款详细表
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FundClientDebtDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户名称
     */
    private String fcddFcdName;

    /**
     * 业务日期
     */
    private String fcddDate;

    /**
     * 单据编号
     */
    private String fcddNumList;

    /**
     * 经手人
     */
    private String fcddPerson;

    /**
     * 业务类型
     */
    private String fcddType;

    /**
     * 原单欠款
     */
    private Double fcddBeginDebt;

    /**
     * 收款
     */
    private Double fcddBackDebt;

    /**
     * 优惠
     */
    private Double fcddDiscount;

    /**
     * 结算账户
     */
    private String fcddAccount;

    /**
     * 应收欠款
     */
    private Double fcddReceivable;


}
