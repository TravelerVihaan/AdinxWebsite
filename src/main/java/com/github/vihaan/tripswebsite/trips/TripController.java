package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(IControllersStrings.TRIPS_MAPPING)
public class TripController {

    private TripRepositoriesFacade tripRepositoriesFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TripDTO>> getAllTrips(){
        List<TripDTO> trips = tripRepositoriesFacade.getAllTripDtos();
        return ResponseEntity.ok(trips);
    }

    @GetMapping(path = "/{tripNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TripDTO> getTrip(@PathVariable String tripNumber){
        return ResponseEntity.of(tripRepositoriesFacade.getTripByVoucherNumber(tripNumber));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> addTripBooking(@RequestBody TripDTO trip){
        List<String> errors = tripRepositoriesFacade.doExecuteTripBooking(trip);
        if(errors.isEmpty()) {
            return ResponseEntity.ok(errors);
        }
        //TODO bad request response with list of errors
        return ResponseEntity.ok(errors);
    }


}
