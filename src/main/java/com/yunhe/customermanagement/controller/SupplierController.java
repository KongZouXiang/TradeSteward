package com.yunhe.customermanagement.controller;


import com.yunhe.customermanagement.entity.Supplier;
import com.yunhe.customermanagement.service.ISupplierService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 供应商管理 前端控制器
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/customermanagement/supplier")
public class SupplierController {
    @Resource
    ISupplierService supplierService;

    /**
     * <p>
     *查询并分页
     * </p>
     *
     * @param current  当前页数
     * @param size     每页显示条数
     * @param supplier 模糊查询内容
     * @return total 总条数 pages 总页数 supplierList 客户表
     */
    @RequestMapping("/selectAllSupplier")
    @ResponseBody
    public Map selectAllSupplier(int current, int size, Supplier supplier) {
        return supplierService.selectAllSupplier(current, size, supplier);
    }


    /**
     * <p>
     *     查询供应商信息
     * </p>
     * @param supplier 查询供应商
     * @return 供应商对象
     */
    @RequestMapping("/selectSupplier")
    @ResponseBody
    public Supplier selectAllSupplier(Supplier supplier) {
        return supplier;
    }


    /**
     *<p>
     *     修改供应商信息
     *</p>
     * @param supplier 供应商
     * @return list页面
     */
    @RequestMapping("/updateSupplier")
    @ResponseBody
    public String updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);

        return "list";
    }

    /**
     *<p>
     *     新增供应商
     *</p>
     * @param  supplier 新增供应商
     * @return list页面
     */
    @RequestMapping("/insertSupplier")
    @ResponseBody
    public String insertSupplier(Supplier supplier){
        supplierService.insertSupplier(supplier);
        return "list";
    }

    /**
     *<p>
     *    根据id删除供应商
     *</p>
     * @param id 根据id删除
     * @return list页面
     */

    @PostMapping("/deleteSupplier")
    @ResponseBody
    public String deleteSupplier(int id) {
        supplierService.deleteSupplier(id);
        return "list";
    }

    /**
     * <p>
     *     创建表头
     * </p>
     * @param workbook
     * @param sheet
     */
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(2,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("公司名");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("编号");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("应收欠款");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("电话");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("联系人");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("供应商状态");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("关联人员");
        cell.setCellStyle(style);



        cell = row.createCell(8);
        cell.setCellValue("邮箱");
        cell.setCellStyle(style);


        cell = row.createCell(9);
        cell.setCellValue("备注");
        cell.setCellStyle(style);

    }

    @SuppressWarnings({"unchecked","rawtypes"})
    @RequestMapping("getExcel")
    public String getExcel(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("供应商统计表");
        createTitle(workbook,sheet);
        List<Supplier> entities = (List<Supplier>) supplierService.selectAll();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据航，并且设置单元格数据
        int rowNum = 1;

        for (Supplier supplier:entities
        ) {
            HSSFRow row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(supplier.getId());
            row.createCell(1).setCellValue(supplier.getSupCompname());
            row.createCell(2).setCellValue(supplier.getSupNumber());
            row.createCell(3).setCellValue(supplier.getSupMoney());
            row.createCell(4).setCellValue(supplier.getSupTele());
            row.createCell(5).setCellValue(supplier.getSupFlag());
            row.createCell(6).setCellValue(supplier.getSupLinkman());
            row.createCell(7).setCellValue(supplier.getSupConn());
            row.createCell(8).setCellValue(supplier.getSupEmail());
            row.createCell(9).setCellValue(supplier.getSupRemarks());


            rowNum++;

        }

        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition","attachment; filename=customer.xls");
        response.setContentType("application/msexcel");
        workbook.write(output);
        output.close();
        return null;
    }




}
