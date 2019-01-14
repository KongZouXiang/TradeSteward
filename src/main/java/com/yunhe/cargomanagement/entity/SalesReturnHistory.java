package com.yunhe.cargomanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售退货历史
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalesReturnHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 业务日期
     */
    private String srhDate;

    /**
     * 单据编号
     */
    private String srhNumber;

    /**
     * 关联销售单号
     */
    private String srhConNumber;

    /**
     * 客户名称
     */
    private String srhClient;

    /**
     * 退货商品
     */
    private String srhGoods;

    /**
     * 总计金额
     */
    private Double srhMoney;

    /**
     * 实退金额
     */
    private Double srhRetMoney;

    /**
     * 入库仓库
     */
    private String srhHouse;

    /**
     * 入库状态
     */
    private String srhStatus;

    /**
     * 纸质单据
     */
    private String srhBills;

    /**
     * 制单日期
     */
    private String srhCreateDate;

    /**
     * 其他费用
     */
    private String srhOther;

    /**
     * 结算账户
     */
    private String srhEndComm;

    /**
     * 经手人
     */
    private String srhHander;

    /**
     * 制单人
     */
    private String srhMaker;

    /**
     * 备注
     */
    private String srhRemark;


}
