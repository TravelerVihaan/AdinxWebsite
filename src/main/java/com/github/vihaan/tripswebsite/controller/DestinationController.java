package com.github.vihaan.tripswebsite.controller;

import com.github.vihaan.tripswebsite.trips.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinationController {

    private DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @GetMapping(IControllersStrings.DESTINATIONS_LIST_PATH)
    public String getDestinations(Model model){
        model.addAttribute("destinationList",destinationService.getAllDestinations());
        return IControllersStrings.DESTINATIONS_LIST;
    }

    @GetMapping(IControllersStrings.DESTINATION_PATH)
    public String getDestinations(@PathVariable long id, Model model){
        return IControllersStrings.DESTINATION;
    }

    @PostMapping("/create-destination")
    public String createDestination(){
        return IControllersStrings.DESTINATIONS_LIST_PATH;
    }
}
