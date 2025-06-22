package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Users teacher;

    @Column(nullable = false)
    public Boolean teacherStatus;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String teacherEmailAddressUni;

    @ManyToMany
    @JoinTable(
            name = "teachers_atitles",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "academic_title_id")
    )
    public Set<Academic_Title> teacherTitles = new HashSet<>();

    public Users getTeacher() {
        return teacher;
    }

    public void setTeacher(Users teacher) {
        this.teacher = teacher;
    }

    public Boolean getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Boolean teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getTeacherEmailAddressUni() {
        return teacherEmailAddressUni;
    }

    public void setTeacherEmailAddressUni(String teacherEmailAddressUni) {
        this.teacherEmailAddressUni = teacherEmailAddressUni;
    }

    public Set<Academic_Title> getTeacherTitles() {
        return teacherTitles;
    }

    public void setTeacherTitles(Set<Academic_Title> teacherTitles) {
        this.teacherTitles = teacherTitles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(this.teacher, teacher.teacher) && Objects.equals(teacherStatus, teacher.teacherStatus) && Objects.equals(teacherEmailAddressUni, teacher.teacherEmailAddressUni) && Objects.equals(teacherTitles, teacher.teacherTitles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, teacherStatus, teacherEmailAddressUni, teacherTitles);
    }
}