package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Sys_Admin;
import com.example.uniservernew.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAdminRepository extends JpaRepository<Sys_Admin, Integer> {
    boolean existsBySysAdmin(Users user);
}
