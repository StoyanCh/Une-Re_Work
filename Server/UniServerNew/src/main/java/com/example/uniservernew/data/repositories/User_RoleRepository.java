package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface User_RoleRepository extends JpaRepository<User_Role, Integer> {

    Optional<User_Role> findByRoleName(String roleName);

    List<User_Role> findAllByOrderByRoleNameAsc();

    List<User_Role> findByPermissions_PermissionName(String permissionName); // ако искаш да търсиш по права
}