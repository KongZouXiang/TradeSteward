package com.yunhe.basicdata.controller;


import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.service.impl.CommodityListServiceImpl;
import org.springframework.web.bind.annotation.*;

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
 *
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
    public Map selectCommPage(int size, int current, CommodityList commodityList) {
        return commodityListService.selectAllCommList(current, size, commodityList);
    }

    /**
     * 增加商品的信息
     *
     * @param clName 前端页面传过来的商品名称
     * @return 无返回
     */
    @RequestMapping(value = "/addpage", method = RequestMethod.POST)
    @ResponseBody
    public String insertComm(@RequestParam("clName") String clName) {
        CommodityList commodityList = new CommodityList();
        commodityList.setClName(clName);
        commodityListService.insertComm(commodityList);
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
     * @param data 模糊查询的信息
     * @return 商品的一条信息
     */
    @RequestMapping(value = "/vaguelist", method = RequestMethod.POST)
    @ResponseBody
    public Map vagueList(String data) {
        List list = commodityListService.selectCommstlist(data);
        Map map = new HashMap();
        map.put("data", list);
        return map;
    }

}
