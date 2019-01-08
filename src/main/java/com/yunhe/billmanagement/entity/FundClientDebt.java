package com.yunhe.billmanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户应收欠款表(ymy)
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("fund_client_debt")
public class FundClientDebt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 客户编号
     */
    @TableField(value = "fcd_num_list")
    private String fcdNumList;

    /**
     * 客户名称
     */
    @TableField(value = "fcd_name")
    private String fcdName;

    /**
     * 联系人
     */
    @TableField(value = "fcd_linkman")
    private String fcdLinkman;

    /**
     * 联系电话
     */
    @TableField(value = "fcd_telephone")
    private String fcdTelephone;

    /**
     * 期初欠款
     */
    @TableField(value = "fcd_begin_debt")
    private Double fcdBeginDebt;

    /**
     * 增加应收欠款
     */
    @TableField(value = "fcd_add_debt")
    private Double fcdAddDebt;

    /**
     * 收回欠款
     */
    @TableField(value = "fcd_back_debt")
    private Double fcdBackDebt;

    /**
     * 优惠
     */
    @TableField(value = "fcd_discount")
    private Double fcdDiscount;

    /**
     * 核销欠款
     */
    @TableField(value = "fcd_offset_deb")
    private Double fcdOffsetDeb;

    /**
     * 应收欠款
     */
    @TableField(value = "fcd_receivable")
    private Double fcdReceivable;


}
