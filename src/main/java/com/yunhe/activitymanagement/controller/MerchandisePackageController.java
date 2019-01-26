package com.yunhe.activitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.entity.MerchandisePackage;
import com.yunhe.activitymanagement.service.IMerchandisePackageService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
 * 商品套餐 前端控制器
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/activitymanagement/merchandise-package")
public class MerchandisePackageController {



    @Resource
    private IMerchandisePackageService merchandisePackageService;




    @GetMapping("MBcommodity")
    public ModelAndView MBcommodity(ModelAndView modelAndView) {
        modelAndView.setViewName("/activitymanagement/MBcommodity-list");
        return modelAndView;
    }


    /**
     * 点击提交所有选择商品之后，跳转一个刷新之后的商品模板页面
     * @return
     */





    @RequestMapping("/xinzeng")
    public ModelAndView xinzeng() {
        return new ModelAndView("activitymanagement/addshangpintaocan");
    }

    /**
     * 查询模板详情
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/toDetail")
    public ModelAndView toDetail(int id, HttpSession session){
        System.out.println("toDetail进入controller");
        MerchandisePackage mp = merchandisePackageService.selectById(id);
        session.setAttribute("merchandisepackage",mp);
        return new ModelAndView("activitymanagement/mobanxiangqing");
    }





    public int insertCt(MerchandisePackage sa) {
        return merchandisePackageService.insertCt(sa);
    }


    /**
     * <P>
     *     通过id查找数据，显示详情
     * </P>
     * @param id  查询数据的条件
     * @return 对象
     */
    @GetMapping(value = "/selectById")
    public MerchandisePackage selectById(int id) {
        return merchandisePackageService.selectById(id);
    }

    @RequestMapping("/shangpintaocan")
    public ModelAndView shangpintaocan () {
        return new ModelAndView("activitymanagement/shangpintaocan");
    }


    /**
     * <P>
     *     分页
     * </P>
     * @param current 当前页
     * @param size 每页条数
     * @return  商品模板表：分页的结果集合
     */


    @GetMapping("/selectLikePage")
    public IPage selectLikePage(int current, int size, MerchandisePackage merchandisePackage){
        return merchandisePackageService.selectLikePage(current,size,merchandisePackage);
    }


    /**
     * 根据id删除套餐信息
     * @return
     */
    @RequestMapping("/delete")
    public int delete(int id){
        return merchandisePackageService.deleteById(id);
    }

    /**
     * 批量删除
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/deleteAll")
    public boolean deleteAll(HttpServletRequest request, @RequestBody List<Integer> ids)  {
        for (Integer id : ids) {
            merchandisePackageService.deleteById(id);
        }
        return true;
    }



    /**
     * excel导出
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/export2")
    public String createExcel(HttpServletResponse response) throws IOException {
        List<MerchandisePackage> newlist = merchandisePackageService.selectAll();
        System.out.println("数据行数："+newlist.size());
        List<Map<String,Object>> mplist = new ArrayList();
        for(MerchandisePackage mp:newlist){

            Map<String,Object> map = new HashMap();
            map.put("id", mp.getId());
            map.put("mpPackageNumber",mp.getMpPackageNumber());
            map.put("mpPackageName",mp.getMpPackageName());
            map.put("mpPackageCommodity",mp.getMpPackageCommodity());
            map.put("mpRemarks",mp.getMpRemarks());

            mplist.add(map);
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
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中样式
        style.setFont(font);
        style.setWrapText(true);
        //*style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式*//

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
        cell0.setCellValue("套餐id");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("套餐编号");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("套餐名称");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("套餐商品");

        HSSFCell cell17 = row2.createCell(4);
        cell17.setCellStyle(style);
        cell17.setCellValue("备注");

        //单元格宽度自适应
        sheet.autoSizeColumn((short)3);
        sheet.autoSizeColumn((short)4);
        sheet.autoSizeColumn((short)5);

        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < mplist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)2);
            //从sheet第三行开始填充数据
            HSSFRow rowx=sheet.createRow(i+2);
            Map<String,Object> map = mplist.get(i);
            MerchandisePackage mp = new MerchandisePackage();
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((int) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("mpPackageNumber"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("mpPackageName"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("mpPackageCommodity"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("mpRemarks"));
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=merchand.xls");//文件名这里可以改
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }
}
