package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "permissions")
public class User_Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int uPermissionsId;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String permissionName;

    public int getuPermissionsId() {
        return uPermissionsId;
    }

    public void setuPermissionsId(int uPermissionsId) {
        this.uPermissionsId = uPermissionsId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User_Permission that = (User_Permission) o;
        return uPermissionsId == that.uPermissionsId && Objects.equals(permissionName, that.permissionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uPermissionsId, permissionName);
    }
}
