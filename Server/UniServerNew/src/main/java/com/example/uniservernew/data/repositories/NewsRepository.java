package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {

    public News findByName(String name);

    public List<News> findAllByOrderBy(Date createdAt);

    public List<News> findAllByOrderByCreatedAtDesc();

    public List<News> findAllByOrderByCreatedAtAcs(Date createdAt);

    public List<News> findAllByTopic(String topic);

    public List<News> findAllByFaculty(String faculty);

    public News create(News news);

    public News update(News news);

    public News delete(String id);
}
