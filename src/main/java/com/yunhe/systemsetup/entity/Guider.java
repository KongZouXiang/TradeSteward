package com.yunhe.systemsetup.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 导购员管理
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Guider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String guName;

    /**
     * 备注
     */
    private String guRemark;

    /**
     * 状态
     */
    private Integer guStatus;


}
