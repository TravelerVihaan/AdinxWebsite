package com.github.vihaan.tripswebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinationController {

    @GetMapping("/destinations")
    public String getDestinations(Model model){
        return "destinations";
    }

    @GetMapping("/destinations/{id}")
    public String getDestinations(@PathVariable long id, Model model){
        return "destination";
    }

    @PostMapping("/create-destination")
    public String createDestination(){
        return ""; // TODO
    }
}
