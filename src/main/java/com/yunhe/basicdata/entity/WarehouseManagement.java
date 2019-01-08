package com.yunhe.basicdata.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 仓库管理
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String wmNumber;

    /**
     * 仓库名称
     */
    private String wmName;

    /**
     * 联系人
     */
    private String wmPerson;

    /**
     * 联系电话
     */
    private String wmTel;

    /**
     * 仓库地址
     */
    private String wmAddress;

    /**
     * 邮编
     */
    private Integer wmPostcode;

    /**
     * 状态
     */
    private Integer wmState;

    /**
     * 备注
     */
    private String wmRemark;


}
