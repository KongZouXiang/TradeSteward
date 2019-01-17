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
 * @program: tradesteward
 * @description: 史江浩
 * @author: 史江浩
 * @create: 2019-01-17 16:12
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("warehouse_receipt")
public class WarehouseReceipt implements Serializable {

    private static final long serialVersionUID = 1L;


    public WarehouseReceipt() {
    }

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 业务日期
     */
    @TableField(value = "wre_date")
    private String wreDate;

    /**
     * 单据编号
     */
    @TableField(value = "wre_number")
    private String wreNumber;

    /**
     * 类型
     */
    @TableField(value = "wre_type")
    private String wreType;

    /**
     * 往来单位名称
     */
    @TableField(value = "wre_current_unit")
    private String wreCurrentUnit;

    /**
     * 入库仓库
     */
    @TableField(value = "wre_warehost_name")
    private String wreWarehostName;

    /**
     * 入库商品
     */
    @TableField(value = "wre_storage")
    private String wreStorage;

    /**
     * 入库量
     */
    @TableField(value = "wre_scheduled_receipt")
    private Integer wreScheduledReceipt;

    /**
     * 制单日期
     */
    @TableField(value = "wre_date_order")
    private String wreDateOrder;

    /**
     * 制单人
     */
    @TableField(value = "wre_single_person")
    private String wreSinglePerson;

    /**
     * 经手人
     */
    @TableField(value = "wre_experienced_person")
    private String wreExperiencedPerson;

    /**
     * 状态
     */
    @TableField(value = "wre_state")
    private String wreState;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
