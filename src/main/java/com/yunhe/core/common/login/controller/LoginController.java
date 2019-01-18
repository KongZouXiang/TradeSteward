package com.yunhe.core.common.login.controller;

import com.yunhe.core.common.login.service.ILoginService;
import com.yunhe.systemsetup.entity.Employ;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 实现项目首次进入的登录功能
 * </p>
 *
 * @author 孔邹祥
 * @date 2019年1月9日
 */
@Controller
public class LoginController {

    @Resource
    ILoginService loginService;

    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/tologin")
    public String toLogin() {
        return "login";
    }
    @GetMapping("/toindex")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(Employ employ,Model model,HttpSession session) {


        /**
         * 使用Shiro编写认证操作
         */
//        1.获取Subject
        Subject subject = SecurityUtils.getSubject();

//        2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(employ.getEmUsername(), employ.getEmPassword());

//        3.执行登录方法
        try {
            subject.login(token);
            session.setAttribute("employ",employ);
            return "toindex";

        } catch (UnknownAccountException e) {
//            e.printStackTrace()
//            登录失败:用户名不存在
            model.addAttribute("loginMsg", "用户名不存在!");
            return "tologin";

        } catch (IncorrectCredentialsException e) {
//            e.printStackTrace()
            model.addAttribute("loginMsg", "密码错误!");
            return "tologin";
        }

    }
}
