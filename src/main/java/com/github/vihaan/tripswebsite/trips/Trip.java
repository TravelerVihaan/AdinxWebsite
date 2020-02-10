package com.github.vihaan.tripswebsite.trips;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @Column(name = "id_trip")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "trip_date", nullable = false)
    private LocalDateTime tripDate;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "nomral_tickets", nullable = false)
    private int normalTickets;

    @Column(name = "reduced_tickets", nullable = false)
    private int reducedTickets;

    @Column(name = "trip_cost", nullable = false)
    private double tripCost;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String voucherNumber;

    @ManyToOne
    @JoinColumn(name="destination_id")
    private Destination tripDestination;

    public Trip(){}
    public Trip(LocalDateTime tripDate, Destination tripDestination,
                String personName, int normalTickets, int reducedTickets,
                String username) {
        this.tripDate = tripDate;
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

    public LocalDateTime getTripDate() { return tripDate; }

    public void setTripDate(LocalDateTime tripDate) { this.tripDate = tripDate; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(voucherNumber, trip.voucherNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherNumber);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripDate=" + tripDate +
                ", personName='" + personName + '\'' +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripCost=" + tripCost +
                ", username='" + username + '\'' +
                ", voucherNumber='" + voucherNumber + '\'' +
                ", tripDestination=" + tripDestination +
                '}';
    }
}
