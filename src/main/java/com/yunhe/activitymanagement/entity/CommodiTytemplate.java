package com.yunhe.activitymanagement.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品模板表
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commodi_tytemplate")
public class CommodiTytemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板id
     */

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    /**
     * 模板编号
     */
    @TableField(value = "ct_template_number")
    private String ctTemplateNumber;

    /**
     * 模板名称
     */
    @TableField(value = "ct_tytemplate_name")
    private String ctTytemplateName;

    /**
     * 模板商品
     */
    @TableField(value = "ct_templategoods")
    private String ctTemplategoods;

    /**
     * 备注
     */
    @TableField(value = "ct_remarks")
    private String ctRemarks;

   /* @TableField(exist = false)
    private List<Integer> commodityId;
*/
}
