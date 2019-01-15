package com.yunhe.billmanagement.controller;

import com.yunhe.billmanagement.entity.FinanceClassify;
import com.yunhe.billmanagement.service.IFinanceClassifyService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * 收支分类管理表(ymy) 前端控制器
 * </p>
 *
 * @author 杨明月
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/billManagement/finance-classify")
public class FinanceClassifyController {

    @Resource
    IFinanceClassifyService financeClassifyService;

    /**
     * <P>
     *    进入首页
     * </P>
     * @return 进入index.html
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex(){
        System.out.println("toIndex进入controller");
        return new ModelAndView("index");
    }

    /**
     * <P>
     *    进入收支分类管理页面
     * </P>
     * @return 进入bill-FinanceClassify.html
     */
    @RequestMapping("/toFc")
    public ModelAndView toFc(HttpSession session){
        List<FinanceClassify> li = financeClassifyService.selectFc();
        session.setAttribute("total",li.size());
        System.out.println("toFc进入controller");
        return new ModelAndView("billmanagement/bill-FinanceClassify");
    }
    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页数
     * @param size 每页条数
     * @return  收支分类管理表：分页的结果集
     */
    @RequestMapping(value = "/selectFcPage",method = RequestMethod.GET)
    public Map selectFcPage(int current, int size, FinanceClassify financeClassify) {
        System.out.println("进入分页的controller");
        return financeClassifyService.selectFcPage(current, size,financeClassify);
    }
    /**
     * <P>
     *     查询数据
     * </P>
     * @return 收支分类管理表：查询的结果集
     */
    @RequestMapping(value = "/selectFc",method = RequestMethod.POST)
    public List<FinanceClassify> selectFc() {
        return financeClassifyService.selectFc();
    }

    /**
     * <P>
     *    进入增加页面
     * </P>
     * @return 进入bill-FC-add.html
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        System.out.println("toadd进入controller");
        return new ModelAndView("billmanagement/bill-FC-add");
    }
    /**
     * <P>
     *     增加数据
     * </P>
     * @param financeClassify 增加的参数放到一个对象
     * @return  收支分类管理表：增加是否成功true or false
     */
    @RequestMapping(value = "/insertFc",method = RequestMethod.GET)
    public int insertFc(FinanceClassify financeClassify) {
        return financeClassifyService.insertFc(financeClassify);
    }

    /**
     * <P>
     *    进入修改页面
     * </P>
     * @param id 要修改的数据的id值
     * @param session 要传到前端的值存在session
     * @return 进入bill-FC-update.html
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(int id, HttpSession session){
        System.out.println("toUpdate进入controller");
        System.out.println("要修改的ID："+id);
        FinanceClassify financeClassify = financeClassifyService.selectFcById(id);
        System.out.println("查询到的要修改的对象："+financeClassify);
        session.setAttribute("financeClassify",financeClassify);
        return new ModelAndView("billmanagement/bill-FC-update");
    }
    /**
     * <P>
     *     修改数据
     * </P>
     * @param financeClassify 修改的参数放到一个对象
     * @return  收支分类管理表：修改是否成功true or false
     */
    @RequestMapping(value = "/updateFc",method = RequestMethod.GET)
    public int updateFc(FinanceClassify financeClassify) {
        System.out.println("修改的内容："+financeClassify);
        return financeClassifyService.updateFc(financeClassify);
    }
    /**
     * <P>
     *     删除数据
     * </P>
     * @param financeClassify 删除的参数放到一个对象
     * @return  收支分类管理表：删除是否成功true or false
     */
    @RequestMapping(value = "/deleteFc",method = RequestMethod.GET)
    public int deleteFc(FinanceClassify financeClassify) {
        return financeClassifyService.deleteFc(financeClassify);
    }

    //导出Excel

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<FinanceClassify> newlist = financeClassifyService.selectFc();
        System.out.println("数据行数："+newlist.size());
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(FinanceClassify obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            System.out.println("FinanceClassify的第一个字段"+obj.getId());
            Map<String,Object> map = new HashMap();
            map.put("id", obj.getId());
            map.put("fcType",obj.getFcType());
            map.put("fcSort",obj.getFcSort());
            map.put("fcRemark",obj.getFcRemark());
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
        /*style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式*/

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
        cell1.setCellValue("账目类型");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("收支类别");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("备注");

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
            cell01.setCellValue((String) map.get("fcType"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("fcSort"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("fcRemark"));

        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=finance_classify.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }

}
