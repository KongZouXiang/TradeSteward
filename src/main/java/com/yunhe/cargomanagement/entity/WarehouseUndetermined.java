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
 *  待入库单
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("warehouse_undetermined")
public class WarehouseUndetermined implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 业务日期
     */
    @TableField(value = "wu_date")
    private String wuDate;

    /**
     * 单据编号
     */
    @TableField(value = "wu_number")
    private String wuNumber;

    /**
     * 类型
     */
    @TableField(value = "wu_type")
    private String wuType;

    /**
     * 往来单位
     */
    @TableField(value = "wu_current_unit")
    private String wuCurrentUnit;

    /**
     * 入库仓库
     */
    @TableField(value = "wu_warehouse")
    private String wuWarehouse;

    /**
     * 入库商品
     */
    @TableField(value = "wu_goods_in_storage")
    private String wuGoodsInStorage;

    /**
     * 待入库量
     */
    @TableField(value = "wu_quantity_required")
    private Integer wuQuantityRequired;

    /**
     * 制单日期
     */
    @TableField(value = "wu_jindate")
    private String wuJindate;

    /**
     * 制单人
     */
    @TableField(value = "wu_single_person")
    private String wuSinglePerson;

    /**
     * 经手人
     */
    @TableField(value = "wu_experienced_person")
    private String wuExperiencedPerson;

    /**
     * 状态
     */
    @TableField(value = "wu_warehousing_status")
    private String wuWarehousingStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
