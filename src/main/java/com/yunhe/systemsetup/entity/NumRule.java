package com.yunhe.systemsetup.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 单号规则
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NumRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号类型
     */
    private String numType;

    /**
     * 网页版编号规则
     */
    private String numWeb;

    /**
     * 前缀
     */
    private String numBefore;


}
