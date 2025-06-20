package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "file_types")
public class File_Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int file_type_id;

    @Column(nullable = false, updatable = false)
    public String file_type;
}
