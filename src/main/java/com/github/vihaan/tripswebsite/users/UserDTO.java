package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.trips.Trip;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    @NotEmpty(message = "{user.empty.username}")
    @Size(min = 5, max = 30, message = "{user.username.length}")
    private String username;

    @Email(message = "{user.wrong.email.syntax}")
    @NotEmpty(message = "{user.empty.email}")
    private String email;

    @NotEmpty(message = "{user.empty.password}")
    @Size(min = 8, max = 30, message = "{user.password.length}")
    private String password;

    @NotEmpty(message = "{user.empty.hotelName}")
    private String fullHotelName;

    @NotEmpty
    private LocalDateTime registerDate;

    @NotEmpty(message = "{user.empty.hotelAddress}")
    private String hotelAddress;

    private Set<RoleDTO> roles;

    private List<Trip> trips;

    public UserDTO() { }
    public UserDTO(@NotEmpty(message = "{user.empty.username}") @Size(min = 5, max = 30, message = "{user.username.length}") String username,
                   @Email(message = "{user.wrong.email.syntax}") @NotEmpty(message = "{user.empty.email}") String email,
                   @NotEmpty(message = "{user.empty.password}") @Size(min = 8, max = 30, message = "{user.password.length}") String password,
                   @NotEmpty(message = "{user.empty.hotelName}") String fullHotelName,
                   @NotEmpty(message = "{user.empty.hotelAddress}") String hotelAddress) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullHotelName = fullHotelName;
        this.hotelAddress = hotelAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullHotelName() {
        return fullHotelName;
    }

    public void setFullHotelName(String fullHotelName) {
        this.fullHotelName = fullHotelName;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username) &&
                Objects.equals(fullHotelName, userDTO.fullHotelName) &&
                Objects.equals(registerDate, userDTO.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullHotelName, registerDate);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullHotelName='" + fullHotelName + '\'' +
                ", registerDate=" + registerDate +
                ", hotelAddress='" + hotelAddress + '\'' +
                '}';
    }
}
