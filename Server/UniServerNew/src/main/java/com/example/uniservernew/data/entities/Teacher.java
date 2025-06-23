package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {

    @EmbeddedId
    private TeacherId teacherId;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Users teacher;


    @Column(nullable = false)
    public Boolean teacherStatus;

    @Column(updatable = false, nullable = false, columnDefinition = "varchar(255)")
    public String teacherEmailAddressUni;

    @ManyToMany
    @JoinTable(
            name = "teachers_atitles",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "academic_title_id")
    )
    public Set<Academic_Title> teacherTitles = new HashSet<>();


    public TeacherId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherId teacherId) {
        this.teacherId = teacherId;
    }

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
        Teacher teacher1 = (Teacher) o;
        return Objects.equals(teacherId, teacher1.teacherId) && Objects.equals(teacher, teacher1.teacher) && Objects.equals(teacherStatus, teacher1.teacherStatus) && Objects.equals(teacherEmailAddressUni, teacher1.teacherEmailAddressUni) && Objects.equals(teacherTitles, teacher1.teacherTitles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacher, teacherStatus, teacherEmailAddressUni, teacherTitles);
    }
}