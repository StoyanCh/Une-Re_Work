package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Users student;

    @Column(updatable = false, nullable = false, columnDefinition = "date")
    public Date yearOfEnrolling;

    @ManyToOne
    @JoinColumn(name = "student_speciality")
    public Speciality speciality;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(8)")
    public String facultyNumber;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String studentEmailAddressUni;

    public Users getStudent() {
        return student;
    }

    public void setStudent(Users student) {
        this.student = student;
    }

    public Date getYearOfEnrolling() {
        return yearOfEnrolling;
    }

    public void setYearOfEnrolling(Date yearOfEnrolling) {
        this.yearOfEnrolling = yearOfEnrolling;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getStudentEmailAddressUni() {
        return studentEmailAddressUni;
    }

    public void setStudentEmailAddressUni(String studentEmailAddressUni) {
        this.studentEmailAddressUni = studentEmailAddressUni;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(this.student, student.student) && Objects.equals(yearOfEnrolling, student.yearOfEnrolling) && Objects.equals(speciality, student.speciality) && Objects.equals(facultyNumber, student.facultyNumber) && Objects.equals(studentEmailAddressUni, student.studentEmailAddressUni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, yearOfEnrolling, speciality, facultyNumber, studentEmailAddressUni);
    }
}
