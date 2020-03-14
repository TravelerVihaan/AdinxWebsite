package com.github.vihaan.tripswebsite.controller;

public interface IControllersStrings {

    //Login Controller
    String LOGIN = "login";

    //Trip Booking
    String BOOK_TRIP_PATH = "/trip-booking";
    String BOOK_TRIP = "trip-booking";
    String PROCESS_BOOKING_PATH = "/process-booking";
    String PROCESS_BOOKING = "process-booking";
    String BOOKING_RESULT = "booking-result";

    //Trips List Controller
    String TRIPS_MAPPING = "/trips";
    String TRIP_NUMBER = "/{tripNumber}";
    String TRIP_PATH = "/trip" + IControllersStrings.ID_PATH;
    String TRIP = "trip" + IControllersStrings.ID_PATH;

    //User Controller
    String USERS_MAPPING = "/users";
    String USERNAME_PATH = "/{username}";

    //Destination Controller
    String DESTINATIONS_LIST_PATH = "/destinations";
    String DESTINATIONS_LIST = "destinations";
    String DESTINATION_PATH = "/destinations" + IControllersStrings.ID_PATH;
    String DESTINATION = "destination";

    //Common
    String ID_PATH = "/{id}";
    String REDIRECT_PREFIX = "redirect:/";
}
