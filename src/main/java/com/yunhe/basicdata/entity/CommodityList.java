package com.yunhe.basicdata.entity;

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
 * 商品列表
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commodity_list")
public class CommodityList implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 商品名称
     */
    @TableField("cl_name")
    private String clName;

    /**
     * 基本单位
     */
    @TableField("cl_unit")
    private String clUnit;

    /**
     * 条形码
     */
    @TableField("cl_scan")
    private String clScan;

    /**
     * 规格
     */
    @TableField("cl_spec")
    private String clSpec;

    /**
     * 进货价格
     */
    @TableField("cl_pur_price")
    private String clPurPrice;

    /**
     * 批发价
     */
    @TableField("cl_who_price")
    private String clWhoPrice;

    /**
     * 零售价
     */
    @TableField("cl_tag_prise")
    private String clTagPrise;

    /**
     * 商品分类（外键）
     */
    @TableField("cc_id")
    private Integer ccId;

    /**
     * 仓库（外键）
     */
    @TableField("wm_id")
    private Integer wmId;

    /**
     *属性表(外键)
     */
    private Integer prId;

    /**
     * 商品编号
     */
    @TableField("cl_number")
    private String clNumber;
    /**
     * 最低库存量
     */
    @TableField("cl_minstock")
    private int clMinStock;
    /**
     * 最高库存量
     */
    @TableField("cl_maxstock")
    private int clMAxStock;
    /**
     * 最低零售价
     */
    @TableField("cl_minlingprice")
     private String clMinLingPrice;

}
