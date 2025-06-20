package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "students")
public class Students {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Users student;

    @Column(updatable = false, nullable = false, columnDefinition = "date")
    public Date year_of_enrolling;

    @ManyToOne
    @JoinColumn(name = "student_speciality")
    private Specialities speciality;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(8)")
    public String faculty_number;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String student_email_address_uni;




}
