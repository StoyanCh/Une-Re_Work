package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId;

    @Column(nullable = false,updatable = false, columnDefinition = "varchar(255")
    public String newsTitle;

    @Lob
    @Column(nullable = false,updatable = false,columnDefinition = "TEXT")
    public String content;

    @Lob
    @Column(nullable = false,updatable = false,columnDefinition = "TEXT")
    public String shortResume;

    @Column(nullable = false)
    @CreationTimestamp
    public Date dateOfPublish;

    @ManyToOne
    @JoinColumn(name = "author_id")
    public Users author;

    @Column(nullable = false)
    public String photoPath;

    @Column(nullable = false)
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    public Topic_Tag topic;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    public Faculty faculty;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShortResume() {
        return shortResume;
    }

    public void setShortResume(String shortResume) {
        this.shortResume = shortResume;
    }

    public Date getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId && Objects.equals(newsTitle, news.newsTitle) && Objects.equals(content, news.content) && Objects.equals(shortResume, news.shortResume) && Objects.equals(dateOfPublish, news.dateOfPublish) && Objects.equals(author, news.author) && Objects.equals(photoPath, news.photoPath) && Objects.equals(active, news.active) && Objects.equals(topic, news.topic) && Objects.equals(faculty, news.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsTitle, content, shortResume, dateOfPublish, author, photoPath, active, topic, faculty);
    }
}
