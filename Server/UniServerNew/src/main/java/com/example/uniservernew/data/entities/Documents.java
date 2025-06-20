package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.DocumentType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int document_id;

    @Column(updatable = false, nullable = false)
    public String document_title;

    @ManyToOne
    @JoinColumn(name = "doc_type")
    private Document_Types document_type;

    @Column(nullable = false)
    @CreationTimestamp
    public Date uploaded_date;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private Users uploader;

    @Column(updatable = false,nullable = false)
    private String doc_path;

    @ManyToMany
    @JoinTable(
            name = "document_files",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private Set<Files> files = new HashSet<>();

}
