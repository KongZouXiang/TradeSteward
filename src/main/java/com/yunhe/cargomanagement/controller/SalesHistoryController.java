package com.yunhe.cargomanagement.controller;


import com.yunhe.activitymanagement.service.IPackageCommodityService;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.ICommodityListService;
import com.yunhe.cargomanagement.entity.OrderConnectComm;
import com.yunhe.cargomanagement.entity.SalesHistory;
import com.yunhe.cargomanagement.entity.SalesReturnHistory;
import com.yunhe.cargomanagement.entity.WaitOutWarehouse;
import com.yunhe.cargomanagement.service.IOrderConnectCommService;
import com.yunhe.cargomanagement.service.ISalesReturnHistoryService;
import com.yunhe.cargomanagement.service.IWaitOutWarehouseService;
import com.yunhe.cargomanagement.service.impl.SalesHistoryServiceImpl;

import com.yunhe.cargomanagement.util.DateUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 销售历史 前端控制器
 * </p>
 *
 * @author 刘延琦
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/cargomanagement/sales-history")
public class SalesHistoryController {

    @Resource
    private SalesHistoryServiceImpl salesHistoryService;

    @Resource
    private IWaitOutWarehouseService waitOutWarehouseService;

    @Resource
    private ICommodityListService commodityListService;

    @Resource
    private IOrderConnectCommService orderConnectCommService;

    @Resource
    private ISalesReturnHistoryService salesReturnHistoryService;
    /**
     * 从销售订单跳转到添加页面
     * @return 页面
     */
    @RequestMapping("/saleAdd")
    public ModelAndView ceshi1(){
        ModelAndView mv = new ModelAndView();
        String xdd = DateUtil.numberXDD();
        mv.addObject("xdd",xdd);
        mv.setViewName("cargomanagement/salesHistory-add");
        return mv;
    }

    /**
     * 增加一个订单详情
     * @param clName 商品
     * @param orderCount 数量
     * @return
     */
    @RequestMapping("/addList")
    public ModelAndView addList(SalesHistory salesHistory,int [] clName,int [] orderCount){
        ModelAndView mv = new ModelAndView();
        int count=0; double price=0; String arr="";
        for(int i=0;i<=clName.length;i++){
            CommodityList commodityList = commodityListService.selectCommById(clName[i]);
            String clName1 = commodityList.getClName();
            arr=arr + "," + clName1;
            int i1 = orderCount[i];
            count =count +i1;
            float clWhoPrice = Float.parseFloat((commodityList.getClWhoPrice()));
            price = price +clWhoPrice*i1;
        }
        salesHistory.setShSellGoods(arr);
        salesHistory.setShSellCount((double) count);
        salesHistory.setShMoney(price);
        int ix = salesHistoryService.addSalesHistory(salesHistory);
        SalesHistory salesHistory1 = salesHistoryService.selectByNumber(salesHistory);
        Integer id = salesHistory1.getId();
        for (int i=0;i<= clName.length-1;i++){
            OrderConnectComm orderConnectComm = new OrderConnectComm();
            orderConnectComm.setSellOrderNum(id);
            orderConnectComm.setClId(clName[i]);
            orderConnectComm.setOrderCount(orderCount[i]);
            orderConnectCommService.insertConn(orderConnectComm);
        }
        mv.setViewName("/cargomanagement/salesHistory");
        return mv;
    }
    /**
     * 增加一条销售历史 _已测试成功
     *
     * @param salesHistory
     * @return 增加的条数
     */
    @RequestMapping("/addSalesHistory")
    public int addSalesHistory(SalesHistory salesHistory) {
        return salesHistoryService.addSalesHistory(salesHistory);
    }
    /**
     * 修改页面跳转--根据id获取当前订单的所有信息
     * @param id 销售订单的id
     * @return int 是否成功
     */
    @RequestMapping("/edit")
    public ModelAndView edit(int id, HttpSession httpSessionsion) {
        SalesHistory salesHistory = salesHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales", salesHistory);
        return new ModelAndView("/cargomanagement/salesHistory-detail");
    }

    /**
     *页面跳转--根据id获取当前订单的所有信息(可修改页面)
     * @param id
     * @param httpSessionsion
     * @return
     */
    @RequestMapping("/editor")
    public ModelAndView editor(int id, HttpSession httpSessionsion){
        SalesHistory salesHistory = salesHistoryService.selectById(id);
        httpSessionsion.setAttribute("sales", salesHistory);
        return new ModelAndView("/cargomanagement/salesHistory-editor");
    }

    /**
     * 出库
     * @param waitOutWarehouse
     * @param aid
     * @return
     */
    @RequestMapping("changeToSale")
    public String changeToSale(WaitOutWarehouse waitOutWarehouse,int aid){
        waitOutWarehouseService.insertWaitOutWarehouse(waitOutWarehouse);
        return "true";
    }

    @RequestMapping("changeToOut")
    public String changeToOut(SalesReturnHistory salesReturnHistory, int aid){
        salesReturnHistoryService.insertSalesReturnHistory(salesReturnHistory);
        return "true";
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
            salesHistoryService.deleteSalesHistory(id);
        }
        return true;
    }
    /**
     * 根据id修改销售历史 _已测试成功
     *
     * @param salesHistory
     * @return
     */
    @RequestMapping("/update")
    public String updateSalesHistory(SalesHistory salesHistory,String [] clName,String [] commId,String []commId1,String [] orderCount) {
        for (int i=0;i<=clName.length-1;i++){
            int first = salesHistory.getId();
            int end = Integer.parseInt(commId1[i]);
            OrderConnectComm orderConnectComm = orderConnectCommService.slectOrderSale(first, end);
            orderConnectComm.setClId(Integer.parseInt(commId[i]));
            orderConnectComm.setSellOrderNum(first);
            orderConnectComm.setOrderCount(Integer.parseInt(orderCount[i]));

        }
        int i = salesHistoryService.updateSalesHistory(salesHistory);
        return "true";
    }

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    @RequestMapping("/deleteSalesHistory")
    public int deleteSalesHistory(int id) {
        return salesHistoryService.deleteSalesHistory(id);
    }


    @RequestMapping("/tiao")
    public ModelAndView tiaozhuan() {
        return new ModelAndView("/cargomanagement/salesHistory");
    }
    /**
     *
     * @param pageNum      当前页
     * @param pageSize     每页条数
     * @param salesHistory 条件
     * @return map
     */
    @RequestMapping("/quertLikeListSalesHistory")
    public Map quertLikeListSalesHistory(int pageNum, int pageSize, SalesHistory salesHistory) {
        Map map = salesHistoryService.queryLikeSalesHistory(pageNum, pageSize, salesHistory);
        return map;
    }
    @RequestMapping("/detailList")
    public List<OrderConnectComm> detailList(int id){
        return salesHistoryService.detailList(id);
    }
}
