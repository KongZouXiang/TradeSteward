package com.yunhe.cargomanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("warehouse")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    @TableField("wa_number")
    private String waNumber;

    /**
     * 商品名称
     */
    @TableField("wa_sp_name")
    private String waSpName;

    /**
     * 规格
     */
    @TableField("wa_sp_specifications")
    private String waSpSpecifications;

    /**
     * 单位
     */
    @TableField("wa_sp_company")
    private String waSpCompany;

    /**
     * 可用库存量
     */
    @TableField("wa_sp_lnventory")
    private Integer waSpLnventory;

    /**
     * 当前存货
     */
    @TableField("wa_sp_current_inventory")
    private Integer waSpCurrentInventory;

    /**
     * 待出库量
     */
    @TableField("wa_sp_forout")
    private Integer waSpForout;

    /**
     * 待入库量
     */
    @TableField("wa_sp_forenter")
    private Integer waSpForenter;

    /**
     * 成本价
     */
    @TableField("wa_cost")
    private Double waCost;

    /**
     * 总金额
     */
    @TableField("wa_total_sum")
    private Double waTotalSum;


}
