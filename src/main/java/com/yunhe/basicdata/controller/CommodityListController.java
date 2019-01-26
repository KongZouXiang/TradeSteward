package com.yunhe.basicdata.controller;

import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品列表 前端控制器
 * </p>
 *
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
     *
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
     *
     * @return 无返回
     */
    @RequestMapping(value = "/addpage", method = RequestMethod.POST)
    @ResponseBody
    public String insertComm(@RequestParam("tiaoxingma") String tiaoxingma, @RequestParam("bianhao") String bianhao,
                             @RequestParam("mingcheng") String mingcheng, @RequestParam("fenlei") int fenlei,
                             @RequestParam("jibendanwei") int jibendanwei, @RequestParam("guige") String guige,
                             @RequestParam("cankaojinhuo") String cankaojinhuo, @RequestParam("pifajia") String pifajia,
                             @RequestParam("lingshoujia") String lingshoujia) {
        CommodityList commodityList = new CommodityList();
        System.out.println(tiaoxingma);
        commodityList.setClScan(tiaoxingma);
        commodityList.setClName(mingcheng);
        commodityList.setUsId(jibendanwei);
        commodityList.setClSpec(guige);
        commodityList.setClPurPrice(cankaojinhuo);
        commodityList.setClWhoPrice(pifajia);
        commodityList.setClTagPrise(lingshoujia);
        commodityList.setCcId(fenlei);
        commodityList.setClNumber(bianhao);
        /*commodityListService.insertComm(commodityList);*/
        System.out.println("太区庄");
        return null;
    }

    /**
     * 查询商品的详细信息
     *
     * @param id 传过来的id
     * @return 商品的一条数据
     */
    @RequestMapping(value = "/selectbyid", method = RequestMethod.POST)
    @ResponseBody
    public Map selectbyid(int id) {
        Map map = new HashMap();
        CommodityList commodityList = commodityListService.selectCommById(id);
        map.put("commodityList", commodityList);
        return map;
    }

    /**
     * 更改商品的信息
     *
     * @param id     传过来的id
     * @param clName 修改的商品名称
     * @param clScan
     * @return 修改后的商品的信息
     */
    @RequestMapping(value = "/updateComm", method = RequestMethod.POST)
    @ResponseBody
    public Map updateComm(@RequestParam("id") int id, @RequestParam("clName") String clName, @RequestParam("clScan") String clScan) {
        CommodityList commodityList = new CommodityList();
        commodityList.setId(id);
        commodityList.setClName(clName);
        commodityList.setClScan(clScan);
        commodityListService.updateComm(commodityList);
        Map map = new HashMap();
        map.put("commodityList", commodityList);
        return map;
    }

    /**
     * 更改商品的信息
     *
     * @param id 传过来的id
     */
    @RequestMapping(value = "/deleteComm", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCommList(@RequestParam("id") Integer id) {
        CommodityList commodityList = new CommodityList();
        commodityList.setId(id);
        commodityListService.deleteComm(commodityList);
    }

    /**
     * 模糊查询
     *
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

    @RequestMapping("/addcommlist")
    public ModelAndView addcomm() {
        return new ModelAndView("basicdata/addCommodityList");
    }

    @RequestMapping("/getcommdityfenye")
    public ModelAndView selectfenye() {
        return new ModelAndView("basicdata/admincommodity-list");
    }

    /**
     * <p>
     *     进货报表   （勿删）
     * </p>
     * @param current 当前页
     * @param size 每页条数
     * @return 分页
     */
    @PostMapping("/selectListMap")
    @ResponseBody
    public Map selectListMap(int current, int size){
        System.out.println("current:"+current+"size:"+size);
        return commodityListService.selectListMap( current, size);
    }
    @GetMapping("/zhuzahung")
    public ModelAndView zhu(){
        return new ModelAndView("/reportanalysis/zhuzhuangtu");
    }

}
