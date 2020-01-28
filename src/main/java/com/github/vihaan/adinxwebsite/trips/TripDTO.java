package com.github.vihaan.adinxwebsite.trips;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class TripDTO {

    @NotEmpty
    private LocalDate start_date;
    @NotEmpty
    private LocalDate end_date;
    @NotEmpty
    private String personName;
    @NotNull
    private int normalTickets;
    @NotNull
    private int reducedTickets;

    @NotNull
    private DestinationDTO destination;

    public TripDTO() { }

    public TripDTO(@NotEmpty LocalDate start_date,
                   @NotEmpty LocalDate end_date,
                   @NotEmpty String personName,
                   @NotNull int normalTickets,
                   @NotNull int reducedTickets) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
    }

    public TripDTO(@NotEmpty @Future LocalDate start_date, @NotEmpty @Future LocalDate end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
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
                Objects.equals(start_date, tripDTO.start_date) &&
                Objects.equals(end_date, tripDTO.end_date) &&
                Objects.equals(personName, tripDTO.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_date, end_date, personName, normalTickets, reducedTickets);
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "start_date=" + start_date +
                ", end_date=" + end_date +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", destination=" + destination +
                '}';
    }
}
