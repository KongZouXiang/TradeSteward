package com.yunhe.cargomanagement.controller;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.entity.PurchaseOrder;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import com.yunhe.cargomanagement.service.IPurchaseOrderService;
import com.yunhe.core.util.DateUtil;
import com.yunhe.customermanagement.service.ISupplierService;
import org.apache.poi.hssf.usermodel.*;
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
 * 进货订单历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/cargomanagement/purchase-order")
public class PurchaseOrderController {

    @Resource
    private IPurchaseOrderService purchaseOrderService;

    /**
     * 进货历史 业务层
     */
    @Resource
    private IPurchaseHistoryService purchaseHistoryService;
    /**
     * 供应商列表
     */
    @Resource
    private ISupplierService supplierService;

    /**
     * 商品列表
     */
    @Resource
    CommodityListServiceImpl commodityListService;

    @RequestMapping("/Purlist")
    public ModelAndView test22() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/purorder-list");
        return mv;
    }

    @RequestMapping("/puXiang")
    public ModelAndView test33(HttpSession session, int id) {
        PurchaseOrder list = purchaseOrderService.getPurchaseById(id);
        System.out.println("===========================" + list);
        List<PurComm> purComms = purchaseOrderService.selectComZhong(id);
        int jiage = 0;
        int shuliang = 0;
        for (PurComm purComm : purComms) {
            shuliang+=purComm.getPcGeshu();
            jiage += purComm.getPcGeshu() * Integer.parseInt(purComm.getCommodityList().getClPurPrice());
        }
        session.setAttribute("shuliang",shuliang);
        session.setAttribute("jiage",jiage);
        session.setAttribute("poId", id);
        session.setAttribute("model", list);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/Pur_order_select_xiang");
        return mv;
    }


    /**
     * 跳转到进货订单历史页面
     *
     * @return 页面
     */
    @RequestMapping("/Test")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("testgetPage");
        return mv;
    }

    /**
     * 增加进货订单历史页面
     *
     * @return 页面
     */
    @RequestMapping("/addPurchase")
    public ModelAndView getaddPurchase(HttpSession session) {
        String curr = DateUtil.curr();
        String curr2 = curr.replace(" ", "");
        String curr3 = "-";
        String curr4 = curr2.replace(curr3,"");
        String curr5 = ":";
        String curr6 = curr4.replace(curr5,"");
        String curr7 = "ADD"+curr6;
        session.setAttribute("curr",curr7);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/Pur_order-add");
        return mv;
    }

    /**
     * 查询供应商
     *
     * @return 供应商数据
     */
    @RequestMapping("/getSupplieradd")
    public Map getSupplieradd() {
        return supplierService.selectList();
    }


    /**
     * 查询商品
     *
     * @return 商品列表
     */
    @RequestMapping("/getCommodadd")
    public Map getCommodadd() {
        return commodityListService.selectComclassList1();
    }

    /**
     * 进货订单历史分页
     *
     * @param pageNum       前台传当前页
     * @param pageSize      前台传每页条数
     * @param purchaseOrder 进货订单历史数据
     * @return 进货订单历史分页数据  传到前台 ajax接收
     */
    @RequestMapping("/getPage")
    public Map getPurchaseByPoNumber(int pageNum, int pageSize, PurchaseOrder purchaseOrder) {
        System.out.println("供111***" + purchaseOrder.getPoSupName());
        Map purchaseByPoNumber = purchaseOrderService.getPurchaseByPoNumber(pageNum, pageSize, purchaseOrder);
        System.out.println(purchaseByPoNumber);
        return purchaseByPoNumber;
    }

    /**
     * 增加进货订单历史
     *
     * @param purchaseOrder 进货订单历史实体类数据
     */
    @RequestMapping("/addPurchaseGoTo")
    public ModelAndView insertPurchaseOrder(PurchaseOrder purchaseOrder,String[] poClName,int[] QuantityOfPurchase) {
        int a = 0;
        int maney = 0;
        for (String s : poClName) {
            CommodityList list = commodityListService.selectListByClName(s);
            for (int m : QuantityOfPurchase) {
                maney+=Integer.parseInt(list.getClPurPrice())*m;
            }
        }
        for (int s : QuantityOfPurchase) {
            a+=s;
        }
        purchaseOrder.setPoYingMoney(maney);
        purchaseOrder.setPoState("未审核");
        purchaseOrder.setPoSinglePerson("老板");
        purchaseOrder.setPoAuditor("老板");
        purchaseOrder.setPoBill("无");
        purchaseOrder.setPoQuantityOfPurchase(a);
        purchaseOrder.setPoDateOrder(purchaseOrder.getPoDate());
        purchaseOrderService.insertPurchaseOrder(purchaseOrder);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/purorder-list");
        return mv;
    }

    /* *//**
     * 根据id查询进货订单历史 单条数据
     * @param id 进货订单历史表id  前台传的
     * @return
     *//*
    @RequestMapping("/getPuById")
    public List<PurchaseOrder> getPurchaseById(int id){
        List<PurchaseOrder> list = purchaseOrderService.getPurchaseById(id);
        return list;
    }*/

    /**
     * 根据id删除进货订单历史
     *
     * @param id 进货订单历史表id  前台传的
     */
    @RequestMapping("/deletePurchaseById")
    public int deletePurchById(int id) {
        return purchaseOrderService.deleteById(id);
    }

    /**
     * 根据id修改进货订单历史
     *
     * @param purchaseOrder 进货订单历史实体类数据
     */
    @RequestMapping("/updatePurchaseById")
    public void updategetPurchaseById(PurchaseOrder purchaseOrder) {
        System.out.println("*******" + purchaseOrder.getId());
        purchaseOrderService.updategetPurchaseById(purchaseOrder);
    }

    /**
     * 根据id查询进货订单历史并把数据存到session到前台的input中
     *
     * @return 跳转页面
     */
    @RequestMapping("/selectById")
    public ModelAndView selectPurchaseById(int id, HttpSession httpSession) {
        System.out.println("前台传过来的id:" + id);
        PurchaseOrder purchaseOrder = purchaseOrderService.selectById(id);
        httpSession.setAttribute("purchase", purchaseOrder);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/article-add");
        return mv;
    }


    /**
     * 进货订单历史详情
     *
     * @param purchaseOrder 实体类数据
     * @return 历史详情
     */
    @RequestMapping("/selectPuOrder")
    public List<PurComm> selectPuOrder(PurchaseOrder purchaseOrder) {
        List<PurComm> purComms = purchaseOrderService.selectComZhong(purchaseOrder.getId());
        return purComms;
    }


    /**
     * 审核进货订单 并增加进货历史
     *
     * @param purchaseOrder 进货订单
     * @return int
     */
    @RequestMapping("/updateHistState")
    public int updateHistState(PurchaseOrder purchaseOrder) {
        System.out.println("/*/*/*/*/*/*" + purchaseOrder.getId());
        purchaseOrder.setPoState("已审核");
        purchaseOrderService.updateHistStateByid(purchaseOrder);
        System.out.println("aaaaaaaaaaaaaaaaaaa");
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setPhDate(purchaseOrder.getPoDate());
        purchaseHistory.setPhNumber("Y" + purchaseOrder.getPoNumber());
        purchaseHistory.setPhSupname(purchaseOrder.getPoSupName());
        purchaseHistory.setPhClname(purchaseOrder.getPoClName());
        purchaseHistory.setPhQuantity(purchaseOrder.getPoQuantityOfPurchase());
        purchaseHistory.setPhAmountPayable(purchaseOrder.getPoYingMoney());
        purchaseHistory.setPhAmountPaid(purchaseOrder.getPoYingMoney());
        purchaseHistory.setPhWarehouse("默认仓库");
        purchaseHistory.setPhBill(purchaseOrder.getPoBill());
        purchaseHistory.setPhJindate(DateUtil.curr());
        purchaseHistory.setPhManeyHu("现金");
        purchaseHistory.setPhExperiencedPerson(purchaseOrder.getPoExperiencedPerson());
        purchaseHistory.setPhSinglePerson("老板");
        purchaseHistory.setPhOtherExpenses("");
        purchaseHistory.setPhWarehousingStatus("未入库");
        purchaseHistory.setPhRemarks(purchaseOrder.getPoRemarks());
        purchaseHistoryService.insertPurchaseHistory(purchaseHistory);
        return 1;
    }


    /**
     * <p>
     * Excel导出
     * </P>
     *
     * @param response 响应
     * @return Excel导出到本地
     * @throws IOException
     */
    @GetMapping("/puchaseOrderExcel")
    public String createExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<PurchaseOrder> newlist = purchaseOrderService.selectPurchaseOrder();
        System.out.println("数据行数：" + newlist.size());
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String, Object>> solist = new ArrayList();
        for (PurchaseOrder obj : newlist) {
            //每次循环都要重新new一个map，表示不同对象
            System.out.println("FinanceClassify的第一个字段" + obj.getId());
            Map<String, Object> map = new HashMap();
            map.put("id", obj.getId());
            map.put("poDate", obj.getPoDate());
            map.put("poNumber", obj.getPoNumber());
            map.put("poState", obj.getPoState());
            map.put("poAuditor", obj.getPoAuditor());
            map.put("poSupName", obj.getPoSupName());
            map.put("poClName", obj.getPoClName());
            map.put("poQuantityOfPurchase", obj.getPoQuantityOfPurchase());
            map.put("poYingMoney", obj.getPoYingMoney());
            map.put("poBill", obj.getPoBill());
            map.put("poExperiencedPerson", obj.getPoExperiencedPerson());
            map.put("poSinglePerson", obj.getPoSinglePerson());
            map.put("poRemarks", obj.getPoRemarks());
            map.put("poDateOrder", obj.getPoDateOrder());
            solist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("报表1");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列11索 引，可以是0～255之间的任何一个
        /*  System.out.println(1);*/
        HSSFCell cell = row1.createCell(0);


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
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容及样式
        HSSFCell cell0 = row2.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("序号");

        HSSFCell cell1 = row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("业务日期");

        HSSFCell cell2 = row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("单据编号");

        HSSFCell cell3 = row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("处理状态");

        HSSFCell cell4 = row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("审核人");

        HSSFCell cell5 = row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("供应商");

        HSSFCell cell6 = row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("商品");

        HSSFCell cell7 = row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("数量");

        HSSFCell cell8 = row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("应付金额");

        HSSFCell cell9 = row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("单据");

        HSSFCell cell10 = row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("经手人");

        HSSFCell cell11 = row2.createCell(11);
        cell11.setCellStyle(style);
        cell11.setCellValue("制单人");

        HSSFCell cell12 = row2.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("备注");

        HSSFCell cell13 = row2.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue("制单日期");

        //单元格宽度自适应

        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < solist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short) 0);
            sheet.autoSizeColumn((short) 1);
            sheet.autoSizeColumn((short) 2);
            sheet.autoSizeColumn((short) 3);
            sheet.autoSizeColumn((short) 4);
            sheet.autoSizeColumn((short) 5);
            sheet.autoSizeColumn((short) 6);
            sheet.autoSizeColumn((short) 7);
            sheet.autoSizeColumn((short) 8);
            sheet.autoSizeColumn((short) 9);
            sheet.autoSizeColumn((short) 10);
            sheet.autoSizeColumn((short) 11);
            sheet.autoSizeColumn((short) 12);
            sheet.autoSizeColumn((short) 13);
            //从sheet第三行开始填充数据
            HSSFRow rowx = sheet.createRow(i + 2);
            Map<String, Object> map = solist.get(i);
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00 = rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((Integer) map.get("id"));

            HSSFCell cell01 = rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("poDate"));

            HSSFCell cell02 = rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("poNumber"));

            HSSFCell cell03 = rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("poState"));

            HSSFCell cell04 = rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("poAuditor"));

            HSSFCell cell05 = rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((String) map.get("poSupName"));

            HSSFCell cell06 = rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("poClName"));

            HSSFCell cell07 = rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((Integer) map.get("poQuantityOfPurchase"));

            HSSFCell cell08 = rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((double) map.get("poYingMoney"));

            HSSFCell cell09 = rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((String) map.get("poBill"));

            HSSFCell cell010 = rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((String) map.get("poExperiencedPerson"));

            HSSFCell cell011 = rowx.createCell(11);
            cell011.setCellStyle(style);
            cell011.setCellValue((String) map.get("poSinglePerson"));

            HSSFCell cell012 = rowx.createCell(12);
            cell012.setCellStyle(style);
            cell012.setCellValue((String) map.get("poRemarks"));

            HSSFCell cell013 = rowx.createCell(13);
            cell013.setCellStyle(style);
            cell013.setCellValue((String) map.get("poDateOrder"));

        }
        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=PurchaseOrder.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "成功！";
    }


    public IPurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    public void setPurchaseOrderService(IPurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * <p>
     *     销售报表分页控制器  （勿删）
     * </p>
     * @param pageNum 当前页
     * @param pageSize  每页条数
     * @return  分页
     */
    @PostMapping("/selectsaleMap")
    @ResponseBody
    public Map selectsaleMap(int pageNum, int pageSize){
        System.out.println("pageNum:"+pageNum+"pageSize:"+pageSize);
        return purchaseOrderService.selectsaleMap(pageNum, pageSize);
    }
    /**
     * <p>
     *     销售报表视图控制器
     * </p>
     * @return 跳转的html界面
     */
    @GetMapping("/zhuzhuangtu")
    public ModelAndView zhuzhuangtu(){
        return new ModelAndView("/reportanalysis/selazhu");
    }
}
