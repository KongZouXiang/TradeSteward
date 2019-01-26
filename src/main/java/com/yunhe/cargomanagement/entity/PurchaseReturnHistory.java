package com.yunhe.cargomanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 进货退货历史
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("purchase_return_history")
public class PurchaseReturnHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 业务日期
     */
    @TableField(value = "prh_date")
    private String prhDate;

    /**
     * 单据编号
     */
    @TableField(value = "prh_number")
    private String prhNumber;


    /**
     * 供应商名称
     */
    @TableField(value = "prh_supname")
    private String prhSupname;

    /**
     * 退货商品
     */
    @TableField(value = "prh_returnsup")
    private String prhReturnsup;

    /**
     * 总计金额
     */
    @TableField(value = "prh_total_amount")
    private Double prhTotalAmount;

    /**
     * 实退金额
     */
    @TableField(value = "prh_refund_amount")
    private Double prhRefundAmount;

    /**
     * 出库仓库
     */
    @TableField(value = "prh_outgoing_warehouse")
    private String prhOutgoingWarehouse;

    /**
     * 纸质单据
     */
    @TableField(value = "prh_bill")
    private String prhBill;

    /**
     * 制单日期
     */
    @TableField(value = "prh_jindate")
    private String prhJindate;

    /**
     * 结算账户
     */
    @TableField(value = "prh_maney_hu")
    private String prhManeyHu;

    /**
     * 经手人
     */
    @TableField(value = "prh_experienced_person")
    private String prhExperiencedPerson;

    /**
     * 制单人
     */
    @TableField(value = "prh_single_person")
    private String prhSinglePerson;

    /**
     * 其他费用
     */
    @TableField(value = "prh_other_expenses")
    private Double prhOtherExpenses;

    /**
     * 出库状态
     */
    @TableField(value = "prh_outgoing_state")
    private String prhOutgoingState;

    /**
     * 备注
     */
    @TableField(value = "prh_remarks")
    private String prhRemarks;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
