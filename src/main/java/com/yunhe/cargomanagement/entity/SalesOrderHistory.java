package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 业务日期
     */
    @TableField("so_date")
    private String soDate;

    /**
     * 订单编号
     */
    @TableField("so_order_num")
    private String soOrderNum;

    /**
     * 处理状态
     */
    @TableField("so_status")
    private String soStatus;

    /**
     * 审核人
     */
    @TableField("so_auditor")
    private String soAuditor;

    /**
     * 客户名称
     */
    @TableField("so_client")
    private String soClient;

    /**
     * 销售订单商品
     */
    @TableField("so_order_comm")
    private String soOrderComm;

    /**
     * 销售订单数量
     */
    @TableField("so_ordercount")
    private Integer soOrderCount;

    /**
     * 折扣金额
     */
    @TableField("so_discount")
    private Double soDiscount;

    /**
     * 总计金额
     */
    @TableField("so_money")
    private Double soMoney;

    /**
     * 定金
     */
    @TableField("so_earnest")
    private Double soEarnest;

    /**
     * 纸质单据
     */
    @TableField("so_bills")
    private String soBills;

    /**
     * 制单日期
     */
    @TableField("so_bill_date")
    private String soBillDate;

    /**
     * 未转销售数量
     */
    @TableField("so_sell_count")
    private Integer soSellCount;

    /**
     * 送货日期
     */
    @TableField("so_devlier_date")
    private String soDevlierDate;

    /**
     * 经手人
     */
    @TableField("so_hander")
    private String soHander;

    /**
     * 制单人
     */
    @TableField("so_maker")
    private String soMaker;

    /**
     * 备注
     */
    @TableField("so_remark")
    private String soRemark;

    private List<OrderConnectComm> orderConnectComms;
}
