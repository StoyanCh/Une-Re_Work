package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "students")
public class Student {

    @EmbeddedId
    private StudentId studentId;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Users student;

    @Column(updatable = false, nullable = false, columnDefinition = "date")
    public Date yearOfEnrolling;

    @ManyToOne
    @JoinColumn(name = "student_speciality")
    public Speciality speciality;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(8)")
    public String facultyNumber;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String studentEmailAddressUni;

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

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
        Student student1 = (Student) o;
        return Objects.equals(studentId, student1.studentId) && Objects.equals(student, student1.student) && Objects.equals(yearOfEnrolling, student1.yearOfEnrolling) && Objects.equals(speciality, student1.speciality) && Objects.equals(facultyNumber, student1.facultyNumber) && Objects.equals(studentEmailAddressUni, student1.studentEmailAddressUni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, student, yearOfEnrolling, speciality, facultyNumber, studentEmailAddressUni);
    }
}
