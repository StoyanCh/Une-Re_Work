package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "student_departments")
public class Student_Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int student_department_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String student_department_name;

    @ManyToOne
    @JoinColumn(name = "part_of_faculty")
    private Faculties faculties;

}
