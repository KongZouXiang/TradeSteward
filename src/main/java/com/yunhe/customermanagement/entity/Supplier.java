package com.yunhe.customermanagement.entity;

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
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 公司名
     */
    private String supCompname;

    /**
     * 供应商编号
     */
    private String supNumber;

    /**
     * 应付欠款(元)
     */
    private Double supMoney;

    /**
     * 电话
     */
    private String supTele;

    /**
     * 状态
     */
    private Integer supFlag;

    /**
     * 联系人
     */
    private String supLinkman;

    /**
     * 关联客户
     */
    private String supConn;

    /**
     * 邮箱
     */
    private String supEmail;

    /**
     * 备注
     */
    private String supRemarks;


}
