package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "specialities")
public class Specialities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int speciality_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String speciality_name;

    @ManyToOne
    @JoinColumn(name = "part_of_s_department_id")
    private Student_Departments student_departments;
}
