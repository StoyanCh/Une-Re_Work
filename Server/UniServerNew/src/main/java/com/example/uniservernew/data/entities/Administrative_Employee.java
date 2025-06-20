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
}
