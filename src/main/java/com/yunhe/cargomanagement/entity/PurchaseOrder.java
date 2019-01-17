package com.yunhe.cargomanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yunhe.customermanagement.entity.Supplier;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进货订单历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("purchase_order")
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    public PurchaseOrder() {
    }

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 业务日期
     */
    @TableField(value = "po_date")
    private String poDate;

    /**
     * 单据编号
     */
    @TableField(value = "po_number")
    private String poNumber;

    /**
     * 处理状态
     */
    @TableField(value = "po_state")
    private String poState;

    /**
     * 审核人
     */
    @TableField(value = "po_auditor")
    private String poAuditor;

    /**
     * 供应商名称
     */
    @TableField(value = "po_sup_name")
    private String poSupName;

    /**
     * 商品名（多）
     */
    @TableField(value = "po_cl_name")
    private String poClName;

    /**
     * 进货数量
     */
    @TableField(value = "po_quantity_of_purchase")
    private Integer poQuantityOfPurchase;

    /**
     * 应付金额
     */
    @TableField(value = "po_ying_money")
    private double poYingMoney;

    /**
     * 纸质单据
     */
    @TableField(value = "po_bill")
    private String poBill;

    /**
     * 经手人
     */
    @TableField(value = "po_experienced_person")
    private String poExperiencedPerson;

    /**
     * 制单人
     */
    @TableField(value = "po_single_person")
    private String poSinglePerson;

    /**
     * 备注
     */
    @TableField(value = "po_remarks")
    private String poRemarks;

    /**
     * 制单日期
     */
    @TableField(value = "po_date_order")
    private String poDateOrder;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
