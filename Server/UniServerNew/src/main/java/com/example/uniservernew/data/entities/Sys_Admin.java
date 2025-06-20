package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "sys_admin")
public class Sys_Admin {

    @Id
    @ManyToOne
    @JoinColumn(name = "admin_id")
    public Users sysAdmin;

    @Column(nullable = false)
    @CreationTimestamp
    public Date last_login;

    @Column(nullable = false)
    private Boolean is_active;

    @Column(nullable = false)
    @CreationTimestamp
    public Date created_at;
}
