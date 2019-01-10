package com.yunhe.customermanagement.controller;


import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.service.ICustomerService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.*;

/**
 * <p>
 * 客户管理 前端控制器
 * </p>
 *
 * @author 蔡慧鹏
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/customermanagement/customer")
public class CustomerController {

    @Resource
    ICustomerService customerService;

    /**
     * <p>
     *  查询并分页
     * </p>
     *
     * @param current  当前页数
     * @param size     每页显示条数
     * @param customer 模糊查询内容
     * @return total 总条数 pages 总页数 customerList 客户表
     */
    @RequestMapping("/selectAllCustomer")
    @ResponseBody
    public Map selectAllCustomer(int current, int size, Customer customer) {
        return customerService.selectAllCustomer(current, size, customer);
    }


    /**
     * <p>
     *     查询所有
     * </p>
     *
     * @param customer 查询客户
     * @return 客户
     */
    @RequestMapping("/selectCustomer")
    @ResponseBody
    public Customer selectAllCustomer(Customer customer) {
        return customer;
    }


    /**
     *<p>
     *     修改客户信息
     *</p>
     * @param customer 客户
     * @return list页面
     */
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);

        return "list";
    }

    /**
     *<p>
     *     新增用户
     *</p>
     * @param  customer 新增用户
     * @return list页面
     */
    @RequestMapping("/insertCustomer")
    @ResponseBody
    public String insertCustomer(Customer customer){
        customerService.insertCustomer(customer);
        return "list";
    }

    /**
     *<p>
     *     根据id删除客户
     *</p>
     * @param id 根据id删除用户
     * @return list页面
     */
    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public String deleteCustomer(int id) {
        customerService.deleteCustomer(id);
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
        cell.setCellValue("编号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("公司名");
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
        cell.setCellValue("客户状态");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("关联人员");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("地址");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("邮箱");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("qq");
        cell.setCellStyle(style);

        cell = row.createCell(0);
        cell.setCellValue("备注");
        cell.setCellStyle(style);

    }

    @SuppressWarnings({"unchecked","rawtypes"})
    @RequestMapping("getExcel")
    public String getExcel(HttpServletResponse response) throws IOException{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet);
        List<Customer> entities = (List<Customer>) customerService.sellectAll();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据航，并且设置单元格数据
        int rowNum = 1;

        for (Customer customer:entities
             ) {
            HSSFRow row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getCusNumber());
            row.createCell(2).setCellValue(customer.getCusCompname());
            row.createCell(3).setCellValue(customer.getCusMoney());
            row.createCell(4).setCellValue(customer.getCusTele());
            row.createCell(5).setCellValue(customer.getCusName());
            row.createCell(6).setCellValue(customer.getCusFlag());
            row.createCell(7).setCellValue(customer.getCusConnname());
            row.createCell(8).setCellValue(customer.getCusAddress());
            row.createCell(9).setCellValue(customer.getCusEmail());
            row.createCell(10).setCellValue(customer.getCusQq());
            row.createCell(11).setCellValue(customer.getCusRemarks());

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





