package com.yunhe.core.common.annotion;


import java.lang.annotation.*;

/**
 * <p>
 * 日志注解
 * </P>
 *
 * @author 孔邹祥
 * @date 2019年1月10日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented //生成文档
public @interface WebLog {

    String value() default "";
}
