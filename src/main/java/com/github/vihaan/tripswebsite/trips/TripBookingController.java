package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripBookingController {

    private TripRepositoriesFacade tripRepositoriesFacade;

    @GetMapping(IControllersStrings.BOOK_TRIP_PATH)
    public String bookTrip(Model model){
        model.addAttribute("newTrip", new TripDTO());
        model.addAttribute("destinations", tripRepositoriesFacade.getAllDestinationDtos());
        return IControllersStrings.PROCESS_BOOKING;
    }

    @PostMapping(IControllersStrings.PROCESS_BOOKING_PATH)
    public String executeBooking(@ModelAttribute TripDTO newTrip){
        return IControllersStrings.BOOKING_RESULT;
    }
}
