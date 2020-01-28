package com.github.vihaan.adinxwebsite.trips;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @Column(name = "id_trip")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "nomral_tickets", nullable = false)
    private int normalTickets;

    @Column(name = "reduced_tickets", nullable = false)
    private int reducedTickets;

    @ManyToOne
    @JoinColumn(name="destination_id")
    private Destination tripDestination;

    public Trip(){}
    public Trip(LocalDate start_date, LocalDate end_date, Destination tripDestination,
                String personName, int normalTickets, int reducedTickets) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.tripDestination = tripDestination;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Destination getTripDestination() {
        return tripDestination;
    }

    public void setTripDestination(Destination tripDestination) {
        this.tripDestination = tripDestination;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id &&
                normalTickets == trip.normalTickets &&
                reducedTickets == trip.reducedTickets &&
                Objects.equals(start_date, trip.start_date) &&
                Objects.equals(end_date, trip.end_date) &&
                Objects.equals(personName, trip.personName) &&
                Objects.equals(tripDestination, trip.tripDestination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, end_date, personName, normalTickets, reducedTickets, tripDestination);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripDestination=" + tripDestination +
                '}';
    }
}
