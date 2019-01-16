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
 * 员工管理
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employ")
public class Employ implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;


    /**
     * 员工名
     */
    @TableField("em_username")
    private String emUsername;

    /**
     * 员工密码
     */
    @TableField("em_password")
    private String emPassword;

    /**
     * 真实姓名
     */
    @TableField("em_realname")
    private String emRealname;



    /**
     * 角色
     */
    @TableField("em_role")
    private String emRole;

    /**
     * 性别
     */
    @TableField("em_sex")
    private String emSex;

    /**
     * 电话
     */
    @TableField("em_phone")
    private String emPhone;

    /**
     * 邮箱
     */
    @TableField("em_email")
    private String emEmail;

    /**
     * 状态
     */
    @TableField("em_status")
    private String emStatus;

    /**
     * 关联仓库
     */
    @TableField("em_repo")
    private String emRepo;

    /**
     * 价格权限
     */
    @TableField("em_shiro")
    private String emShiro;

    /**
     * 查看他人单据
     */
    @TableField("em_sel_invoice")
    private String emSelInvoice;

    /**
     * 作废他人单据
     */
    @TableField("em_del_invoice")
    private String emDelInvoice;

    /**
     * 查看他人客户
     */
    @TableField("em_sel_user")
    private String emSelUser;

    /**
     * 地址
     */
    @TableField("em_address")
    private String emAddress;


}
