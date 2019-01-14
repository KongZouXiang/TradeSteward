package com.yunhe.systemsetup.controller;



import com.yunhe.systemsetup.entity.CharaManger;
import com.yunhe.systemsetup.service.impl.CharaMangerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yunhe.systemsetup.entity.CharaManger;
import com.yunhe.systemsetup.service.impl.CharaMangerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import java.util.List;

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
        return new ModelAndView("ceshichara");
    }

    //查询所有的角色管理
    @RequestMapping("/charalist")
    public List<CharaManger> selectAll(){
        List<CharaManger> list= charaMangerService.selectAll();
        System.out.println(list);
        return list;
    }

    //返回修改页面
    @RequestMapping("/chara_edit")
    public ModelAndView toCharaEdit(int id, Model model){
        CharaManger charamanger = charaMangerService.getById(id);
        System.out.println(charamanger);
        model.addAttribute("chara",charamanger);
        return new ModelAndView("cechara-edit");
    }
    //

    public CharaMangerServiceImpl getCharaMangerService() {
        return charaMangerService;
    }

    public void setCharaMangerService(CharaMangerServiceImpl charaMangerService) {
        this.charaMangerService = charaMangerService;
    }
}
