package com.yunhe.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 史江浩
 * @Email: 354461938@qq.com
 * @Describe: 默认
 * @Time: 16:14 2018/12/5
 * @Modified by: 当前日期
 * @Modified on:16:14 ${DATA}
 * @修改描述: 默认
 */

public class DateUtil {

    public static String curr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}
