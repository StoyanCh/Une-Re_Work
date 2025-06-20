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
    private Set<Academic_Titles> teacher_titles = new HashSet<>();


}
