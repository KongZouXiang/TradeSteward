package com.yunhe.cargomanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.yunhe.cargomanagement.entity.Warehouse;
import com.yunhe.cargomanagement.service.IWarehouseService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 库存查询 前端控制器
 * </p>
 *
 * @author  耿旺
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/warehouse")
public class WarehouseController {

    @Resource
    IWarehouseService warehouseService;

    /**
     * <p>
     *  查询所有库存信息并分页
     * </p>
     *
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @return map集合
     */
    @RequestMapping("/getPage")
    @ResponseBody
    public Map selectWareHousePage(int pageNum, int pageSize){
        Map map=new HashMap();
        map=warehouseService.selectWareHousePage(pageNum,pageSize);
        System.out.println("当前页:"+pageNum);
        System.out.println("每页数据:"+pageSize);
        return map;
    }

    @RequestMapping("/getPages")
    @ResponseBody
    public ModelAndView getPage(){

        return new ModelAndView("cargomanagement/warehouse.html");
    }

    /**
     * <p>
     *  模糊查询
     * </p>
     *
     * @param warehouse 实体对象
     * @return list集合
     */

    @RequestMapping("/getWareHouseLike")
    @ResponseBody
    public List<Warehouse> selectWareHouseLike(Warehouse warehouse){

        return warehouseService.selectWareHouseLike(warehouse);
    }


    /**
     * <p>
     *     分页加模糊查询
     * </p>
     *
     * @param pageNum 当前页
     * @param pageSize 每页数据条数
     * @param warehouse 实体对象
     * @return IPage
     */
    @RequestMapping("/selectPage")
    @ResponseBody
    public IPage<Warehouse> selectPage(int pageNum, int pageSize, Warehouse warehouse){

        return warehouseService.selectPage(pageNum,pageSize,warehouse);
    }

    /**
     * <p>
     *     仓库详情
     * </p>
     *
     * @param id 前台传过来的ID
     * @param modelAndView 传到前台的数据
     * @return ModelAndView
     */
    @RequestMapping("selEvent")
    public ModelAndView selEvent(Integer id, Model model){
        Warehouse warehouse = warehouseService.getById(id);
        System.out.println(warehouse);
        model.addAttribute("warehouse",warehouse);
        return new ModelAndView("cargomanagement/selEvent");
    }



    /**
     * <p>
     *  创建表头
     * </p>
     *
     * @param workbook
     * @param sheet
     */
    public void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row=sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(2,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        //设置居中样式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 调用字体样式对象
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("商品编号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("商品名称");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("规格");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("单位");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("可用库存量");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("当前存货");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("待出库量");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("待入库量");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("成本价");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("总金额");
        cell.setCellStyle(style);

    }
    /**
     * <p>
     *     获取excel数据
     * </p>
     *
     * @throws IOException
     */
    @RequestMapping("/getExcel")
    @ResponseBody
    public String getExcel(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook, sheet);
        List<Warehouse> warehouses= warehouseService.selectExcel();

        //设置日期格式
        HSSFCellStyle style=workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for (Warehouse warehouse : warehouses) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(warehouse.getId());
            row.createCell(1).setCellValue(warehouse.getWaNumber());
            row.createCell(2).setCellValue(warehouse.getWaSpName());
            row.createCell(3).setCellValue(warehouse.getWaSpSpecifications());
            row.createCell(4).setCellValue(warehouse.getWaSpCompany());
            row.createCell(5).setCellValue(warehouse.getWaSpLnventory());
            row.createCell(6).setCellValue(warehouse.getWaSpCurrentInventory());
            row.createCell(7).setCellValue(warehouse.getWaSpForout());
            row.createCell(8).setCellValue(warehouse.getWaSpForenter());
            row.createCell(9).setCellValue(warehouse.getWaCost());
            row.createCell(10).setCellValue(warehouse.getWaTotalSum());
            rowNum++;
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition","attachment; filename=warehouse.xls");
        response.setContentType("application/msexcel");
        workbook.write(output);
        output.close();
        return null;
    }

}
