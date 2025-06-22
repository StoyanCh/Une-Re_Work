package com.example.uniservernew.data.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int faculty_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String facultyName;

    public int getFaculty_id() {
        return faculty_id;
    }

    public String getfacultyName() {
        return facultyName;
    }

    public void setfacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return faculty_id == faculty.faculty_id && Objects.equals(facultyName, faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty_id, facultyName);
    }
}



