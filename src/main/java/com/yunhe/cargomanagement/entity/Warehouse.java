package com.yunhe.cargomanagement.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 库存查询
 * </p>
 *
 * @author 耿旺
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    private String waNumber;

    /**
     * 商品名称
     */
    private String waSpName;

    /**
     * 规格
     */
    private String waSpSpecifications;

    /**
     * 单位
     */
    private String waSpCompany;

    /**
     * 可用库存量
     */
    private Integer waSpLnventory;

    /**
     * 当前存货
     */
    private Integer waSpCurrentInventory;

    /**
     * 待出库量
     */
    private Integer waSpForout;

    /**
     * 待入库量
     */
    private Integer waSpForenter;

    /**
     * 成本价
     */
    private Double waCost;

    /**
     * 总金额
     */
    private Double waTotalSum;


}
