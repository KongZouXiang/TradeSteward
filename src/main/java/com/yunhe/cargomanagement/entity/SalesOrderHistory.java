package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售订单历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalesOrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品数量
     */
    private Integer soNumber;

    /**
     * 单位
     */
    private String soCompany;

    /**
     * 折扣
     */
    private Integer soDiscount;

    /**
     * 折后单价
     */
    private Double soZUnitPrice;

    /**
     * 总价
     */
    private Double soTotalPrice;

    /**
     * 备注
     */
    private String soRemarks;

    /**
     * 定金
     */
    private Double soEarnestMoney;

    /**
     * 付款方式
     */
    private String soPaymentMethod;

    /**
     * 单据
     */
    private String soBill;

    /**
     * 销售类型
     */
    private String soType;

    /**
     * 用户id（外键）
     */
    private Integer cusId;

    /**
     * 处理状态
     */
    private Integer soState;

    /**
     * 审核人
     */
    private String soAuditor;

    /**
     * 商品id（外键）
     */
    private Integer clId;


}
