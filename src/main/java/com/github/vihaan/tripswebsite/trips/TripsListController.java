package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TripsListController {

    private TripRepositoriesFacade tripRepositoriesFacade;

    @GetMapping(IControllersStrings.TRIPS_LIST_PATH)
    public String getTrips(Model model){
        model.addAttribute("tripList", tripRepositoriesFacade.getAllTripDtos());
        return IControllersStrings.TRIPS_LIST;
    }

    @GetMapping(IControllersStrings.TRIP_PATH)
    public String getTrip(@PathVariable long id, Model model){
        model.addAttribute("trip", tripRepositoriesFacade.getTripById(id));
        return IControllersStrings.TRIP;
    }
}
