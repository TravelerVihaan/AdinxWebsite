package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.users.User;

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

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "nomral_tickets", nullable = false)
    private int normalTickets;

    @Column(name = "reduced_tickets", nullable = false)
    private int reducedTickets;

    @Column(name = "trip_cost", nullable = false)
    private double tripCost;

    @Column(name = "voucher_number", nullable = false, unique = true)
    private String voucherNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination tripDestination;

    public Trip() {
    }
    public Trip(LocalDateTime tripDate, Destination tripDestination,
                String personName, int normalTickets, int reducedTickets,
                String username, LocalDateTime orderDate, String voucherNumber, User user) {
        this.tripDate = tripDate;
        this.tripDestination = tripDestination;
        this.normalTickets = normalTickets;
        this.reducedTickets = reducedTickets;
        this.orderDate = orderDate;
        this.voucherNumber = voucherNumber;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Destination getTripDestination() {
        return tripDestination;
    }

    public void setTripDestination(Destination tripDestination) {
        this.tripDestination = tripDestination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(orderDate, trip.orderDate) &&
                Objects.equals(voucherNumber, trip.voucherNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, voucherNumber);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripDate=" + tripDate +
                ", orderDate=" + orderDate +
                ", normalTickets=" + normalTickets +
                ", reducedTickets=" + reducedTickets +
                ", tripCost=" + tripCost +
                ", voucherNumber='" + voucherNumber + '\'' +
                '}';
    }
}
