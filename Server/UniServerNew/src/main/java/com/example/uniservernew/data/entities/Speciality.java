package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "specialities")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int specialityId;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String specialityName;

    @ManyToOne
    @JoinColumn(name = "part_of_s_department_id")
    private Student_Department studentDepartments;

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public Student_Department getStudentDepartments() {
        return studentDepartments;
    }

    public void setStudentDepartments(Student_Department studentDepartments) {
        this.studentDepartments = studentDepartments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return specialityId == that.specialityId && Objects.equals(specialityName, that.specialityName) && Objects.equals(studentDepartments, that.studentDepartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialityId, specialityName, studentDepartments);
    }
}
