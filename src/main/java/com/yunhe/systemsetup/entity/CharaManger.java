package com.yunhe.systemsetup.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CharaManger implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String chName;

    /**
     * 角色描述
     */
    private String chDetail;


}
