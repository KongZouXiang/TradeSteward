package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进货退货历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PurchaseReturnHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务日期
     */
    private String prhDate;

    /**
     * 单据编号
     */
    private String prhNumber;

    /**
     * 仓库id(外键)
     */
    private Integer waId;

    /**
     * 供应商id(外键)
     */
    private Integer supId;

    /**
     * 出库仓库
     */
    private String prhWarehouse;

    /**
     * 纸质单据
     */
    private String prhBill;


}
