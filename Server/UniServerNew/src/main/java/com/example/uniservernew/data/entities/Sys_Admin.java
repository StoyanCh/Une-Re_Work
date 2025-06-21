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
    public Boolean is_active;

    @Column(nullable = false)
    @CreationTimestamp
    public Date created_at;

    public Users getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(Users sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
