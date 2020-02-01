package com.github.vihaan.tripswebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripBookingController {

    private

    @GetMapping
    public String bookTrip(Model model){
        model.addAttribute()
        return IControllersStrings.BOOK_TRIP;
    }

    @PostMapping
    public String executeBooking(){
        return IControllersStrings.PROCESS_BOOKING;
    }
}
