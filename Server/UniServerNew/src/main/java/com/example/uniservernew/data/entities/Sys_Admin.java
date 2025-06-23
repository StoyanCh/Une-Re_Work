package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sys_admin")
public class Sys_Admin {

    @EmbeddedId
    private SysAdminId sysAdminId;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Users sysAdmin;


    @Column(nullable = false)
    @CreationTimestamp
    public Date lastLogin;

    @Column(nullable = false)
    public Boolean isActive;

    @Column(nullable = false)
    @CreationTimestamp
    public Date createdAt;

    @Column(nullable = false)
    public String sysAdminEmailAddress;

    public SysAdminId getSysAdminId() {
        return sysAdminId;
    }

    public void setSysAdminId(SysAdminId sysAdminId) {
        this.sysAdminId = sysAdminId;
    }

    public Users getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(Users sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSysAdminEmailAddress() {
        return sysAdminEmailAddress;
    }

    public void setSysAdminEmailAddress(String sysAdminEmailAddress) {
        this.sysAdminEmailAddress = sysAdminEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sys_Admin sysAdmin1 = (Sys_Admin) o;
        return Objects.equals(sysAdminId, sysAdmin1.sysAdminId) && Objects.equals(sysAdmin, sysAdmin1.sysAdmin) && Objects.equals(lastLogin, sysAdmin1.lastLogin) && Objects.equals(isActive, sysAdmin1.isActive) && Objects.equals(createdAt, sysAdmin1.createdAt) && Objects.equals(sysAdminEmailAddress, sysAdmin1.sysAdminEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysAdminId, sysAdmin, lastLogin, isActive, createdAt, sysAdminEmailAddress);
    }
}
