package com.yunhe.cargomanagement.controller;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.entity.WarehouseManagement;
import com.yunhe.basicdata.service.IWarehouseManagementService;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import com.yunhe.billmanagement.entity.RunningAccounts;
import com.yunhe.billmanagement.service.IRunningAccountsService;
import com.yunhe.cargomanagement.entity.PurComm;
import com.yunhe.cargomanagement.entity.PurchaseHistory;
import com.yunhe.cargomanagement.service.IPurCommService;
import com.yunhe.cargomanagement.service.IPurchaseHistoryService;
import com.yunhe.core.util.DateUtil;
import com.yunhe.customermanagement.service.ISupplierService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.PostMapping;
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
 * 进货历史 前端控制器
 * </p>
 *
 * @author 史江浩
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/cargomanagement/purchase-history")
public class PurchaseHistoryController {

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



    @RequestMapping("/purchasehistoryList")
    public ModelAndView getGoToPurchaseHistory(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/purhistory-list");
        return mv;
    }

    /**
     * 增加进货订单历史页面
     *
     * @return 页面
     */
    @RequestMapping("/addPurchaseHistory")
    public ModelAndView getaddPurchaseHouseOne(HttpSession session) {
        String curr = DateUtil.curr();
        String curr2 = curr.replace(" ", "");
        String curr3 = "-";
        String curr4 = curr2.replace(curr3,"");
        String curr5 = ":";
        String curr6 = curr4.replace(curr5,"");
        String curr7 = "ADD"+curr6;
        session.setAttribute("curr",curr7);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargomanagement/Pur_history-add");
        return mv;
    }

    /**
     * 增加进货历史
     *
     * @param purchaseHistory 进货历史实体类数据
     */
    @RequestMapping("/addPurchaseGoTo")
    public ModelAndView insertPurchaseOrder(PurchaseHistory purchaseHistory,String[] phClname,int[] QuantityOfPurchase) {
        int a = 0;
        int maney = 0;
        for (int i = 0;i<=phClname.length-1;i++){
            CommodityList list = commodityListService.selectListByClName(phClname[i]);
            maney+=Integer.parseInt(list.getClPurPrice())*QuantityOfPurchase[i];
        }

        for (int s : QuantityOfPurchase) {
            a+=s;
        }
        purchaseHistory.setPhAmountPayable(maney+purchaseHistory.getPhOtherExpenses());
        purchaseHistory.setPhAmountPaid(maney+purchaseHistory.getPhOtherExpenses());
        purchaseHistory.setPhBill("无");
        purchaseHistory.setPhJindate(purchaseHistory.getPhDate());
        purchaseHistory.setPhQuantity(a);
        purchaseHistory.setPhManeyHu("现金");
        purchaseHistory.setPhSinglePerson("老板");
        purchaseHistory.setPhWarehousingStatus("正在入库");
        purchaseHistoryService.insertPurchaseHistory(purchaseHistory);

        RunningAccounts runningAccounts1 = runningAccountsService.selectRunningMaxIdMoney();
        RunningAccounts runningAccounts = new RunningAccounts();
        runningAccounts.setRaNumList(purchaseHistory.getPhNumber());
        runningAccounts.setRaTime(DateUtil.curr());
        runningAccounts.setRaCompanyName(purchaseHistory.getPhSupname());
        runningAccounts.setRaProjectName("进货支出");
        runningAccounts.setRaAccount("现金");
        runningAccounts.setRaPerson("老板");
        runningAccounts.setRaIncome(0.0);
        runningAccounts.setRaOutcome(maney+purchaseHistory.getPhOtherExpenses());
        runningAccounts.setRaCurrentBalance(runningAccounts1.getRaCurrentBalance()-(maney+purchaseHistory.getPhOtherExpenses()));
        runningAccountsService.insertRunningAccountsOne(runningAccounts);
        for (int i = 0;i<=phClname.length-1;i++){
            CommodityList list1 = commodityListService.selectListByClName(phClname[i]);
            PurchaseHistory purchaseHistory1 = purchaseHistoryService.selectPurchaseHistoryByNumber(purchaseHistory.getPhNumber());
            PurComm purComm = new PurComm();
            purComm.setPuhId(purchaseHistory1.getId());
            purComm.setComId(list1.getId());
            purComm.setPcGeshu(QuantityOfPurchase[i]);
            purCommService.insertPurComm(purComm);
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/purhistory-list");
        return mv;
    }


    /**
     * 仓库信息
     * @return 仓库信息
     */
    @RequestMapping("/selectquanWarList")
    public List<WarehouseManagement> selectquanWarList(){
        return warehouseManagementService.selectquanWarList();
    }


    /**
     * 跳转进货历史页面 并且session传值过去
     * @param session session
     * @param id 进货历史页面传过来的id
     * @return 要跳转的页面
     */
    @RequestMapping("/hostXiang")
    public ModelAndView test33(HttpSession session, int id) {
        int jiage = 0;
        int shuliang = 0;
        PurchaseHistory purchaseHistory = purchaseHistoryService.selectXiangList(id);
        List<PurComm> purComms = purchaseHistoryService.selectComHistZhong(id);
        for (PurComm purComm : purComms) {
            shuliang+=purComm.getPcGeshu();
            jiage += purComm.getPcGeshu() * Integer.parseInt(purComm.getCommodityList().getClPurPrice());
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargomanagement/Pur_history_select_xiang");
        session.setAttribute("pulist", purchaseHistory);
        session.setAttribute("shuliang",shuliang);
        session.setAttribute("jiage",jiage);
        session.setAttribute("poId", id);
        return mv;
    }



    /**
     * 进货历史分页
     * @param pageNum 前台传过来的当前页数据
     * @param pageSize 前台传过来的每页条数数据
     * @param purchaseHistory 进货历史条件查询的数据
     * @return 进货历史分页数据 传到前台 ajax接收
     */
    @RequestMapping("/getPurchaseHistoryPage")
    public Map getPurchaseHistoryByPhNumber(int pageNum, int pageSize, PurchaseHistory purchaseHistory){
        System.out.println(purchaseHistory.getPhNumber()+"*******"+purchaseHistory.getPhSupname());
        Map purchaseHistpage = purchaseHistoryService.getPurchaseHistoryByPhNumber(pageNum,pageSize,purchaseHistory);
        return purchaseHistpage;
    }

    /**
     * 新增进货历史
     * @param purchaseHistory 进货历史实体类接收的数据
     * @return int
     */
    @RequestMapping("/addPurchaseHistoryGoTo")
    public int addPurchaseHistoryById(PurchaseHistory purchaseHistory){
        System.out.println(purchaseHistory+"..............");
        return purchaseHistoryService.insertPurchaseHistory(purchaseHistory);
    }

    /**
     * 根据id删除进货历史
     * @param id 前台传值id
     * @return int
     */
    @RequestMapping("/deletePurchaseHistoryById")
    public int deletePurchaseHistoryById(int id){
        System.out.println("*******"+id);
        return purchaseHistoryService.deleteById(id);
    }

    /**
     * 根据id修改进货历史
     * @param purchaseHistory 进货历史实体类接收的数据
     * @return int
     */
    @RequestMapping("/updatePurchaseHistoryById")
    public int updatePurchaseHistoryById(PurchaseHistory purchaseHistory){
        System.out.println("*****"+purchaseHistory.getId());
        return purchaseHistoryService.updatePurchaseHistoryById(purchaseHistory);
    }

    /**
     * 进货历史商品详情
     * @param purchaseHistory  进货历史实体类接收
     * @return 进货历史商品详情信息
     */
    @RequestMapping("/selectComHistZhong")
    public List<PurComm> selectComHistZhong(PurchaseHistory purchaseHistory){
        return purchaseHistoryService.selectComHistZhong(purchaseHistory.getId());
    }

    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @RequestMapping("/puchaseHistoryExcel")
    public String puchaseHistoryExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<PurchaseHistory> newlist = purchaseHistoryService.selectpurchaseHistory();
        System.out.println("数据行数："+newlist.size());
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(PurchaseHistory obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            System.out.println("FinanceClassify的第一个字段"+obj.getId());
            Map<String,Object> map = new HashMap();
            map.put("id",obj.getId());
            map.put("phDate",obj.getPhDate());
            map.put("phNumber",obj.getPhNumber());
            map.put("phSupname",obj.getPhSupname());
            map.put("phClname",obj.getPhClname());
            map.put("phQuantity",obj.getPhQuantity());
            map.put("phAmountPayable",obj.getPhAmountPayable());
            map.put("phAmountPaid",obj.getPhAmountPaid());
            map.put("phWarehouse",obj.getPhWarehouse());
            map.put("phBill",obj.getPhBill());
            map.put("phJindate",obj.getPhJindate());
            map.put("phManeyHu",obj.getPhManeyHu());
            map.put("phExperiencedPerson",obj.getPhExperiencedPerson());
            map.put("phSinglePerson",obj.getPhSinglePerson());
            map.put("phOtherExpenses",obj.getPhOtherExpenses());
            map.put("phWarehousingStatus",obj.getPhWarehousingStatus());
            map.put("phRemarks",obj.getPhRemarks());
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
        cell0.setCellValue("序号");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("业务日期");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("单据编号");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("供应商名称");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("进货商品");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("进货数量");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("应付金额");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("已付金额");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("入库仓库");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("单据");

        HSSFCell cell10=row2.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue("制单日期");

        HSSFCell cell11=row2.createCell(11);
        cell11.setCellStyle(style);
        cell11.setCellValue("结算账户");

        HSSFCell cell12=row2.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("经手人");

        HSSFCell cell13=row2.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue("制单人");

        HSSFCell cell14=row2.createCell(14);
        cell14.setCellStyle(style);
        cell14.setCellValue("其他费用");

        HSSFCell cell15=row2.createCell(15);
        cell15.setCellStyle(style);
        cell15.setCellValue("入库状态");

        HSSFCell cell16=row2.createCell(16);
        cell16.setCellStyle(style);
        cell16.setCellValue("备注");

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
            cell01.setCellValue((String) map.get("phDate"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("phNumber"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("phSupname"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("phClname"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((Integer) map.get("phQuantity"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((double) map.get("phAmountPayable"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((double) map.get("phAmountPaid"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((String) map.get("phWarehouse"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((String) map.get("phBill"));

            HSSFCell cell010=rowx.createCell(10);
            cell010.setCellStyle(style);
            cell010.setCellValue((String) map.get("phJindate"));

            HSSFCell cell011=rowx.createCell(11);
            cell011.setCellStyle(style);
            cell011.setCellValue((String) map.get("phManeyHu"));

            HSSFCell cell012=rowx.createCell(12);
            cell012.setCellStyle(style);
            cell012.setCellValue((String) map.get("phExperiencedPerson"));

            HSSFCell cell013=rowx.createCell(13);
            cell013.setCellStyle(style);
            cell013.setCellValue((String) map.get("phSinglePerson"));

            HSSFCell cell014=rowx.createCell(14);
            cell014.setCellStyle(style);
            cell014.setCellValue((String) map.get("phOtherExpenses"));

            HSSFCell cell015=rowx.createCell(15);
            cell015.setCellStyle(style);
            cell015.setCellValue((String) map.get("phWarehousingStatus"));

            HSSFCell cell016=rowx.createCell(16);
            cell016.setCellStyle(style);
            cell016.setCellValue((String) map.get("phRemarks"));

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


    public IPurchaseHistoryService getPurchaseHistoryService() {
        return purchaseHistoryService;
    }

    public void setPurchaseHistoryService(IPurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

}
