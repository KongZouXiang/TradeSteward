package com.yunhe.cargomanagement.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesOrderHistory;
import com.yunhe.cargomanagement.service.impl.SalesOrderHistoryServiceImpl;
import com.yunhe.customermanagement.entity.Customer;
import com.yunhe.customermanagement.service.ICustomerService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售订单历史 前端控制器
 * </p>
 *
 * @author lyq
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/sales-order-history")
public class SalesOrderHistoryController {

    @Resource
    private SalesOrderHistoryServiceImpl salesOrderHistoryService;

    @Resource
    ICustomerService customerService;

    /**
     * 新增页面的跳转
     * @return web页面
     */
    @RequestMapping("/ceshi1")
    public ModelAndView ceshi1(){
        return new ModelAndView("cargomanagement/salesOrderHistory-add");
    }

/*    *//**
     * 根据id看详情
     * @param id
     * @return
     *//*
    @RequestMapping("/detailSale")
    public SalesOrderHistory detailSale(int id){
        return salesOrderHistoryService.selectById(id);
    }*/
    /**
     * 查询所有客户
     * @return
     */
    @RequestMapping("/asdfdgh")
    public List<Customer> listCustomer(){
        return customerService.sellectAllExcel();
    }
    public int insertSale(SalesOrderHistory sa){
        return salesOrderHistoryService.insertSale(sa);
    }
    /**
     * 根据id删除销售订单信息
     * @return
     */
    @RequestMapping("/delete")
    public int delete(int id){
        return salesOrderHistoryService.deleteById(id);
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
            salesOrderHistoryService.deleteById(id);
        }
        return true;
    }
    /**
     * 修改页面跳转--根据id获取当前订单的所有信息
     * @param id 销售订单的id
     * @return int 是否成功
     */
    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion){
        System.out.println(id);
        SalesOrderHistory salesOrderHistory = salesOrderHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales",salesOrderHistory);
        return new ModelAndView("/cargomanagement/salesOrderHistory-detail");
    }
    /**
     * 修改销售订单信息
     * @param salesOrderHistory 参数为要修改的订单详情
     * @return
     */
    @RequestMapping("/update")
    public ModelAndView updateSale(SalesOrderHistory salesOrderHistory){
        int i = salesOrderHistoryService.updateSale(salesOrderHistory);
        return new ModelAndView("updateSale");
    }

    /**
     *主页面的页面跳转-分页查询所有销售订单记录
     * @return web页面
     */
    @RequestMapping("/index1")
    public ModelAndView index(){
        return new ModelAndView("/cargomanagement/salesOrderHistory");
    }

  @RequestMapping("/index")
    public ModelAndView index1(){
        return new ModelAndView("/index");
    }


    /**
     * 分页模糊查询销售订单历史
     * @param pageNum
     * @param pageSize
     * @param salesOrderHistory
     * @return
     */
    @RequestMapping("/quertLikeList")
    public Map quertLikeList(int pageNum, int pageSize, SalesOrderHistory salesOrderHistory){
        Map map=new HashMap();
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);
        map.put("salesOrderHistory", salesOrderHistory);
        System.out.println(salesOrderHistory.getSoClient());
        Page page=salesOrderHistoryService.queryLikeList(map);
        map.put("page", page.getRecords());
        map.put("totalPage",page.getPages());
        map.put("total",page.getTotal());
        return map;
    }
    @RequestMapping("/detailList")
    public List<OrderConnectComm> detailList(){
/*        ArrayList<CommodityList> commodityLists = new ArrayList<>();
        List<OrderConnectComm> orderConnectComms = salesOrderHistoryService.detailList(1);
        for (OrderConnectComm orderConnectComm : orderConnectComms) {
            CommodityList commodityList = orderConnectComm.getCommodityList();
            commodityLists.add(commodityList);
        }*/
        return salesOrderHistoryService.detailList(1);
    }
    /**
     * excel导出
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response) throws IOException {
        List<SalesOrderHistory> newlist = salesOrderHistoryService.selectAll();
        System.out.println("数据行数："+newlist.size());
        List<Map<String,Object>> solist = new ArrayList();
        for(SalesOrderHistory sales:newlist){

            Map<String,Object> map = new HashMap();
            map.put("id", sales.getId());
            map.put("soDate",sales.getSoDate());
            map.put("soOrderNum",sales.getSoOrderNum());
            map.put("soStatus",sales.getSoStatus());
            map.put("soAuditor", sales.getSoAuditor());
            map.put("soClient",sales.getSoClient());
            map.put("soOrderComm",sales.getSoOrderComm());
            map.put("soOrderCount",sales.getSoOrderCount());
            map.put("soDiscount",sales.getSoDiscount());
            map.put("soMoney",sales.getSoMoney());
            map.put("soEarnest", sales.getSoEarnest());
            map.put("soBills",sales.getSoBills());
            map.put("soBillDate",sales.getSoBillDate());
            map.put("soSellCount",sales.getSoSellCount());
            map.put("soDevlierDate",sales.getSoDevlierDate());
            map.put("soHander",sales.getSoHander());
            map.put("soMaker",sales.getSoMaker());
            map.put("soRemark",sales.getSoRemark());
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
        cell0.setCellValue("用户id");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("业务日期");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("单据编号");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("处理状态");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("审核人");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("客户名称");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("销售订单商品");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("销售订单数量");

        HSSFCell cell8 = row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("折扣金额");

        HSSFCell cell9 = row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("总计金额");

        HSSFCell cell10 = row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("定金");

        HSSFCell cell11 = row2.createCell(11);
        cell11.setCellStyle(style);
        cell11.setCellValue("纸质单据");

        HSSFCell cell12 = row2.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("制单日期");

        HSSFCell cell13 = row2.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue("未转销售数量");

        HSSFCell cell14 = row2.createCell(14);
        cell14.setCellStyle(style);
        cell14.setCellValue("送货日期");

        HSSFCell cell15 = row2.createCell(15);
        cell15.setCellStyle(style);
        cell15.setCellValue("经手人");

        HSSFCell cell16 = row2.createCell(16);
        cell16.setCellStyle(style);
        cell16.setCellValue("制单人");

        HSSFCell cell17 = row2.createCell(17);
        cell17.setCellStyle(style);
        cell17.setCellValue("备注");

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
            SalesOrderHistory sa = new SalesOrderHistory();
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((int) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("soDate"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("soOrderNum"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("soStatus"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("soAuditor"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((String) map.get("soClient"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("soOrderComm"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((int)map.get("soOrderCount"));

            HSSFCell cell08 = rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((double)map.get("soDiscount"));

            HSSFCell cell09 = rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((double)map.get("soMoney"));

            HSSFCell cell010 = rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((Double) map.get("soEarnest"));

            HSSFCell cell011 = rowx.createCell(11);
            cell011.setCellStyle(style);
            cell011.setCellValue((String) map.get("soBills"));

            HSSFCell cell012 = rowx.createCell(12);
            cell012.setCellStyle(style);
            cell012.setCellValue((String) map.get("soBillDate"));

            HSSFCell cell013 = rowx.createCell(13);
            cell013.setCellStyle(style);
            cell013.setCellValue((int) map.get("soSellCount"));

            HSSFCell cell014 = rowx.createCell(14);
            cell014.setCellStyle(style);
            cell014.setCellValue((String) map.get("soDevlierDate"));

            HSSFCell cell015 = rowx.createCell(15);
            cell015.setCellStyle(style);
            cell015.setCellValue((String) map.get("soHander"));

            HSSFCell cell016 = rowx.createCell(16);
            cell016.setCellStyle(style);
            cell016.setCellValue((String) map.get("soMaker"));

            HSSFCell cell017 = rowx.createCell(17);
            cell017.setCellStyle(style);
            cell017.setCellValue((String) map.get("soRemark"));

        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=user1.xls");//文件名这里可以改
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }
}
