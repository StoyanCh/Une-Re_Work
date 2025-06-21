package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Administrative_Employee;
import com.example.uniservernew.data.entities.Faculties;
import com.example.uniservernew.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeEmployeeRepository extends JpaRepository<Administrative_Employee, Integer> {
    boolean existsByAEmployee(Users user);
}
