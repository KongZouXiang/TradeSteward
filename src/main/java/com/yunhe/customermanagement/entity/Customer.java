package com.yunhe.customermanagement.entity;

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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String cusNumber;

    /**
     * 公司名
     */
    private String cusCompname;

    /**
     * 应收欠款（元）
     */
    private Double cusMoney;

    /**
     * 联系方式
     */
    private String cusTele;

    /**
     * 联系人
     */
    private String cusName;

    /**
     * 状态
     */
    private Integer cusFlag;

    /**
     * 关联人员
     */
    private String cusConnname;

    /**
     * 地址
     */
    private String cusAddress;

    /**
     * 邮箱
     */
    private String cusEmail;

    /**
     * qq
     */
    private Integer cusQq;

    /**
     * 备注
     */
    private String cusRemarks;


}
