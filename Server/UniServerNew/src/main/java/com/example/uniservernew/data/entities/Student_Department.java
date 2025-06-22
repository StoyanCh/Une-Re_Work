package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_departments")
public class Student_Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int studentDepartmentId;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String studentDepartmentName;

    @ManyToOne
    @JoinColumn(name = "part_of_faculty")
    private Faculty faculty;

    public int getStudentDepartmentId() {
        return studentDepartmentId;
    }

    public void setStudentDepartmentId(int studentDepartmentId) {
        this.studentDepartmentId = studentDepartmentId;
    }

    public String getStudentDepartmentName() {
        return studentDepartmentName;
    }

    public void setStudentDepartmentName(String studentDepartmentName) {
        this.studentDepartmentName = studentDepartmentName;
    }

    public Faculty getFaculties() {
        return faculty;
    }

    public void setFaculties(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student_Department that = (Student_Department) o;
        return studentDepartmentId == that.studentDepartmentId && Objects.equals(studentDepartmentName, that.studentDepartmentName) && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentDepartmentId, studentDepartmentName, faculty);
    }
}
