package com.yunhe.cargomanagement.controller;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.IWarehouseManagementService;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.service.IRunningAccountsService;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.entity.PurchaseReturnHistory;
import com.yunhe.cargomanagement.service.IPurCommService;
import com.yunhe.cargomanagement.service.IPurchaseReturnHistoryService;
import com.yunhe.core.util.DateUtil;
import com.yunhe.customermanagement.service.ISupplierService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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
 * 进货退货历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/purchase-return-history")
public class PurchaseReturnHistoryController {

    @Resource
    private IPurchaseReturnHistoryService purchaseReturnHistoryService;

    /**
     * 供应商列表
     */
    @Resource
    private ISupplierService supplierService;

    /**
     * 商品列表
     */
    @Resource
    private CommodityListServiceImpl commodityListService;

    /**
     * 进货详情中间表
     */
    @Resource
    private IPurCommService purCommService;

    /**
     * 仓库列表
     */
    @Resource
    private IWarehouseManagementService warehouseManagementService;

    /**
     * 资金流水
     */
    @Resource
    private IRunningAccountsService runningAccountsService;

    @RequestMapping("/purchaseReturnHistoryList")
    public ModelAndView getGoToPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/purreturnhistory-list");
        return mv;
    }

    /**
     * 增加进货退货历史页面
     * @return 页面
     */
    @RequestMapping("/addPurchaseReturnHist")
    public ModelAndView addPurchaseReturnHist(HttpSession session){
        String curr = DateUtil.curr();
        String curr2 = curr.replace(" ", "");
        String curr3 = "-";
        String curr4 = curr2.replace(curr3,"");
        String curr5 = ":";
        String curr6 = curr4.replace(curr5,"");
        String curr7 = "TDD"+curr6;
        session.setAttribute("curr",curr7);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/Pur_order_history-add");
        return mv;
    }

    /**
     * 增加进货历史
     * @param purchaseReturnHistory 进货退货历史实体类数据
     */
    @RequestMapping("/addPurchaseReturnGoTo")
    public ModelAndView insertPurchaseOrder(PurchaseReturnHistory purchaseReturnHistory,String[] prhReturnsup,int[] QuantityOfPurchase){
        int a = 0;
        int maney = 0;
        for (int i = 0; i <= prhReturnsup.length - 1; i++) {
            CommodityList list = commodityListService.selectListByClName(prhReturnsup[i]);
                maney+=Integer.parseInt(list.getClPurPrice())*QuantityOfPurchase[i];
        }
        for (int s : QuantityOfPurchase) {
            a+=s;
        }
        purchaseReturnHistory.setPrhTotalAmount(maney+purchaseReturnHistory.getPrhOtherExpenses());
        purchaseReturnHistory.setPrhRefundAmount(maney+purchaseReturnHistory.getPrhOtherExpenses());
        purchaseReturnHistory.setPrhBill("无");
        purchaseReturnHistory.setPrhJindate(purchaseReturnHistory.getPrhDate());
        purchaseReturnHistory.setPrhManeyHu("现金");
        purchaseReturnHistory.setPrhSinglePerson("老板");
        purchaseReturnHistory.setPrhOutgoingState("待出库");
        purchaseReturnHistoryService.insertPurchaseReturnHistoryPage(purchaseReturnHistory);
        //增加资金流水
        RunningAccounts runningAccounts1 = runningAccountsService.selectRunningMaxIdMoney();
        RunningAccounts runningAccounts = new RunningAccounts();
        runningAccounts.setRaNumList(purchaseReturnHistory.getPrhNumber());
        runningAccounts.setRaTime(DateUtil.curr());
        runningAccounts.setRaCompanyName(purchaseReturnHistory.getPrhSupname());
        runningAccounts.setRaProjectName("退货支出");
        runningAccounts.setRaAccount("现金");
        runningAccounts.setRaPerson("老板");
        runningAccounts.setRaIncome(maney+purchaseReturnHistory.getPrhOtherExpenses());
        runningAccounts.setRaOutcome(0.0);
        runningAccounts.setRaCurrentBalance(runningAccounts1.getRaCurrentBalance()+(maney+purchaseReturnHistory.getPrhOtherExpenses()));
        runningAccountsService.insertRunningAccountsOne(runningAccounts);
        for (int i = 0; i <= prhReturnsup.length - 1; i++) {
            CommodityList list1 = commodityListService.selectListByClName(prhReturnsup[i]);
                PurchaseReturnHistory purchaseReturnHistory1 = purchaseReturnHistoryService.selectRurchaseReturnHistByNum(purchaseReturnHistory.getPrhNumber());
                PurComm purComm = new PurComm();
                purComm.setPrhId(purchaseReturnHistory1.getId());
                purComm.setComId(list1.getId());
                purComm.setPcGeshu(QuantityOfPurchase[i]);
                purCommService.insertPurComm(purComm);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/purreturnhistory-list");
        return mv;
    }


    /**
     * 跳转进货退货历史页面 并且session传值过去
     * @param session session
     * @param id 进货退货历史页面传过来的id
     * @return 要跳转的页面
     */
    @RequestMapping("/rderHostXiang")
    public ModelAndView test33(HttpSession session, int id) {
        PurchaseReturnHistory purchaseReturnHistory = purchaseReturnHistoryService.selectOrderXiangList(id);
        List<PurComm> purComms = purchaseReturnHistoryService.selectOrderHistZhong(id);
        int zongjia = 0;
        int zongshu = 0;
        for (PurComm purComm : purComms) {
            zongjia += purComm.getPcGeshu() * Integer.parseInt(purComm.getCommodityList().getClPurPrice());
            zongshu+=purComm.getPcGeshu();
        }
        session.setAttribute("shuliang",zongshu);
        session.setAttribute("jiage",zongjia);
        session.setAttribute("pulist", purchaseReturnHistory);
        session.setAttribute("poId", id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/Pur_order_history_select_xiang");
        return mv;
    }


    /**
     * 条件分页查询进货退货历史
     * @param pageNum 当前页
     * @param pageSize 总条数
     * @param purchaseReturnHistory 实体类接收数据
     * @return 进货历史和分页数据的 数据集合
     */
    @RequestMapping("/selectPurchaseReturnHistoryPage")
    public Map selectPurchaseReturnHistoryPage(int pageNum, int pageSize, PurchaseReturnHistory purchaseReturnHistory){
        System.out.println("****"+purchaseReturnHistory.getPrhNumber());
        System.out.println("********"+pageNum);
        System.out.println("**********"+pageSize);
        Map purchaseReturnHistoryPage = purchaseReturnHistoryService.selectPurchaseReturnHistoryPage(pageNum, pageSize, purchaseReturnHistory);
        return purchaseReturnHistoryPage;
    }

    /**
     * 新增进货退货历史
     * @param purchaseReturnHistory 实体类接收数据
     * @return int
     */
    @RequestMapping("/insertPurchaseReturnHistoryPage")
    public int insertPurchaseReturnHistoryPage(PurchaseReturnHistory purchaseReturnHistory){
        System.out.println(purchaseReturnHistory.getPrhNumber());
        return purchaseReturnHistoryService.insertPurchaseReturnHistoryPage(purchaseReturnHistory);
    }

    /**
     * 根据id修改进货退货历史
     * @param purchaseReturnHistory 实体类接收数据
     * @return int
     */
    @RequestMapping("/updatePurchaseReturnHistory")
    public int updatePurchaseReturnHistory(PurchaseReturnHistory purchaseReturnHistory){
        System.out.println("*****"+purchaseReturnHistory.getId());
        return purchaseReturnHistoryService.updatePurchaseReturnHistory(purchaseReturnHistory);
    }



    /**
     * 根据id删除进货退货历史
     * @param id
     * @return
     */
    @RequestMapping("/deletePurchaseReturnHistory")
    public int deletePurchaseReturnHistory(int id){
        return purchaseReturnHistoryService.deletePurchaseReturnHistory(id);
    }

    /**
     * 进货退货历史商品详情
     * @param purchaseReturnHistory  进货退货历史实体类接收
     * @return 进货退货历史商品详情信息
     */
    @RequestMapping("/selectOrderHistZhong")
    public List<PurComm> selectOrderHistZhong(PurchaseReturnHistory purchaseReturnHistory){
        return purchaseReturnHistoryService.selectOrderHistZhong(purchaseReturnHistory.getId());
    }

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @RequestMapping("/puchaseReturnHistoryExcel")
    public String puchaseHistoryExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<PurchaseReturnHistory> newlist = purchaseReturnHistoryService.selectPurchaseReturnHistory();
        System.out.println("数据行数："+newlist.size());
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(PurchaseReturnHistory obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            System.out.println("第一个字段"+obj.getId());
            Map<String,Object> map = new HashMap();
            map.put("id",obj.getId());
            map.put("prhDate",obj.getPrhDate());
            map.put("prhNumber",obj.getPrhNumber());
            map.put("prhSupname",obj.getPrhSupname());
            map.put("prhReturnsup",obj.getPrhReturnsup());
            map.put("prhTotalAmount",obj.getPrhReturnsup());
            map.put("prhRefundAmount",obj.getPrhRefundAmount());
            map.put("prhOutgoingWarehouse",obj.getPrhOutgoingWarehouse());
            map.put("prhBill",obj.getPrhBill());
            map.put("prhJindate",obj.getPrhJindate());
            map.put("prhManeyHu",obj.getPrhManeyHu());
            map.put("prhExperiencedPerson",obj.getPrhExperiencedPerson());
            map.put("prhSinglePerson",obj.getPrhSinglePerson());
            map.put("prhOtherExpenses",obj.getPrhOtherExpenses());
            map.put("prhOutgoingState",obj.getPrhOutgoingState());
            map.put("prhRemarks",obj.getPrhRemarks());
            solist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("报表1");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列11索 引，可以是0～255之间的任何一个
        //*  System.out.println(1);*//*
        HSSFCell cell=row1.createCell(0);


        // 1.生成字体对象
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("新宋体");

        // 2.生成样式对象，这里的设置居中样式和版本有关，我用的poi用HSSFCellStyle.ALIGN_CENTER会报错，所以用下面的
        HSSFCellStyle style = wb.createCellStyle();
        //设置居中样式
        //*style.setAlignment(HSSFCellStyle.ALIGN_CENTER);*//*
        // 调用字体样式对象
        style.setFont(font);
        style.setWrapText(true);
        //*style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式*//*

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
        cell0.setCellValue("id号");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("业务日期");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("单据编号");


        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("供应商名称");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("退货商品");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("总计金额");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("实退金额");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("出库仓库");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("纸质单据");

        HSSFCell cell10=row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("制单日期 ");

        HSSFCell cell11=row2.createCell(11);
        cell11.setCellStyle(style);
        cell11.setCellValue("结算账户 ");

        HSSFCell cell12=row2.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("经手人 ");

        HSSFCell cell13=row2.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue("制单人 ");

        HSSFCell cell14=row2.createCell(14);
        cell14.setCellStyle(style);
        cell14.setCellValue("其他费用 ");

        HSSFCell cell15=row2.createCell(15);
        cell15.setCellStyle(style);
        cell15.setCellValue("出库状态 ");

        HSSFCell cell16=row2.createCell(16);
        cell16.setCellStyle(style);
        cell16.setCellValue("备注 ");

        //单元格宽度自适应

        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < solist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)2);
            sheet.autoSizeColumn((short)3);
            sheet.autoSizeColumn((short)4);
            sheet.autoSizeColumn((short)5);
            sheet.autoSizeColumn((short)6);
            sheet.autoSizeColumn((short)7);
            sheet.autoSizeColumn((short)8);
            sheet.autoSizeColumn((short)9);
            sheet.autoSizeColumn((short)10);
            sheet.autoSizeColumn((short)11);
            sheet.autoSizeColumn((short)12);
            sheet.autoSizeColumn((short)13);
            sheet.autoSizeColumn((short)14);
            sheet.autoSizeColumn((short)15);
            sheet.autoSizeColumn((short)16);
            //从sheet第三行开始填充数据
            HSSFRow rowx=sheet.createRow(i+2);
            Map<String,Object> map = solist.get(i);
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((Integer) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("prhDate"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("prhNumber"));


            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("prhSupname"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((String) map.get("prhReturnsup"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("prhTotalAmount"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((double) map.get("prhRefundAmount"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((String) map.get("prhOutgoingWarehouse"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((String) map.get("prhBill"));

            HSSFCell cell010=rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((String) map.get("prhJindate"));

            HSSFCell cell011=rowx.createCell(11);
            cell011.setCellStyle(style);
            cell011.setCellValue((String) map.get("prhManeyHu"));

            HSSFCell cell012=rowx.createCell(12);
            cell012.setCellStyle(style);
            cell012.setCellValue((String) map.get("prhExperiencedPerson"));

            HSSFCell cell013=rowx.createCell(13);
            cell013.setCellStyle(style);
            cell013.setCellValue((String) map.get("prhSinglePerson"));

            HSSFCell cell014=rowx.createCell(14);
            cell014.setCellStyle(style);
            cell014.setCellValue((double) map.get("prhOtherExpenses"));

            HSSFCell cell015=rowx.createCell(15);
            cell015.setCellStyle(style);
            cell015.setCellValue((String) map.get("prhOutgoingState"));

            HSSFCell cell016=rowx.createCell(16);
            cell016.setCellStyle(style);
            cell016.setCellValue((String) map.get("prhRemarks"));
        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=PurchaseHistory.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "成功！";
    }

    public IPurchaseReturnHistoryService getPurchaseReturnHistoryService() {
        return purchaseReturnHistoryService;
    }

    public void setPurchaseReturnHistoryService(IPurchaseReturnHistoryService purchaseReturnHistoryService) {
        this.purchaseReturnHistoryService = purchaseReturnHistoryService;
    }
}
