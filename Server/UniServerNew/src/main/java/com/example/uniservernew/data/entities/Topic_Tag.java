package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

@Entity(name = "topic_tag")
public class Topic_Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topic_tag_id;

    @Column(nullable = false,updatable = false, columnDefinition = "varchar(255")
    public String topic_tag_name;

    public int getTopic_tag_id() {
        return topic_tag_id;
    }

    public String getTopic_tag_name() {
        return topic_tag_name;
    }

    public void setTopic_tag_name(String topic_tag_name) {
        this.topic_tag_name = topic_tag_name;
    }
}
