package com.yunhe.cargomanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 等待出库
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WaitOutWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id" ,type = IdType.AUTO)
    private  Integer id;
    /**
     * 业务日期
     */
    private String woDate;

    /**
     * 单据编号
     */
    private String woNumber;

    /**
     * 类型
     */
    private String woType;

    /**
     * 往来单位名称
     */
    private String woCompany;

    /**
     * 出库仓库
     */
    private String woHouse;

    /**
     * 出库商品
     */
    private String woGoods;

    /**
     * 待出库量
     */
    private Integer woCount;

    /**
     * 制单日期
     */
    private String woCreateDate;

    /**
     * 经手人
     */
    private String woHander;

    /**
     * 制单人
     */
    private String woMaker;

    /**
     * 状态
     */
    private String woStatus;


}
