package com.yunhe.systemsetup.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author heyuji
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("chara_manger")
public class CharaManger implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @TableField("ch_name")
    private String chName;

    /**
     * 角色描述
     */
    @TableField("ch_detail")
    private String chDetail;


}
