package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;
import com.github.vihaan.tripswebsite.users.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IControllersStrings.DESTINATIONS_MAPPING)
public class DestinationController {

    private TripRepositoriesFacade tripRepositoriesFacade;

    @Autowired
    public DestinationController(TripRepositoriesFacade tripRepositoriesFacade){
        this.tripRepositoriesFacade = tripRepositoriesFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DestinationDTO>> getDestinations(Model model){
        List<DestinationDTO> destinations = tripRepositoriesFacade.getAllDestinationDtos();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping(path = IControllersStrings.DESTINATIONS_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DestinationDTO> getDestination(@PathVariable String destinationName){
        return ResponseEntity.of(tripRepositoriesFacade.getDestinationDtoByName(destinationName));
    }

}
