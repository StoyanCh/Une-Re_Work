package com.example.uniservernew.data.entities;


import jakarta.persistence.*;

@Entity(name = "faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int faculty_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String faculty_name;

    public int getFaculty_id() {
        return faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }
}



