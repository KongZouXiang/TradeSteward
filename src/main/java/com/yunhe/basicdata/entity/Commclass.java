package com.yunhe.basicdata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Commclass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类
     */
    private String ccDefault;


}
