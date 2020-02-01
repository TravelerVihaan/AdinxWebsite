package com.github.vihaan.tripswebsite.trips;

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
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "nomral_tickets", nullable = false)
    private int normalTickets;

    @Column(name = "reduced_tickets", nullable = false)
    private int reducedTickets;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name="destination_id")
    private Destination tripDestination;

    public Trip(){}
    public Trip(LocalDate startDate, LocalDate endDate, Destination tripDestination,
                String personName, int normalTickets, int reducedTickets,
                String username) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripDestination = tripDestination;
        this.personName = personName;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id &&
                normalTickets == trip.normalTickets &&
                reducedTickets == trip.reducedTickets &&
                Objects.equals(startDate, trip.startDate) &&
                Objects.equals(endDate, trip.endDate) &&
                Objects.equals(personName, trip.personName) &&
                Objects.equals(username, trip.username) &&
                Objects.equals(tripDestination, trip.tripDestination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, personName, normalTickets, reducedTickets, username, tripDestination);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", username='" + username + '\'' +
                ", tripDestination=" + tripDestination +
                '}';
    }
}
