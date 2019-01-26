package com.yunhe.billmanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 供应商应付欠款表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FundProviderDebt implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 供应商编号
     */
    private String fpdNumList;

    /**
     * 供应商名称
     */
    private String fpdName;

    /**
     * 联系人
     */
    private String fpdLinkman;

    /**
     * 联系电话
     */
    private String fpdTelephone;

    /**
     * 期初欠款
     */
    private Double fpdBeginDebt;

    /**
     * 增加应付欠款
     */
    private Double fpdAddDebt;

    /**
     * 支付欠款
     */
    private Double fpdPayDebt;

    /**
     * 优惠欠款
     */
    private Double fpdDiscount;

    /**
     * 核销欠款
     */
    private Double fpdOffsetDeb;

    /**
     * 应付欠款
     */
    private Double fpdReceivable;


}
