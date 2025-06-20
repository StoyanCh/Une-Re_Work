package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "permissions")
public class User_Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int u_permissions_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    private String u_permissions_name;

}
