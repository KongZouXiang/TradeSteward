package com.yunhe.core.register.controller;

import com.yunhe.core.register.service.ILoginService;
import com.yunhe.systemsetup.entity.Employ;
import org.springframework.stereotype.Controller;
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
    public String index() {
        return "login";
    }

    @PostMapping("login")
    public String login(Employ employ, HttpSession session) {

        if (loginService.login(employ) != null) {
            session.setAttribute("employ", employ);
            return "index";
        }

        return "login";
    }
}
