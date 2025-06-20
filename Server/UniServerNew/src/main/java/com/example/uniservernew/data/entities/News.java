package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.HTML;
import java.util.Date;

@Entity(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int news_id;

    @Column(nullable = false,updatable = false, columnDefinition = "varchar(255")
    public String news_title;

    @Lob
    @Column(nullable = false,updatable = false,columnDefinition = "TEXT")
    private String content;

    @Lob
    @Column(nullable = false,updatable = false,columnDefinition = "TEXT")
    private String short_resume;

    @Column(nullable = false)
    @CreationTimestamp
    public Date date_of_publish;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users author;

    @Column(nullable = false)
    public String photo_path;

    @Column(nullable = false)
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic_Tag topic;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculties faculty;
}
