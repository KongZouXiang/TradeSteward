package com.yunhe.activitymanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品套餐
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MerchandisePackage implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 套餐id
     */

    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    /**
     * 套餐编号
     */
    @TableField(value = "mp_package_number")
    private String mpPackageNumber;

    /**
     * 套餐名称
     */
    @TableField(value = "mp_package_name")
    private String mpPackageName;

    /**
     * 套餐商品
     */
    @TableField(value = "mp_package_goods")
    private String mpPackageGoods;

    /**
     * 备注
     */
    @TableField(value = "mp_remarks")
    private String mpremarks;


}
