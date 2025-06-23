package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.AdminEmployeeId;
import com.example.uniservernew.data.entities.Administrative_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministrativeEmployeeRepository extends JpaRepository<Administrative_Employee, AdminEmployeeId> {
   Optional<Administrative_Employee> findByAdministrativeEmployeeEmailUni(String emailUni);

    List<Administrative_Employee> findByAdministrativeEmployee_UserFirstNameContainingIgnoreCase(String userFirstName); // ако Users има такова поле

    List<Administrative_Employee> findByAdministrativeEmployee_UserRole_RoleName(String userRole);
}
