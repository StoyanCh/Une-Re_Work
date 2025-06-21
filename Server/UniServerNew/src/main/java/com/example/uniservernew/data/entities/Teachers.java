package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity (name = "teachers")
public class Teachers {

    @Id
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Users teacher;

    @Column(nullable = false)
    public Boolean teacher_status;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String teacher_email_address_uni;

    @ManyToMany
    @JoinTable(
            name = "teachers_atitles",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "academic_title_id")
    )
    public Set<Academic_Titles> teacher_titles = new HashSet<>();

    public Users getTeacher() {
        return teacher;
    }

    public void setTeacher(Users teacher) {
        this.teacher = teacher;
    }

    public Boolean getTeacher_status() {
        return teacher_status;
    }

    public void setTeacher_status(Boolean teacher_status) {
        this.teacher_status = teacher_status;
    }

    public String getTeacher_email_address_uni() {
        return teacher_email_address_uni;
    }

    public void setTeacher_email_address_uni(String teacher_email_address_uni) {
        this.teacher_email_address_uni = teacher_email_address_uni;
    }

    public Set<Academic_Titles> getTeacher_titles() {
        return teacher_titles;
    }

    public void setTeacher_titles(Set<Academic_Titles> teacher_titles) {
        this.teacher_titles = teacher_titles;
    }
}
