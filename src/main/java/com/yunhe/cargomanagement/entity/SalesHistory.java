package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalesHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id(外键)
     */
    private Integer cusId;

    /**
     * 业务日期
     */
    private String shDate;

    /**
     * 单据编号
     */
    private String shNumber;

    /**
     * 仓库id（外键）
     */
    private Integer waId;

    /**
     * 销售毛利
     */
    private Double shGross;

    /**
     * 总计金额
     */
    private Double shTotalAmount;

    /**
     * 定金
     */
    private Double shEarnestMoney;

    /**
     * 实收金额
     */
    private Double shAmountReceived;

    /**
     * 出库仓库
     */
    private String shWarehouse;

    /**
     * 纸质单据
     */
    private String shBill;


}
