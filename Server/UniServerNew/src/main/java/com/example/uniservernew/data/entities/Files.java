package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.yaml.snakeyaml.events.Event;

import java.util.Date;

@Entity(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int file_id;

    @Column(updatable = false, nullable = false)
    public String file_title;

    @Column(updatable = false, nullable = false)
    public String file_path;

    @ManyToOne
    @JoinColumn(name = "file_type")
    private Files file_type;

    @Column(nullable = false)
    @CreationTimestamp
    public Date uploaded_date;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private Users uploader;

}
