package com.yunhe.basicdata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Commclass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类
     */
    @TableField("cc_default")
    private String ccDefault;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    /**
     * 级别
     */
    @TableField("cc_jibie")
    private int ccJibie;
    /**
     * 所属父级
     */
    @TableField("cc_fuji")
    private int ccFuji;



}
