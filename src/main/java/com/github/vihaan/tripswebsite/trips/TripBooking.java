package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import com.github.vihaan.tripswebsite.pdf.FileGenerator;
import com.github.vihaan.tripswebsite.users.User;
import com.github.vihaan.tripswebsite.users.UserRepositoriesFacade;
import com.github.vihaan.tripswebsite.validation.IValidation;
import com.itextpdf.text.Document;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TripBooking {

    private TripRepositoriesFacade tripRepositoriesFacade;
    private UserRepositoriesFacade userRepositoriesFacade;
    private FileGenerator<Document> pdfGenerator;
    private IValidation<TripDTO> tripValidator;

    @Autowired
    public TripBooking(@Qualifier("tripValidation") IValidation<TripDTO>  tripValidator,
                       @Qualifier("pdfItextGenerator") FileGenerator<Document> pdfGenerator,
                       TripRepositoriesFacade tripRepositoriesFacade,
                       UserRepositoriesFacade userRepositoriesFacade){
        this.tripRepositoriesFacade = tripRepositoriesFacade;
        this.tripValidator = tripValidator;
        this.userRepositoriesFacade = userRepositoriesFacade;
        this.pdfGenerator = pdfGenerator;
    }

    List<String> executeBooking(TripDTO tripDTO){
        List<String> errors = new ArrayList<>(tripValidator.isValid(tripDTO));
        if(errors.isEmpty()){
            tripDTO.setTripCost(calculateTripCost(tripDTO));
            IMapper<Trip, TripDTO> tripMapper = tripRepositoriesFacade.getTripMapper();
            Trip trip = tripMapper.convertDtoToEntity(tripDTO);
            try {
                trip.setTripDestination(prepareDestinationEntityToSave(tripDTO));
                trip.setUser(prepareUserEntityToSave(tripDTO));
            }catch(NoSuchElementException e){
                errors.clear();
                errors.add(DESTINATION_ERROR);
                return errors;
            }
            trip.setVoucherNumber(generateVoucherNumber(trip));
            trip.setTripActive(true);
            trip.setOrderDate(LocalDateTime.now());
            tripRepositoriesFacade.saveTrip(trip);
        }
        return errors;

    }

    private String generateVoucherNumber(Trip trip){
        String tripDestination = trip.getTripDestination().getDestination();
        String voucherNumber = tripDestination.substring(tripDestination.length()-3);
        return voucherNumber + LocalDate.now().format(DateTimeFormatter.ofPattern("yy/MM/dd"));
    }

    private Destination prepareDestinationEntityToSave(TripDTO tripDTO){
        return tripRepositoriesFacade.getDestinationByName(tripDTO.getDestination().getDestination()).orElseThrow(NoSuchElementException::new);
    }

    private User prepareUserEntityToSave(TripDTO tripDTO){
        return userRepositoriesFacade.getUserByUsername(tripDTO.getUserDTO().getUsername()).orElseThrow(NoSuchElementException::new);
    }

    private double calculateTripCost(TripDTO tripDTO){
        double cost = tripDTO.getNormalTickets()*tripDTO.getDestination().getNormalPrice();
        cost += tripDTO.getReducedTickets()*tripDTO.getDestination().getReducedPrice();
        return cost;
    }

    private static final String DESTINATION_ERROR = "Fatal error. This destination does not exist in database.";
}
