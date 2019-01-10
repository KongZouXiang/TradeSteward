package com.yunhe.core.constant;

import com.yunhe.core.factory.NumberFactory;

/**
 * Demo class
 *
 * @author 孔邹祥
 * @date 2016/10/31
 */
public class NumberRule extends Number {

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


    public String XSD_NUMBER = "XSD" + NumberFactory.data(XSD);

    public String JDD_NUMBER = "JDD" + NumberFactory.data(JDD);

    public String XDD_NUMBER = "XDD" + NumberFactory.data(XDD);

    public String XDD_NUMBER = "XSD" + NumberFactory.data(XDD);

    public String JHD_NUMBER = "XSD" + NumberFactory.data(JHD);

    public String GYS_NUMBER = "XSD" + NumberFactory.data(GYS);

    public String KH_NUMBER = "XSD" + NumberFactory.data(KH);

    public String SP_NUMBER = "XSD" + NumberFactory.data(SP);

    public String JCG_NUMBER = "XSD" + NumberFactory.data(JCG);

    public String MB_NUMBER = "XSD" + NumberFactory.data(MB);

    public String JRG_NUMBER = "JRG" + NumberFactory.data(JRG);



}
