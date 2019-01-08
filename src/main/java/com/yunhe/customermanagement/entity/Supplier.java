package com.yunhe.customermanagement.entity;

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
 * 供应商管理
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 公司名
     */
    @TableField(value = "sup_compname")
    private String supCompname;

    /**
     * 供应商编号
     */
    @TableField(value = "sup_number")
    private String supNumber;

    /**
     * 应付欠款(元)
     */
    @TableField(value = "sup_money")
    private Double supMoney;

    /**
     * 电话
     */
    @TableField(value = "sup_tele")
    private String supTele;

    /**
     * 状态
     */
    @TableField(value = "sup_flag")
    private Integer supFlag;

    /**
     * 联系人
     */
    @TableField(value = "sup_linkman")
    private String supLinkman;

    /**
     * 关联客户
     */
    @TableField(value = "sup_conn")
    private String supConn;

    /**
     * 邮箱
     */
    @TableField(value = "sup_email")
    private String supEmail;

    /**
     * 备注
     */
    @TableField(value = "sup_remarks")
    private String supRemarks;


}