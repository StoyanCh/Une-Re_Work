package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "topic_tag")
public class Topic_Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicTagId;

    @Column(nullable = false,updatable = false, columnDefinition = "varchar(255")
    public String topicTagName;

    public int getTopicTagId() {
        return topicTagId;
    }

    public void setTopicTagId(int topicTagId) {
        this.topicTagId = topicTagId;
    }

    public String getTopicTagName() {
        return topicTagName;
    }

    public void setTopicTagName(String topicTagName) {
        this.topicTagName = topicTagName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Topic_Tag topicTag = (Topic_Tag) o;
        return topicTagId == topicTag.topicTagId && Objects.equals(topicTagName, topicTag.topicTagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicTagId, topicTagName);
    }
}
