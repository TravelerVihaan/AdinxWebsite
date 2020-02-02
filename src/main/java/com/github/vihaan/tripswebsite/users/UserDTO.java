package com.github.vihaan.tripswebsite.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    @NotEmpty
    @Size(min = 5, max = 30)
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 8, max = 30)
    private String password;

    @NotEmpty
    private LocalDateTime registerDate;

    private Set<RoleDTO> roles;

    public UserDTO() { }
    public UserDTO(@NotEmpty @Size(min = 5, max = 30) String username,
                   @Email @NotEmpty String email,
                   @NotEmpty @Size(min = 8, max = 30) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(registerDate, userDTO.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, registerDate);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", roles=" + roles +
                '}';
    }
}
