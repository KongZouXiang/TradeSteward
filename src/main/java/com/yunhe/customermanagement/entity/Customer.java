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
 * 客户管理
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 编号
     */
    @TableField(value ="cus_number")
    private String cusNumber;

    /**
     * 公司名
     */
    @TableField(value ="cus_compname")
    private String cusCompname;

    /**
     * 应收欠款（元）
     */
    @TableField(value ="cus_money")
    private Double cusMoney;

    /**
     * 联系方式
     */
    @TableField(value ="cus_number")
    private String cusTele;

    /**
     * 联系人
     */
    @TableField(value ="cus_name")
    private String cusName;

    /**
     * 状态
     */
    @TableField(value ="cus_flag")
    private Integer cusFlag;

    /**
     * 关联人员
     */
    @TableField(value ="cus_connname")
    private String cusConnname;

    /**
     * 地址
     */
    @TableField(value ="cus_address")
    private String cusAddress;

    /**
     * 邮箱
     */
    @TableField(value ="cus_email")
    private String cusEmail;

    /**
     * qq
     */
    @TableField(value ="cus_qq")
    private Integer cusQq;

    /**
     * 备注
     */
    @TableField(value ="cus_remarks")
    private String cusRemarks;


}