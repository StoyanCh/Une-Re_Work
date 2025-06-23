package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Faculty;
import com.example.uniservernew.data.entities.News;
import com.example.uniservernew.data.entities.Topic_Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {

    public List<News> findByDateOfPublishBetween(Date start, Date end);

    public List<News> findByDateOfPublishAfter(Date start);
    
    public List<News> findByDateOfPublishBefore(Date end);

    List<News> findByTopic(Topic_Tag topic);

    List<News> findByFaculty(Faculty faculty);

    public News findBynewsTitle(String newsTitle);

    List<News> findByAuthor_UserFirstName(String authorUserFirstName);
    List<News> findByAuthor_UserLastName(String authorUserLastName);
}
