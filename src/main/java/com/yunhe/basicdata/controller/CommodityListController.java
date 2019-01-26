package com.yunhe.basicdata.controller;
import com.yunhe.basicdata.entity.Commclass;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.entity.WarehouseManagement;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
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
 * 商品列表 前端控制器
 * </p>
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/basicdata/commodity-list")
public class CommodityListController {
    @Resource
    CommodityListServiceImpl commodityListService;
    /**
     * 查询商品的信息 分页
     * @param size          每页显示的条数
     * @param current       当前页
     * @param commodityList 商品列表的对象
     * @return 商品的信息
     */
    @RequestMapping(value = "/getpage", method = RequestMethod.POST)
    @ResponseBody
    public Map selectCommPage(int current, int size, CommodityList commodityList) {
        return commodityListService.selectAllcommList(current, size, commodityList);
    }
    /**
     * 增加商品的信息
     * 前端页面传过来的商品名称
     * @return 无返回
     */
    @RequestMapping(value = "/addpage", method = RequestMethod.POST)
    @ResponseBody
    public int insertComm(@RequestParam("clScan") String clScan,@RequestParam("clNumber") String clNumber,
                          @RequestParam("clName") String clName,@RequestParam("ccId") int  ccId,
                          @RequestParam("clUnit") String clUnit,@RequestParam("clSpec") String clSpec,
                          @RequestParam("clPurPrice") String clPurPrice,@RequestParam("clWhoPrice") String clWhoPrice,
                          @RequestParam("clTagPrise") String clTagPrise,@RequestParam("wmId") int  wmId,
                          @RequestParam("clMinLingPrice") String  clMinLingPrice,@RequestParam("clMinStock") int clMinStock,
                          @RequestParam("clMAxStock") int clMAxStock) {
        CommodityList commodityList=new CommodityList();
        commodityList.setClScan(clScan);
        commodityList.setClNumber(clNumber);
        commodityList.setClName(clName);
        commodityList.setClSpec(clSpec);
        commodityList.setClUnit(clUnit);
        commodityList.setClPurPrice(clPurPrice);
        commodityList.setClWhoPrice(clWhoPrice);
        commodityList.setClTagPrise(clTagPrise);
        commodityList.setWmId(wmId);
        commodityList.setCcId(ccId);
        commodityList.setClMinLingPrice(clMinLingPrice);
        commodityList.setClMinStock(clMinStock);
        commodityList.setClMAxStock(clMAxStock);
        commodityList.setPrId(4);
        return  commodityListService.insertComm(commodityList);
    }
    /**
     * 查询商品的详细信息
     * @param id 传过来的id
     * @return 商品的一条数据
     */
    @GetMapping(value = "/selectcommditybyid")
    public ModelAndView selectbyid(@RequestParam("id") int id) {
        ModelAndView mv=new ModelAndView();
         CommodityList commodityListid = commodityListService.selectCommById(id);
        WarehouseManagement whManagement= commodityListService.selectWmAndComm(id);
       Commclass commclass= commodityListService.selectclassAndComm(id);
        mv.addObject("commodityListid",commodityListid);
        mv.addObject("whManagement",whManagement);
        mv.addObject("commclass",commclass);
       mv.setViewName("basicdata/editCommodity");
        return mv;
    }

    /**
     * 根据id查询所有的商品.刘延琦2019-1-23 16:10:22
     * @param id
     * @return
     */
    @GetMapping(value = "/selectcommdityId")
    public CommodityList selectcommdityId(@RequestParam("id") int id) {

        CommodityList commodityListid = commodityListService.selectCommById(id);
        return commodityListid;
    }
    /**
     * 更改商品的信息
     * @param id     传过来的id
     * @param mingcheng 修改的商品名称
     * @param bianhao
     * @return 修改后的商品的信息
     */
    @RequestMapping(value = "/updateComm", method = RequestMethod.POST)
    public int  updateComm(@RequestParam("id") int id,@RequestParam("tiaoxingma") String tiaoxingma,
                          @RequestParam("bianhao") String bianhao,@RequestParam("mingcheng") String mingcheng,
                          @RequestParam("guige") String guige,@RequestParam("cankaojinhuo") String cankaojinhuo,
                          @RequestParam("pifajia") String pifajia,@RequestParam("lingshoujia") String lingshoujia,
                           @RequestParam("comzuilingshoujia") String comzuilingshoujia,@RequestParam("comzuidikucun") int comzuidikucun,
                           @RequestParam("comzuigaokucun") int comzuigaokucun,@RequestParam("fenlei") int fenlei,
                           @RequestParam("danwei") String danwei,@RequestParam("wmid") int wmid) {
        CommodityList commodityList = new CommodityList();
        commodityList.setId(id);
        commodityList.setClScan(tiaoxingma);
        commodityList.setClName(mingcheng);
        commodityList.setClUnit(danwei);
        commodityList.setClSpec(guige);
        commodityList.setClPurPrice(cankaojinhuo);
        commodityList.setClWhoPrice(pifajia);
        commodityList.setClTagPrise(lingshoujia);
        commodityList.setCcId(fenlei);
        commodityList.setClNumber(bianhao);
        commodityList.setClMinLingPrice(comzuilingshoujia);
        commodityList.setClMinStock(comzuidikucun);
        commodityList.setClMAxStock(comzuigaokucun);
        commodityList.setWmId(wmid);
        return commodityListService.updateComm(commodityList);
    }
    @GetMapping("/detailcommodity")
       public ModelAndView detailcommodity(@RequestParam("id") Integer id){
        ModelAndView mv=new ModelAndView();
       CommodityList detailcommodity= commodityListService.selectCommById(id);
      WarehouseManagement warehouseid= commodityListService.selectWmAndComm(id);
    Commclass commclass= commodityListService.selectclassAndComm(id);
      mv.addObject("warehouseid",warehouseid);
       mv.addObject("detailcommodity",detailcommodity);
       mv.addObject("commclass",commclass);
       mv.setViewName("basicdata/detailCommodity");
       return mv;
       }
    /**
     * 删除商品的信息
     * @param id 传过来的id
     */
    @RequestMapping(value = "/deleteComm", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCommList(@RequestParam("id") Integer id) {
        CommodityList commodityList = new CommodityList();
        commodityList.setId(id);
       return commodityListService.deleteComm(commodityList);
    }
    /**
     * 模糊查询
     * @param poKeyword 模糊查询的信息
     * @return 商品的一条信息
     */
    @RequestMapping(value = "/vaguelist", method = RequestMethod.POST)
    @ResponseBody
    public Map vagueList(@RequestParam("poKeyword") String poKeyword) {
        List list = commodityListService.selectCommstlist(poKeyword);
        Map map = new HashMap();
        map.put("data", list);
        return map;
    }
    @RequestMapping(value = "/deletall",method = RequestMethod.POST)
    public boolean deletaAll(HttpServletRequest request,@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            CommodityList commodityList=new CommodityList();
            commodityList.setId(id);
            commodityListService.deleteComm(commodityList);
        }
        return true;
    }
    /**
     * 导出excel
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/getExcel")
    public String getExcel(HttpServletResponse response) throws IOException {
        List<CommodityList> commexcel=(List<CommodityList>) commodityListService.ExportExcel();
        System.out.println("数据行数："+commexcel.size());
      List<Map<String,Object>> newlist=  new ArrayList();
        for (CommodityList commodityList : commexcel) {
            Map<String,Object> map=new HashMap();
            map.put("id",commodityList.getId());
            map.put("clNumbre",commodityList.getClNumber());
            map.put("clName",commodityList.getClName());
            map.put("usId",1);
            map.put("clTagPrise",commodityList.getClTagPrise());
            map.put("prId",2);
            map.put("clSpec",commodityList.getClSpec());
            newlist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("商品列表");
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
        cell.setCellValue("商品列表");
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
        cell1.setCellValue("编号");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("名称");

        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("基本单位");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("零售价");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("属性");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("规格");
        //单元格宽度自适应
        sheet.autoSizeColumn((short)3);
        sheet.autoSizeColumn((short)4);
        sheet.autoSizeColumn((short)5);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < newlist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)2);
            //从sheet第三行开始填充数据
            HSSFRow rowx=sheet.createRow(i+2);
            Map<String,Object> map = newlist.get(i);
           CommodityList commodityList=new CommodityList();
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((int) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("clNumbre"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("clName"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((int) map.get("usId"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("clTagPrise"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((int) map.get("prId"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("clSpec"));
        }//输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=commdity.xls");//文件名这里可以改
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return null;
    }
    @RequestMapping("/addcommlist")
    public ModelAndView addcomm() {
        return new ModelAndView("basicdata/addCommodityList");
    }
    @RequestMapping("/getcommdityfenye")
    public ModelAndView selectfenye() {
        return new ModelAndView("basicdata/admincommodity-list");
    }
    @RequestMapping("/tocomclass")
    public ModelAndView tocomclass(){
        return new ModelAndView("basicdata/comclass");
    }
}
