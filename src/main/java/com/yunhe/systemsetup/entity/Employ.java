package com.yunhe.systemsetup.entity;

import java.io.Serializable;
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
public class Employ implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工名
     */
    private String emUsername;

    /**
     * 真实姓名
     */
    private String emRealname;

    /**
     * 员工密码
     */
    private String emPassword;

    /**
     * 角色
     */
    private String emRole;

    /**
     * 性别
     */
    private String emSex;

    /**
     * 电话
     */
    private String emPhone;

    /**
     * 邮箱
     */
    private String emEmail;

    /**
     * 状态
     */
    private String emStatus;

    /**
     * 关联仓库
     */
    private String emRepo;

    /**
     * 价格权限
     */
    private String emShiro;

    /**
     * 查看他人单据
     */
    private String emSelInvoice;

    /**
     * 作废他人单据
     */
    private String emDelInvoice;

    /**
     * 查看他人客户
     */
    private String emSelUser;

    /**
     * 地址
     */
    private String emAddress;


}
