package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "topic_tag")
public class Topic_Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topic_tag_id;

    @Column(nullable = false,updatable = false, columnDefinition = "varchar(255")
    private String topic_tag_name;
}
