package com.github.vihaan.adinxwebsite.users;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

public class RoleDTO {

    @NotEmpty
    private String role;

    private List<UserDTO> users;

    public RoleDTO() { }
    public RoleDTO(@NotEmpty String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(role, roleDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "role='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}
