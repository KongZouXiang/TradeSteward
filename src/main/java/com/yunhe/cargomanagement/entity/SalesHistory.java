package com.yunhe.cargomanagement.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售历史
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sales_history")
public class SalesHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 单据编号
     */
    @TableField(value = "sh_date")
    private String shDate;

    /**
     * 业务日期
     */
    @TableField(value = "sh_number")
    private String shNumber;

    /**
     * 关联订单号
     */
    @TableField(value = "sh_connect")
    private String shConnect;

    /**
     * 客户名称
     */
    @TableField(value = "sh_client")
    private String shClient;

    /**
     * 销售商品
     */
    @TableField(value = "sh_sell_goods")
    private String shSellGoods;

    /**
     * 销售数量
     */
    @TableField(value = "sh_sell_count")
    private Double shSellCount;

    /**
     * 折扣金额
     */
    @TableField(value = "sh_discount")
    private Double shDiscount;

    /**
     * 扣除定金
     */
    @TableField(value = "sh_mins")
    private Double shMins;

    /**
     * 销售毛利
     */
    @TableField(value = "sh_profit")
    private Double shProfit;

    /**
     * 总计金额
     */
    @TableField(value = "sh_money")
    private Double shMoney;

    /**
     * 实收金额
     */
    @TableField(value = "sh_true_money")
    private String shTrueMoney;

    /**
     * 出库仓库
     */
    @TableField(value = "sh_house")
    private String shHouse;

    /**
     * 纸质单据
     */
    @TableField(value = "sh_bills")
    private String shBills;

    /**
     * 制单日期
     */

    @TableField(value = "sh_create_date")
    private String shCreateDate;

    /**
     * 送货日期
     */
    @TableField(value = "sh_give_date")
    private String shGiveDate;

    /**
     * 其他费用
     */
    @TableField(value = "sh_other")
    private String shOther;

    /**
     * 结算账户
     */
    @TableField(value = "sh_end_comm")
    private String shEndComm;

    /**
     * 经手人
     */
    @TableField(value = "sh_hander")
    private String shHander;

    /**
     * 制单人
     */
    @TableField(value = "sh_maker")
    private String shMaker;

    /**
     * 销售类型
     */
    @TableField(value = "sh_type")
    private String shType;

    /**
     * 出库状态
     */
    @TableField(value = "sh_status")
    private String shStatus;

    /**
     * 备注
     */
    @TableField(value = "sh_remark")
    private String shRemark;

    private List<OrderConnectComm> orderConnectComms;
}
