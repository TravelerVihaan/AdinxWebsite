package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.users.UserDTO;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TripDTO {

    @NotEmpty(message = "{trip.empty.date}")
    @FutureOrPresent(message = "{trip.wrong.date}")
    private LocalDateTime tripDate;
    @NotEmpty
    private LocalDateTime orderDate;
    @NotEmpty(message = "{trip.empty.personname}")
    private String personName;
    @NotNull(message = "{trip.null.tickets}")
    private int normalTickets;
    @NotNull(message = "{trip.null.tickets}")
    private int reducedTickets;
    @NotNull
    @PositiveOrZero
    private double tripCost;
    @NotEmpty
    private String voucherNumber;
    @NotNull
    private UserDTO userDTO;


    @NotNull
    private DestinationDTO destination;

    public TripDTO() { }
    public TripDTO(@NotEmpty LocalDateTime tripDate,
                   @NotEmpty LocalDateTime orderDate,
                   @NotEmpty String personName,
                   @NotNull int normalTickets,
                   @NotNull int reducedTickets,
                   @NotNull UserDTO userDTO
                   ) {
        this.tripDate = tripDate;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
        this.orderDate = orderDate;
        this.userDTO = userDTO;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getNormalTickets() {
        return normalTickets;
    }

    public void setNormalTickets(int normalTickets) {
        this.normalTickets = normalTickets;
    }

    public int getReducedTickets() {
        return reducedTickets;
    }

    public void setReducedTickets(int reducedTickets) {
        this.reducedTickets = reducedTickets;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public DestinationDTO getDestination() {
        return destination;
    }

    public void setDestination(DestinationDTO destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDTO tripDTO = (TripDTO) o;
        return normalTickets == tripDTO.normalTickets &&
                reducedTickets == tripDTO.reducedTickets &&
                Double.compare(tripDTO.tripCost, tripCost) == 0 &&
                Objects.equals(tripDate, tripDTO.tripDate) &&
                Objects.equals(orderDate, tripDTO.orderDate) &&
                Objects.equals(personName, tripDTO.personName) &&
                Objects.equals(voucherNumber, tripDTO.voucherNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripDate, orderDate, personName, normalTickets, reducedTickets, tripCost, voucherNumber);
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "tripDate=" + tripDate +
                ", orderDate=" + orderDate +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripCost=" + tripCost +
                ", voucherNumber='" + voucherNumber + '\'' +
                '}';
    }
}
