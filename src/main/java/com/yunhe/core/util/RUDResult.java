package com.yunhe.core.util;

/**
 * <p>
 * 增删改查工厂
 * </P>
 *
 * @author 孔邹祥
 * @date 2019年1月22日
 */
public class RUDResult {

    /**
     * <P>
     *     增删改查工厂方法
     * </P>
     * 
     * @param result 对数据库操作CUD返回的结果
     * @param array ResultRule的规则的属性
     * @return 如果＞1 返回成功 ,否则返回失败
     */
    public static String convertString(Integer result, String[] array) {

        if (result > 0) {
            return array[0];
        }
        return array[1];
    }
}
