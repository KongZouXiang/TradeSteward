package com.yunhe.cargomanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 出库单
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SuccOutWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id" ,type = IdType.AUTO)
    private  Integer id;
    /**
     * 业务日期
     */
    private String soDate;

    /**
     * 单据编号
     */
    private String soNumber;

    /**
     * 关联业务单号
     */
    private String soConnNum;

    /**
     * 往来单位名称
     */
    private String soCompany;

    /**
     * 出库仓库
     */
    private String soHouse;

    /**
     * 出库商品
     */
    private String soGoods;

    /**
     * 出库量
     */
    private Integer soCount;

    /**
     * 运费
     */
    private Double soMoney;

    /**
     * 制单日期
     */
    private String soCreateDate;

    /**
     * 关联业务
     */
    private String soOpera;

    /**
     * 物流公司
     */
    private String soLogCom;

    /**
     * 物流单号
     */
    private String soLogNum;

    /**
     * 经手人
     */
    private String soHander;

    /**
     * 制单人
     */
    private String soMaker;

    /**
     * 备注
     */
    private String soRemark;


}
