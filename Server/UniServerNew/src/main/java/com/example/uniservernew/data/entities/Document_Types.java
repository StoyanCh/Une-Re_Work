package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "document_types")
public class Document_Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int document_type_id;

    @Column(nullable = false, updatable = false)
    public String document_type;
}
