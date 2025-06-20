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
    private int u_role_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    private String u_role_name;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<User_Permissions> permissions = new HashSet<>();


}
