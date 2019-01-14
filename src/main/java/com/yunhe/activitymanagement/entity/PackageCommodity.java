package com.yunhe.activitymanagement.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PackageCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品套餐ID
     */
    private Integer mpId;

    /**
     * 商品列表ID
     */
    private Integer clId;


}
