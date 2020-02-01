package com.github.vihaan.tripswebsite.users;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    @NotEmpty
    @Size(min = 5, max = 30)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 30)
    private String password;

    private Set<RoleDTO> roles;

    public UserDTO() { }
    public UserDTO(@NotEmpty String username, @NotEmpty @Size(min = 8, max = 30) String password) {
        this.username = username;
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
        return Objects.equals(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
