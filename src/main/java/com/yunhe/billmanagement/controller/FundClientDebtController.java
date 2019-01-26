package com.yunhe.billmanagement.controller;
import com.yunhe.billmanagement.entity.FundClientDebt;
import com.yunhe.billmanagement.entity.FundClientDebtDetail;
import com.yunhe.billmanagement.service.IFundClientDebtDetailService;
import com.yunhe.billmanagement.service.IFundClientDebtService;
import com.yunhe.core.common.annotion.WebLog;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * <p>
 * 客户应收欠款表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/fund-client-debt")
public class FundClientDebtController {

    @Resource
    private IFundClientDebtService fundClientDebtService;

    @Resource
    private IFundClientDebtDetailService fundClientDebtDetailService;

    /**
     * <P>
     *    进入客户应收欠款页面
     * </P>
     * @return 进入bill-FundClientDebt.html
     */
    @WebLog("进入客户应收欠款页面")
    @GetMapping("/toFcd")
    public ModelAndView toFcd(HttpSession session){
        Map<String,Object> countList = fundClientDebtService.selectFcdMap();
        session.setAttribute("countList",countList);
        return new ModelAndView("billmanagement/bill-FundClientDebt");
    }
    /**
     * <P>
     *     客户应收欠款表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return 客户应收欠款表：分页的结果集
     */
    @WebLog("进入客户应收欠款页面")
    @RequestMapping(value = "/selectFcdPage",method = RequestMethod.GET)
    public Map selectFcdPage(int current,int size,FundClientDebt fundClientDebt) {
        return fundClientDebtService.selectFcdPage(current,size,fundClientDebt);
    }
    /**
     * <P>
     *    进入增加页面
     * </P>
     * @return 进入FCD_add.html
     */
    @WebLog("进入客户应收欠款增加页面")
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpSession session){
        int id = fundClientDebtDetailService.maxId();
        int maxId = id+1;
        session.setAttribute("maxId",maxId);
        return new ModelAndView("billmanagement/bill-FCD-add");
    }

    /**
     * <P>
     *    进入客户查找页面
     * </P>
     * @return 进入bill-FCD-add-customer.html
     */
    @WebLog("进入客户查找页面")
    @RequestMapping("/selectCustomer")
    public ModelAndView selectCustomer(){
        return new ModelAndView("billmanagement/bill-FCD-add-customer");
    }
    /**
     * <P>
     *    通过id查找该客户是否欠款
     * </P>
     * @return 集合
     */
    @WebLog("查看客户是否欠款")
    @RequestMapping("/selectIdFcdExit")
    public FundClientDebt selectIdFcdExit(String fcdName){
        return fundClientDebtService.selectIdFcdExit(fcdName);
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
            FundClientDebt fundClientDebt = new FundClientDebt();
            fundClientDebt.setFcdBackDebt((Double)map.get("backDebt"));
            fundClientDebt.setFcdBeginDebt((Double)map.get("beginDebt"));
            fundClientDebt.setFcdDiscount((Double)map.get("discount"));
            fundClientDebt.setFcdReceivable((Double)map.get("receivable"));
            fundClientDebt.setFcdName(fundClientDebtDetail.getFcddFcdName());
            int k = fundClientDebtService.updateFcd(fundClientDebt);
            System.out.println(k);
        }
        return i;
    }

    /**
     * <P>
     *     增加数据
     * </P>
     * @param fundClientDebt 新增收款的参数存在一个对象里
     * @return  客户应收欠款表：增加是否成功
     */
    @WebLog("增加欠款")
    @PostMapping("/insertFcd")
    public int insertFcd(FundClientDebt fundClientDebt){
        return fundClientDebtService.insertFcd(fundClientDebt);
    }

    /**
     * <P>
     *    进入客户欠款详情页面
     * </P>
     * @return 进入bill-FCD-detail.html
     */
    @WebLog("进入客户欠款详情页面")
    @RequestMapping("/fcdDetail")
    public ModelAndView fcdDetail(String fcddFcdName,HttpSession session){
        session.setAttribute("fcddFcdName",fcddFcdName);
        Map<String,Object> countList = fundClientDebtDetailService.selectMoneyMapByName(fcddFcdName);
        session.setAttribute("countList",countList);
        return new ModelAndView("billmanagement/bill-FCD-detail");
    }

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @WebLog("Excel导出客户欠款数据")
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<FundClientDebt> newlist = fundClientDebtService.selectFcd();
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(FundClientDebt obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            Map<String,Object> map = new HashMap();
            map.put("id", obj.getId());
            map.put("fcdNumList",obj.getFcdNumList());
            map.put("fcdName",obj.getFcdName());
            map.put("fcdLinkman",obj.getFcdLinkman());
            map.put("fcdTelephone",obj.getFcdTelephone());
            map.put("fcdBeginDebt",obj.getFcdBeginDebt());
            map.put("fcdAddDebt",obj.getFcdAddDebt());
            map.put("fcdBackDebt",obj.getFcdBackDebt());
            map.put("fcdDiscount",obj.getFcdDiscount());
            map.put("fcdOffsetDeb",obj.getFcdOffsetDeb());
            map.put("fcdReceivable",obj.getFcdReceivable());
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
        cell1.setCellValue("客户编号");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("客户名称");

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
        cell6.setCellValue("增加应收欠款(元)\t");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("收回欠款(元)\t");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("优惠(元)\t");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("抵消欠款(元)");

        HSSFCell cell10=row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("应收欠款(元)");
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
            cell01.setCellValue((String) map.get("fcdNumList"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("fcdName"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("fcdLinkman"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("fcdTelephone"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue( (Double) map.get("fcdBeginDebt"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((Double) map.get("fcdAddDebt"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((Double) map.get("fcdBackDebt"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((Double) map.get("fcdDiscount"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((Double) map.get("fcdOffsetDeb"));

            HSSFCell cell010=rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((Double) map.get("fcdReceivable"));
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=Fund-client-debt.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "SUCCESS";
    }
}