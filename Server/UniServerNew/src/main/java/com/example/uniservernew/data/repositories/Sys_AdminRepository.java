package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Sys_Admin;
import com.example.uniservernew.data.entities.SysAdminId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.Date;

@Repository
public interface Sys_AdminRepository extends JpaRepository<Sys_Admin, SysAdminId> {

    Optional<Sys_Admin> findBySysAdminEmailAddress(String email);

    List<Sys_Admin> findByIsActiveTrue();

    List<Sys_Admin> findByLastLoginBetween(Date from, Date to);

    List<Sys_Admin> findBySysAdmin_UserLastNameContainingIgnoreCase(String lastName);
}