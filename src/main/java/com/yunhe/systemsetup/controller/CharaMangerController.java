package com.yunhe.systemsetup.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.CharaManger;
import com.yunhe.systemsetup.service.impl.CharaMangerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/systemsetup/chara-manger")
public class CharaMangerController {
    @Autowired
    public CharaMangerServiceImpl charaMangerService;

    //映射到页面中
    @RequestMapping("/chara")
    public ModelAndView toChara(){
        return new ModelAndView("/systemsetup/chararole");
    }

    //查询所有的角色管理
    @RequestMapping("/charalist")
    public Map selectAll(Integer pageSize, Integer pageNum){
        Page page = new Page();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        List<CharaManger> list= charaMangerService.selectAll(page);
        Map map = new HashMap();
        map.put("page",page);
        map.put("list",list);
        map.put("totalPage",page.getPages());
        System.out.println(list);
        return map;
    }

    /**
     *
     * @return ModelAndView
     * 返回增加角色的页面
     */
    @RequestMapping(value = "/addchara")
    public ModelAndView toAdd(){
        return new ModelAndView("/systemsetup/chararole-add");
    }

    /**
     *
     *
     * @param charaManger
     * @return void
     * 增加角色
     */
    @RequestMapping(value = "/addrole")
    public void addRole(CharaManger charaManger){
        charaMangerService.insertRole(charaManger);
    }

    //返回修改页面
    @RequestMapping("/chara_edit")
    public ModelAndView toCharaEdit(int id, Model model){
        CharaManger charamanger = charaMangerService.getById(id);
        System.out.println(charamanger);
        model.addAttribute("chara",charamanger);
        return new ModelAndView("/systemsetup/cechara-edit");
    }
    //

    public CharaMangerServiceImpl getCharaMangerService() {
        return charaMangerService;
    }

    public void setCharaMangerService(CharaMangerServiceImpl charaMangerService) {
        this.charaMangerService = charaMangerService;
    }
}
