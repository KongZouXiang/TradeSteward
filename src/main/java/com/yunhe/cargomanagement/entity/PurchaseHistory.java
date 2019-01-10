package com.yunhe.cargomanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("purchase_history")
public class PurchaseHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    /**
     * 业务日期
     */
    @TableField(value = "ph_date")
    private String phDate;

    /**
     * 单据编号
     */
    @TableField(value = "ph_number")
    private String phNumber;

    /**
     * 供应商名称
     */
    @TableField(value = "ph_supname")
    private String phSupname;

    /**
     * 进货商品
     */
    @TableField(value = "ph_clname")
    private String phClname;

    /**
     * 进货数量
     */
    @TableField(value = "ph_quantity")
    private Integer phQuantity;

    /**
     *应付金额
     */
    @TableField(value = "ph_amount_payable")
    private double phAmountPayable;

    /**
     * 已付金额
     */
    @TableField(value = "ph_amount_paid")
    private double phAmountPaid;

    /**
     * 入库仓库
     */
    @TableField(value = "ph_warehouse")
    private String phWarehouse;

    /**
     * 纸质单据
     */
    @TableField(value = "ph_bill")
    private String phBill;

    /**
     * 制单日期
     */
    @TableField(value = "ph_jindate")
    private String phJindate;

    /**
     * 结算账户
     */
    @TableField(value = "ph_maney_hu")
    private String phManeyHu;

    /**
     * 经手人
     */
    @TableField(value = "ph_experienced_person")
    private String phExperiencedPerson;

    /**
     * 制单人
     */
    @TableField(value = "ph_single_person")
    private String phSinglePerson;

    /**
     * 其他费用
     */
    @TableField(value = "ph_other_expenses")
    private String phOtherExpenses;

    /**
     * 入库状态
     */
    @TableField(value = "ph_warehousing_status")
    private String phWarehousingStatus;

    /**
     * 备注
     */
    @TableField(value = "ph_remarks")
    private String phRemarks;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
