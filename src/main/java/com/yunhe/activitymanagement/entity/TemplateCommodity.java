package com.yunhe.activitymanagement.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品模板和商品关联表
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("template_commodity")
public class TemplateCommodity extends Model<TemplateCommodity> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品模板ID
     */
    private Integer ctId;

    /**
     * 商品列表ID
     */
    private Integer clId;


}
