package com.github.vihaan.tripswebsite.controller;

import com.github.vihaan.tripswebsite.users.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping(IControllersStrings.REGISTER_PAGE_PATH)
    public String registerUserForm(Model model){

        return IControllersStrings.REGISTER_PAGE;
    }

    @PostMapping(IControllersStrings.REGISTRATION_PATH)
    public String doRegistration(Model model, @RequestParam UserDTO userDTO){

        return IControllersStrings.REGISTRATION_RESULT;
    }
}
