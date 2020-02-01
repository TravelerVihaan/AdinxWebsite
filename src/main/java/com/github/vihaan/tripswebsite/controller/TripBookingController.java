package com.github.vihaan.tripswebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripBookingController {

    @GetMapping
    public String bookTrip(){
        return IControllersStrings.BOOK_TRIP;
    }

    @PostMapping
    public String executeBooking(){
        return IControllersStrings.PROCESS_BOOKING;
    }
}
