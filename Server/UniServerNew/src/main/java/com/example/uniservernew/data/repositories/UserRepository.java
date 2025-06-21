package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUser_email_address_personal(String email);
    Optional<Users> findById(int id);

    boolean existsByUser_egn(String egn);
    boolean existsByUser_email_address_personal(String email);

    List<Users> findByUser_role_U_role_name(String roleName);
}
