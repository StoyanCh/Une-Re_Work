package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user_roles")
public class User_Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int u_role_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String u_role_name;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )

    public Set<User_Permissions> permissions = new HashSet<>();

    public int getU_role_id() {
        return u_role_id;
    }

    public void setU_role_id(int u_role_id) {
        this.u_role_id = u_role_id;
    }

    public String getU_role_name() {
        return u_role_name;
    }

    public void setU_role_name(String u_role_name) {
        this.u_role_name = u_role_name;
    }
}
