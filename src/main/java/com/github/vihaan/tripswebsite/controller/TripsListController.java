package com.github.vihaan.tripswebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripsListController {

    @GetMapping
    public String getTrips(){
        return IControllersStrings.TRIPS_LIST;
    }
}
