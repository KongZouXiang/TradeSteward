package com.yunhe.billmanagement.controller;

import com.yunhe.billmanagement.entity.FinanceOrder;
import com.yunhe.billmanagement.service.IFinanceOrderService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * 收支订单管理表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/finance-order")
public class FinanceOrderController {

    @Resource
    private IFinanceOrderService financeOrderService;

    /**
     * <P>
     *    进入日常收支页面
     * </P>
     * @return 进入bill-FinanceOrder.html
     */
    @GetMapping("/toFo")
    public ModelAndView toFo(HttpSession session){
        return new ModelAndView("billmanagement/bill-FinanceOrder");
    }

    /**
     * <P>
     *     日常收支表
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @param financeOrder 日常收支的参数存在一个对象里
     * @return 日常收支表：分页的结果集
     */
    @GetMapping(value = "/selectFoPage")
    public Map selectFoPage(int current, int size,FinanceOrder financeOrder){
        return financeOrderService.selectFoPage(current,size,financeOrder);
    }

    /**
     * <P>
     *     查询数据
     * </P>
     * @return 日常收支表：查询的结果集
     */
    @GetMapping(value = "/selectFo")
    public List<FinanceOrder> selectFo() {
        return financeOrderService.selectFo();
    }

    /**
     * <P>
     *    进入收入增加页面
     * </P>
     * @return 进入FC_add.html
     */
    @RequestMapping("/toAddShou")
    public ModelAndView toAddShou(){
        return new ModelAndView("billmanagement/bill-FO-addShou");
    }

    /**
     * <P>
     *    进入支出增加页面
     * </P>
     * @return 进入bill-FO-addZhi.html
     */
    @RequestMapping("/toAddZhi")
    public ModelAndView toAddZhi(){
        return new ModelAndView("billmanagement/bill-FO-addZhi");
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param financeOrder 将添加的信息存入对象
     * @return  日常收支表：增加是否成功
     */
    @GetMapping("/insertFo")
    public int insertFo(FinanceOrder financeOrder) {
        Map map = new HashMap();
        map.put("financeOrder",financeOrder);
        int i = financeOrderService.insertFo(financeOrder);
        int maxId = financeOrderService.maxId();
        map.put("maxId",maxId);
        return financeOrderService.gaiFo(map);
    }

    /**
     * <P>
     *    进入详情页面
     * </P>
     * @param id 查询详情的id
     * @param session 将传输到前台的数据存在session里
     * @return 进入FO_detail.html
     */
    @RequestMapping("/toDetail")
    public ModelAndView toDetail(int id, HttpSession session){
        FinanceOrder fo = financeOrderService.detailById(id);
        session.setAttribute("financeOrder",fo);
        return new ModelAndView("billmanagement/bill-FO-detail");
    }

    /**
     * <P>
     *     删除数据
     * </P>
     * @param id 通过id删除数据
     * @return  日常收支表：删除是否成功
     */
    @GetMapping(value = "/deleteFo")
    public int deleteFo(int id) {
        return financeOrderService.deleteFo(id);
    }

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response,String foFlag) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<Map<String,Object>> newlist = financeOrderService.selectFoByFlag(foFlag);
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(Map<String,Object> obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            Map<String,Object> map = new HashMap();
            map.put("id", obj.get("oid"));
            map.put("foNumList",obj.get("foNumList"));
            map.put("foTime",obj.get("foTime"));
            map.put("fcType",obj.get("fcType"));
            map.put("foMoney",obj.get("foMoney"));
            map.put("foAccount",obj.get("foAccount"));
            map.put("foPerson",obj.get("foPerson"));
            map.put("foRemark",obj.get("foRemark"));
            map.put("foImage",obj.get("foImage"));
            map.put("foFlag",obj.get("foFlag"));
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
       /* style.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/
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
        cell1.setCellValue("单据编号");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("业务日期");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("账目类型");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("金额");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("收入账户");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("经手人");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("备注");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("图片描述");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("收支");
        //单元格宽度自适应
        sheet.autoSizeColumn((short)3);
        sheet.autoSizeColumn((short)4);
        sheet.autoSizeColumn((short)5);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
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
            cell01.setCellValue((String) map.get("foNumList"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("foTime"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("fcType"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((Double) map.get("foMoney"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue( (String) map.get("foAccount"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("foPerson"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((String) map.get("foRemark"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((String) map.get("foImage"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((String) map.get("foFlag"));
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=finance_order.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "SUCCESS";
    }
}
