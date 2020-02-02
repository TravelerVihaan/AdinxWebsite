package com.github.vihaan.tripswebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(@RequestParam(defaultValue = "false") boolean error, Model model) {
        model.addAttribute("error", error);
        return IControllersStrings.LOGIN;
    }
}
