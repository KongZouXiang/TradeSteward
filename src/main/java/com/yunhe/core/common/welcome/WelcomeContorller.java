package com.yunhe.core.common.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeContorller {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
