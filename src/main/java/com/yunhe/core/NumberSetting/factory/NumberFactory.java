package com.yunhe.core.NumberSetting.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <per>
 *      借入归还单     XSD
 *      进货订单编号   JDD
 *      销售订单编号   XDD
 *      进货单编号     JHD
 *      供应商编号     GYS
 *      客户编号       KH
 *      商品编号       SP
 *      借出归还单     JCD
 *      商品模板       MB
 *      借入归还单     JRG
 * </per>
 *
 * @author 孔邹祥
 * @date 2019年1月10日
 */
public class NumberFactory {

    public static String data(Integer bh) {
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
        return ft.format(now) + sum(bh);
    }

    public static String sum(Integer i) {
        i++;
        if (i < 9) {
            return "00" + i;
        } else if (i < 99) {
            return "0" + i;
        }
        return "" + i;
    }
}
