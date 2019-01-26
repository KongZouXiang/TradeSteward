package com.yunhe.basicdata.controller;


import com.yunhe.basicdata.entity.Commclass;
import com.yunhe.basicdata.service.impl.CommclassServiceImpl;
import com.yunhe.core.common.annotion.WebLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/basicdata/commclass")
public class CommclassController {

    @Resource
    private CommclassServiceImpl commclassService;
    @RequestMapping("/commclasslist")
    public ModelAndView commclasslist() {
        return new ModelAndView("basicdata/CommClass.html");
    }
    @RequestMapping("/duoji")
    public ModelAndView duoji() {
        return new ModelAndView("basicdata/duoji.html");
    }

    /**
     * <p>
     *   商品分类列表
     * <p/>
     * @return 商品数据
     */
    @RequestMapping("/queryList")
    public Map selectList(){
        List<Commclass> list=commclassService.query();
        Map map=new HashMap();
        map.put("commclass",list);
        return map;
    }
    /**
     * <p>
     *   增加商品分类前查重
     * <p/>
     * @param name 分类名称
     * @return success
     */
    @RequestMapping("/sel")
    public String sel(String name){
        List<Commclass> list=commclassService.sel(name);
        if(list.size()>0){
            return "商品分类中已有该分类！";
        }else {
            return "可以添加";
        }
    }

    /**
     * <p>
     *     添加商品分类
     * <p/>
     * @param ccdefault 要增加商品分类名
     * @return success
     */
    @RequestMapping("/add")
    public int add(Commclass commclass){
        System.out.println(commclass);
        return  commclassService.add(commclass);
    }

    /**
     * <p>
     *   修改商品分类名字
     * <p/>
     * @param aa 修改前分类名
     * @param bb  修改后分类名
     * @return success
     */
    @WebLog("修改商品分类名字")
    @RequestMapping("/update")
    public String updateCommclass(String aa,String bb){
        Map map=new HashMap();
        map.put("aa",aa);
        map.put("bb",bb);
        commclassService.updateCommclass(map);
        return "success";
    }

    /**
     * <p>
     *     删除商品分类
     * <p/>
     *
     * @param name 要删除的分类名
     * @return success
     */
    @WebLog("删除商品分类")
    @RequestMapping("/drop")
    public String drop(String name){
        commclassService.deleteCommclass(name);
        return "success";
    }

    /**
     * 根据iname返回id
     * @param name
     * @return id
     */
    @RequestMapping("/seleceidbyname")
    public int seleceidbyname(String name) throws Exception {

        return commclassService.selectidbyname(name);
}
}
