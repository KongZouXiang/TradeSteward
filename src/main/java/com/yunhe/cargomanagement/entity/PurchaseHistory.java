package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进货历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PurchaseHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务日期
     */
    private String phDate;

    /**
     * 单据编号
     */
    private String phNumber;

    /**
     * 供应商名称
     */
    private String phSupname;

    /**
     * 进货商品
     */
    private String phClname;

    /**
     * 进货数量
     */
    private Integer phQuantity;

    /**
     *应付金额
     */
    private double phAmountPayable;

    /**
     * 已付金额
     */
    private double phAmountPaid;

    /**
     * 入库仓库
     */
    private String phWarehouse;

    /**
     * 纸质单据
     */
    private String phBill;

    /**
     * 制单日期
     */
    private String phJindate;

    /**
     * 结算账户
     */
    private String phManeyHu;

    /**
     * 经手人
     */
    private String phExperiencedPerson;

    /**
     * 制单人
     */
    private String phSinglePerson;

    /**
     * 其他费用
     */
    private String phOtherExpenses;

    /**
     * 入库状态
     */
    private String phWarehousingStatus;

    /**
     * 备注
     */
    private String phRemarks;


}
