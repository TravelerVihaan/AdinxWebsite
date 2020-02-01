package com.github.vihaan.tripswebsite.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

class ControllersUtil {

    Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
