package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Administrative_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Administrative_EmployeeRepository extends JpaRepository<Administrative_Employee, Integer> {

    public Administrative_Employee findByEmployeeId(Integer employeeId);

    public Administrative_Employee findByEmployeeName(String employeeName);

    public Administrative_Employee findByEmploeeUni(String employeeEmailUni);

    public Administrative_Employee findByEmploeeRoleId(Integer employeeRoleId);

    public Administrative_Employee create(Administrative_Employee administrative_employee);

    public Administrative_Employee update(Administrative_Employee administrative_employee);

    public Administrative_Employee deleteBy(Administrative_Employee administrative_employee);
}
