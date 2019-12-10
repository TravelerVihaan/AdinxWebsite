package com.github.vihaan.adinxwebsite.users;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id_role")
    private Long id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String role;

    public Role() {}
    public Role(String role){
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
