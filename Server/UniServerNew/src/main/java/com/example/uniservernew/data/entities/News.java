package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.HTML;
import java.time.LocalDate;
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
    public String content;

    @Lob
    @Column(nullable = false,updatable = false,columnDefinition = "TEXT")
    public String short_resume;

    @Column(nullable = false)
    @CreationTimestamp
    public Date date_of_publish;

    @ManyToOne
    @JoinColumn(name = "author_id")
    public Users author;

    @Column(nullable = false)
    public String photo_path;

    @Column(nullable = false)
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    public Topic_Tag topic;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    public Faculties faculty;

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShort_resume() {
        return short_resume;
    }

    public void setShort_resume(String short_resume) {
        this.short_resume = short_resume;
    }

    public Date getDate_of_publish() {
        return date_of_publish;
    }

    public void setDate_of_publish(Date date_of_publish) {
        this.date_of_publish = date_of_publish;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Topic_Tag getTopic() {
        return topic;
    }

    public void setTopic(Topic_Tag topic) {
        this.topic = topic;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
}
