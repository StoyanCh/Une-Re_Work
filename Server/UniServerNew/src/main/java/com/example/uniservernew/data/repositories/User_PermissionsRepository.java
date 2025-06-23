package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.User_Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface User_PermissionsRepository extends JpaRepository<User_Permission, Integer> {

    Optional<User_Permission> findByPermissionName(String permissionName);

    List<User_Permission> findAllByOrderByPermissionNameAsc();

    List<User_Permission> findAllByOrderByPermissionNameDesc();
}