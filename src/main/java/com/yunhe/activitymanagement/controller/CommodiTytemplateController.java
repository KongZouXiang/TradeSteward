package com.yunhe.activitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import io.swagger.annotations.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品模板 前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Api(value = "套餐管理.商品模板 ", tags = "套餐管理.商品模板 ")
@RestController
@RequestMapping("/activitymanagement/commodi-tytemplate")
public class CommodiTytemplateController {


    @Resource
    ICommodiTytemplateService commodiTytemplateService;


    @GetMapping("MBcommodity")
    public ModelAndView MBcommodity(ModelAndView modelAndView) {
        modelAndView.setViewName("/activitymanagement/MBcommodity-list");
        return modelAndView;
    }


    @RequestMapping("/xinzeng")
    public ModelAndView xinzeng() {
        return new ModelAndView("activitymanagement/addshangpinmoban");
    }

    @ApiOperation(value="增加模板", httpMethod = "POST",notes="根据CommodiTytemplate对象增加用户")

    @ApiImplicitParam(name = "sa", value = "用户详细实体CommodiTytemplate", required = true, dataType = "CommodiTytemplate")
    @PostMapping("insertCt")
    public int insertCt(CommodiTytemplate sa) {
        return commodiTytemplateService.insertCt(sa);
    }

    /**
     * 根据id删除模板信息
     *
     * @return
     */
    @ApiOperation("删除模块信息")
    @ApiImplicitParam(name = "id", value = "模块的ID", dataType = "Integer")

    @RequestMapping("/delete?name=")
    public int delete(int id) {
        return commodiTytemplateService.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/deleteAll")
    public boolean deleteAll(HttpServletRequest request, @RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            commodiTytemplateService.deleteById(id);
        }
        return true;
    }


    /**
     * <p>
     * 修改数据
     * </P>
     *
     * @return 商品模板表：
     */

   /* @RequestMapping("/update")
    public ModelAndView updateCt(CommodiTytemplate commodiTytemplate){
        int i = commodiTytemplateService.updateCt(commodiTytemplate);
        return new ModelAndView("updateCt");
    }*/
    @RequestMapping("/shangpinmoban")
    public ModelAndView shangpinmoban() {
        return new ModelAndView("activitymanagement/shangpinmoban");
    }


    /**
     * <p>
     * 分页
     * </P>
     *
     * @param current 当前页
     * @param size    每页条数
     * @return 商品模板表：分页的结果集合
     */


    @GetMapping("/selectLikePage")
    public IPage selectLikePage(int current, int size, CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateService.selectLikePage(current, size, commodiTytemplate);
    }




    /*

     *//**
     * <P>
     *     查询商品列表数据
     * </P>
     * @param
     *//*
    @RequestMapping("/selectCl")
    public Map selectCl(int current, int size, CommodityList commodityList) {

        return commodityListService.selectAllcommList(current,size,commodityList);
    }*/


    /**
     * excel导出
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/export1")
    public String createExcel(HttpServletResponse response) throws IOException {
        List<CommodiTytemplate> newlist = commodiTytemplateService.selectAll();
        System.out.println("数据行数：" + newlist.size());
        List<Map<String, Object>> colist = new ArrayList();
        for (CommodiTytemplate com : newlist) {

            Map<String, Object> map = new HashMap();
            map.put("id", com.getId());
            map.put("ctTemplateNumber", com.getCtTemplateNumber());
            map.put("ctTytemplateName", com.getCtTytemplateName());
            map.put("ctTemplategoods", com.getCtTemplategoods());
            map.put("ctRemarks", com.getCtRemarks());

            colist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("报表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);

        // 1.生成字体对象
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("新宋体");

        // 2.生成样式对象，这里的设置居中样式和版本有关，我用的poi用HSSFCellStyle.ALIGN_CENTER会报错，所以用下面的
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中样式
        style.setFont(font);
        style.setWrapText(true);
        //*style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式*//

        // 3.单元格应用样式
        cell.setCellStyle(style);

        //设置单元格内容
        cell.setCellValue("报表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容及样式
        HSSFCell cell0 = row2.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("模板id");

        HSSFCell cell1 = row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("模板编号");

        HSSFCell cell2 = row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("模板名称");

        HSSFCell cell3 = row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("模板商品");

        HSSFCell cell17 = row2.createCell(4);
        cell17.setCellStyle(style);
        cell17.setCellValue("备注");

        //单元格宽度自适应
        sheet.autoSizeColumn((short) 3);
        sheet.autoSizeColumn((short) 4);
        sheet.autoSizeColumn((short) 5);

        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < colist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short) 0);
            sheet.autoSizeColumn((short) 1);
            sheet.autoSizeColumn((short) 2);
            //从sheet第三行开始填充数据
            HSSFRow rowx = sheet.createRow(i + 2);
            Map<String, Object> map = colist.get(i);
            CommodiTytemplate ct = new CommodiTytemplate();
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00 = rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((int) map.get("id"));

            HSSFCell cell01 = rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("ctTemplateNumber"));

            HSSFCell cell02 = rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("ctTytemplateName"));

            HSSFCell cell03 = rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("ctTemplategoods"));

            HSSFCell cell04 = rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("ctRemarks"));
        }
        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=commty.xls");//文件名这里可以改
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }
}
