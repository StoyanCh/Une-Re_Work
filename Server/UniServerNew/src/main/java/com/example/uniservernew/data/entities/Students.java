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
    public Specialities speciality;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(8)")
    public String faculty_number;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String student_email_address_uni;

    public Users getStudent() {
        return student;
    }

    public void setStudent(Users student) {
        this.student = student;
    }

    public Date getYear_of_enrolling() {
        return year_of_enrolling;
    }

    public void setYear_of_enrolling(Date year_of_enrolling) {
        this.year_of_enrolling = year_of_enrolling;
    }

    public Specialities getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialities speciality) {
        this.speciality = speciality;
    }

    public String getFaculty_number() {
        return faculty_number;
    }

    public void setFaculty_number(String faculty_number) {
        this.faculty_number = faculty_number;
    }

    public String getStudent_email_address_uni() {
        return student_email_address_uni;
    }

    public void setStudent_email_address_uni(String student_email_address_uni) {
        this.student_email_address_uni = student_email_address_uni;
    }
}
