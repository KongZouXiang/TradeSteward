package com.yunhe.cargomanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: projectHouse
 * @ClassName:DateUtil
 * @Author: 刘延琦
 * @CreateTime: 2019-1-24 14:28:03 14:28
 * @Version: 1.0
 */
public class DateUtil {
        static int c=0;
    public static String todayDate(){
        Date date = new Date();
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMddHHmm");
        String hehe = yyyyMMdd.format( date );
        return hehe;
    }
    public static String numberXSD(){
        String a = "XSD";
        String b = DateUtil.todayDate();
        c++;
        return a+b+c;
    }
}
