package com.github.vihaan.tripswebsite.trips;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TripDTO {

    @NotEmpty(message = "{trip.empty.date}")
    @FutureOrPresent(message = "{trip.wrong.date}")
    private LocalDateTime tripDate;
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
    private String username;
    @NotEmpty
    private String voucherNumber;

    @NotNull
    private DestinationDTO destination;

    public TripDTO() { }
    public TripDTO(@NotEmpty LocalDateTime tripDate,
                   @NotEmpty String personName,
                   @NotNull int normalTickets,
                   @NotNull int reducedTickets,
                   @NotEmpty String username) {
        this.tripDate = tripDate;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
        this.username = username;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public String getPersonName() {
        return personName;
    }

    public int getNormalTickets() {
        return normalTickets;
    }

    public int getReducedTickets() {
        return reducedTickets;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setNormalTickets(int normalTickets) {
        this.normalTickets = normalTickets;
    }

    public void setReducedTickets(int reducedTickets) {
        this.reducedTickets = reducedTickets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public String getVoucherNumber() { return voucherNumber; }

    public void setVoucherNumber(String voucherNumber) { this.voucherNumber = voucherNumber; }

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
        return Objects.equals(username, tripDTO.username) &&
                Objects.equals(voucherNumber, tripDTO.voucherNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, voucherNumber);
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "tripDate=" + tripDate +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripCost=" + tripCost +
                ", username='" + username + '\'' +
                ", voucherNumber='" + voucherNumber + '\'' +
                ", destination=" + destination +
                '}';
    }
}
