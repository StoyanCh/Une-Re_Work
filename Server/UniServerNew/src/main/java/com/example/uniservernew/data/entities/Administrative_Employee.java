package com.example.uniservernew.data.entities;


import jakarta.persistence.*;

@Entity(name = "administrative_employee")
public class Administrative_Employee {

    @Id
    @ManyToOne
    @JoinColumn(name = "a_employee_id")
    public Users a_employee;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String a_employee_email_address_uni;

    public Users getA_employee() {
        return a_employee;
    }

    public void setA_employee(Users a_employee) {
        this.a_employee = a_employee;
    }

    public String getA_employee_email_address_uni() {
        return a_employee_email_address_uni;
    }

    public void setA_employee_email_address_uni(String a_employee_email_address_uni) {
        this.a_employee_email_address_uni = a_employee_email_address_uni;
    }
}
