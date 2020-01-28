package com.github.vihaan.tripswebsite.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripReservationController {

    @GetMapping("/trip-booking")
    public String bookTrip(){

        return "booking-result";
    }
}
