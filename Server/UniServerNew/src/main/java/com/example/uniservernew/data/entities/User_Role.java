package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int uRoleId;

    @Column(updatable = false, nullable = false, columnDefinition = "varchar(255)")
    public String roleName;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )

    public Set<User_Permission> permissions = new HashSet<>();

    public int getuRoleId() {
        return uRoleId;
    }

    public void setuRoleId(int uRoleId) {
        this.uRoleId = uRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User_Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<User_Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User_Role userRoles = (User_Role) o;
        return uRoleId == userRoles.uRoleId && Objects.equals(roleName, userRoles.roleName) && Objects.equals(permissions, userRoles.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uRoleId, roleName, permissions);
    }
}
