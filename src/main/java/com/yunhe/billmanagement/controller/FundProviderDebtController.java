package com.yunhe.billmanagement.controller;


import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.yunhe.billmanagement.entity.FundProviderDebt;
import com.yunhe.billmanagement.service.IFundClientDebtDetailService;
import com.yunhe.billmanagement.service.IFundProviderDebtService;
import com.yunhe.core.common.annotion.WebLog;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商应付欠款表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/fund_provider_debt")
public class FundProviderDebtController {
    @Resource
    private IFundProviderDebtService fundProviderDebtService;

    @Resource
    private IFundClientDebtDetailService fundClientDebtDetailService;

    /**
     * <P>
     *    进入供应商应付欠款页面
     * </P>
     * @return 进入bill-FundProviderDebt.html
     */
    @WebLog("进入供应商应付欠款页面")
    @RequestMapping("/toFpd")
    public ModelAndView toFpd(HttpSession session){
        Map<String,Object> countList = fundProviderDebtService.selectFpdMap();
        session.setAttribute("countList",countList);
        return new ModelAndView("billmanagement/bill-FundProviderDebt");
    }

    /**
     * <P>
     *     供应商应付欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 供应商应付欠款表：分页的结果集
     */
    @WebLog("查看供应商应付欠款信息")
    @GetMapping("/selectFpdPage")
    public Map selectFpdPage(int current, int size,FundProviderDebt fundProviderDebt) {
        return fundProviderDebtService.selectFpdPage(current,size,fundProviderDebt);
    }

    /**
     * <P>
     *    进入增加页面
     * </P>
     * @return 进入FPD_add.html
     */
    @WebLog("进入供应商欠款增加页面")
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpSession session){
        int id = fundClientDebtDetailService.maxId();
        int maxId = id+1;
        session.setAttribute("maxId",maxId);
        return new ModelAndView("billmanagement/bill-FPD-add");
    }

    /**
     * <P>
     *    进入供应商查找页面
     * </P>
     * @return 进入bill-FCD-add-supplier.html
     */
    @WebLog("进入供应商查找页面")
    @RequestMapping("/selectSupplier")
    public ModelAndView selectSupplier(){
        return new ModelAndView("billmanagement/bill-FPD-add-supplier");
    }
    /**
     * <P>
     *    通过id查找该供应商是否欠款
     * </P>
     * @return 集合
     */
    @WebLog("通过id查找该供应商是否欠款")
    @RequestMapping("/selectIdFpdExit")
    public FundProviderDebt selectIdFpdExit(String fpdName){
        return fundProviderDebtService.selectIdFpdExit(fpdName);
    }
    /**
     * <P>
     *     向欠款详细中添加数据
     * </P>
     * @param fundClientDebtDetail 新增收款的参数存在一个对象里
     * @return  客户应收欠款表：增加是否成功
     */
    @WebLog("向欠款详细中添加数据")
    @RequestMapping("/insertFcdd")
    public boolean insertFcdd(FundClientDebtDetail fundClientDebtDetail){
        boolean i = fundClientDebtDetailService.save(fundClientDebtDetail);
        if (i==true){
            Map<String,Object> map = fundClientDebtDetailService.selectMoneyMapByName(fundClientDebtDetail.getFcddFcdName());
            FundProviderDebt fundProviderDebt = new FundProviderDebt();
            fundProviderDebt.setFpdPayDebt((Double)map.get("backDebt"));
            fundProviderDebt.setFpdBeginDebt((Double)map.get("beginDebt"));
            fundProviderDebt.setFpdDiscount((Double)map.get("discount"));
            fundProviderDebt.setFpdReceivable((Double)map.get("receivable"));
            fundProviderDebt.setFpdName(fundClientDebtDetail.getFcddFcdName());
            int k = fundProviderDebtService.updateFpd(fundProviderDebt);
        }
        return i;
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundProviderDebt 新增付款的参数存在一个对象里
     * @return  供应商应付欠款表：增加是否成功
     */
    @WebLog("增加供应商欠款信息")
    @PostMapping("/insertFpd")
    public int insertFcd(FundProviderDebt fundProviderDebt) {
        return fundProviderDebtService.insertFpd(fundProviderDebt);
    }

    /**
     * <P>
     *    进入付款详情页面
     * </P>
     * @return 进入bill-FPD-detail.html
     */
    @WebLog("进入供应商欠款详情页面")
    @RequestMapping("/fpdDetail")
    public ModelAndView fpdDetail(String fcddFcdName,HttpSession session){
        session.setAttribute("fcddFcdName",fcddFcdName);
        Map<String,Object> countList = fundClientDebtDetailService.selectMoneyMapByName(fcddFcdName);
        session.setAttribute("countList",countList);
        return new ModelAndView("billmanagement/bill-FPD-detail");
    }

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @WebLog("Excel导出供应商欠款信息")
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<FundProviderDebt> newlist = fundProviderDebtService.selectFpd();
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(FundProviderDebt obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            Map<String,Object> map = new HashMap();
            map.put("id", obj.getId());
            map.put("fpdNumList",obj.getFpdNumList());
            map.put("fpdName",obj.getFpdName());
            map.put("fpdLinkman",obj.getFpdLinkman());
            map.put("fpdTelephone",obj.getFpdTelephone());
            map.put("fpdBeginDebt",obj.getFpdBeginDebt());
            map.put("fpdAddDebt",obj.getFpdAddDebt());
            map.put("fpdPayDebt",obj.getFpdPayDebt());
            map.put("fpdDiscount",obj.getFpdDiscount());
            map.put("fpdOffsetDeb",obj.getFpdOffsetDeb());
            map.put("fpdReceivable",obj.getFpdReceivable());
            solist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("报表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);

        // 1.生成字体对象
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("新宋体");

        // 2.生成样式对象，这里的设置居中样式和版本有关，我用的poi用HSSFCellStyle.ALIGN_CENTER会报错，所以用下面的
        HSSFCellStyle style = wb.createCellStyle();
        //设置居中样式
        /*style.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/
        // 调用字体样式对象
        style.setFont(font);
        style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式

        // 3.单元格应用样式
        cell.setCellStyle(style);

        //设置单元格内容
        cell.setCellValue("报表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));

        //在sheet里创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容及样式
        HSSFCell cell0=row2.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("序号");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("供应商编号");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("供应商名称");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("联系人");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("联系电话");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("期初欠款(元)");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("增加应付欠款(元)\t");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("支付欠款(元)\t");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("优惠欠款(元)\t");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("抵消欠款(元)");

        HSSFCell cell10=row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("应付欠款(元)");
        //单元格宽度自适应
        sheet.autoSizeColumn((short)3);
        sheet.autoSizeColumn((short)4);
        sheet.autoSizeColumn((short)5);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        sheet.autoSizeColumn((short)10);
        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < solist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)2);
            //从sheet第三行开始填充数据
            HSSFRow rowx=sheet.createRow(i+2);
            Map<String,Object> map = solist.get(i);
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((Integer) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("fpdNumList"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("fpdName"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("fpdLinkman"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("fpdTelephone"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue( (Double) map.get("fpdBeginDebt"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((Double) map.get("fpdAddDebt"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((Double) map.get("fpdPayDebt"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((Double) map.get("fpdDiscount"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((Double) map.get("fpdOffsetDeb"));

            HSSFCell cell010=rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((Double) map.get("fpdReceivable"));
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=fund_provider_debt.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "SUCCESS";
    }
}
