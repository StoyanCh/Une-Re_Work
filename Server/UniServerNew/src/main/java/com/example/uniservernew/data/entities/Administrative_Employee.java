package com.example.uniservernew.data.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "administrative_employee")
public class Administrative_Employee {

    @Id
    @ManyToOne
    @JoinColumn(name = "a_employee_id")
    public Users A_employee;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String A_employeeEmailUni;

    public Users getA_employee() {
        return A_employee;
    }

    public void setA_employee(Users aEmployee) {
        this.A_employee = aEmployee;
    }

    public String getA_employeeEmailUni() {
        return A_employeeEmailUni;
    }

    public void setA_employeeEmailUni(String A_employeeEmailUni) {
        this.A_employeeEmailUni = A_employeeEmailUni;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Administrative_Employee that = (Administrative_Employee) o;
        return Objects.equals(A_employee, that.A_employee) && Objects.equals(A_employeeEmailUni, that.A_employeeEmailUni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_employee, A_employeeEmailUni);
    }
}
