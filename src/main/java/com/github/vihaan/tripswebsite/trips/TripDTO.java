package com.github.vihaan.tripswebsite.trips;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class TripDTO {

    @NotEmpty(message = "{trip.empty.date}")
    @FutureOrPresent(message = "{trip.wrong.start.date}")
    private LocalDate startDate;
    @NotEmpty(message = "{trip.empty.date}")
    @Future(message = "{trip.wrong.end.date}")
    private LocalDate endDate;
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

    @NotNull
    private DestinationDTO destination;

    public TripDTO() { }
    public TripDTO(@NotEmpty LocalDate startDate,
                   @NotEmpty LocalDate endDate,
                   @NotEmpty String personName,
                   @NotNull int normalTickets,
                   @NotNull int reducedTickets,
                   @NotEmpty String username) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
        this.username = username;
    }

    public TripDTO(@NotEmpty @Future LocalDate startDate, @NotEmpty @Future LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
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
                Objects.equals(startDate, tripDTO.startDate) &&
                Objects.equals(endDate, tripDTO.endDate) &&
                Objects.equals(personName, tripDTO.personName) &&
                Objects.equals(username, tripDTO.username) &&
                Objects.equals(destination, tripDTO.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, personName, normalTickets, reducedTickets, username, destination);
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripCost=" + tripCost +
                ", username='" + username + '\'' +
                ", destination=" + destination +
                '}';
    }
}
