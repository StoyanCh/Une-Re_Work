package com.example.uniservernew.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.uniservernew.data.entities.Sys_Admin;
import com.example.uniservernew.data.entities.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Sys_Admin, Integer> {

    Optional<Sys_Admin> findBySysAdmin(Users user);

    boolean existsBySysAdmin_User_id(int userId);

    Optional<Sys_Admin> findBySysAdmin_User_email_address_personal(String email);

    Optional<Sys_Admin> findTopByOrderByLast_loginDesc();
}
