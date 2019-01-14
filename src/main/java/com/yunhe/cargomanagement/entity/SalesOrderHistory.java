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
 * @author 刘延琦
 * @since 2019-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalesOrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 业务日期
     */
    private String soDate;

    /**
     * 订单编号
     */
    private String soOrderNum;

    /**
     * 处理状态
     */
    private String soStatus;

    /**
     * 审核人
     */
    private String soAuditor;

    /**
     * 客户名称
     */
    private String soClient;

    /**
     * 销售订单商品
     */
    private String soOrderComm;

    /**
     * 销售订单数量
     */
    private Integer soOrderCount;

    /**
     * 折扣金额
     */
    private Double soDiscount;

    /**
     * 总计金额
     */
    private Double soMoney;

    /**
     * 定金
     */
    private Double soEarnest;

    /**
     * 纸质单据
     */
    private String soBills;

    /**
     * 制单日期
     */
    private String soBillDate;

    /**
     * 未转销售数量
     */
    private Integer soSellCount;

    /**
     * 送货日期
     */
    private String soDevlierDate;

    /**
     * 经手人
     */
    private String soHander;

    /**
     * 制单人
     */
    private String soMaker;

    /**
     * 备注
     */
    private String soRemark;


}
