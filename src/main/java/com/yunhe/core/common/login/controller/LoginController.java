package com.yunhe.core.common.login.controller;

import com.yunhe.core.common.login.service.ILoginService;
import com.yunhe.systemsetup.entity.Employ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/inLogin")
public class LoginController {

    @Resource
    ILoginService loginService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

   /* @GetMapping("toindex")
    public String index() {
        return "index";
    }*/
    @PostMapping("/login")
    public String login(Employ employ, HttpSession session) {
        if (loginService.login(employ) != null) {
            session.setAttribute("employ", employ);

            return "index";
        }
      return "login";
    }
}
