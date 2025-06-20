package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "academic_titles")
public class Academic_Titles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int academic_title_id;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String academic_title_name;
}
