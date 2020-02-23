package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.trips.Trip;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "hotel_name", unique = true, nullable = false)
    private String fullHotelName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "register_date", nullable = false)
    private LocalDateTime registerDate;

    @Column(name = "hotel_address", nullable = false)
    private String hotelAddress;

    @OneToMany(mappedBy= "tripDestination")
    private List<Trip> trips;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "id_user")},
            inverseJoinColumns = {@JoinColumn(name="role_id",
                    referencedColumnName = "id_role")})
    private Set<Role> roles;

    public User() {}
    public User(String username, String password, String fullHotelName, String hotelAddress){
        this.username = username;
        this.password = password;
        this.fullHotelName = fullHotelName;
        this.registerDate = LocalDateTime.now();
        this.hotelAddress = hotelAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullHotelName() {
        return fullHotelName;
    }

    public void setFullHotelName(String fullHotelName) {
        this.fullHotelName = fullHotelName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(fullHotelName, user.fullHotelName) &&
                Objects.equals(registerDate, user.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullHotelName, registerDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullHotelName='" + fullHotelName + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", hotelAddress='" + hotelAddress + '\'' +
                '}';
    }
}
