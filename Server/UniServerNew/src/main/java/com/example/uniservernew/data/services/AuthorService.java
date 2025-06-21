package com.example.uniservernew.data.services;

import com.example.uniservernew.data.entities.Faculties;
import com.example.uniservernew.data.entities.News;
import com.example.uniservernew.data.entities.Topic_Tag;
import com.example.uniservernew.data.entities.Users;
import com.example.uniservernew.data.repositories.FacultiesRepository;
import com.example.uniservernew.data.repositories.NewsRepository;
import com.example.uniservernew.data.repositories.Topic_TagRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AuthorService {

    private final NewsRepository newsRepository;
    private final Topic_TagRepository topic_TagRepository;
    private final FacultiesRepository facultiesRepository;


    public AuthorService(Topic_TagRepository topic_TagRepository, NewsRepository newsRepository,FacultiesRepository facultiesRepository) {
        this.newsRepository = newsRepository;
        this.topic_TagRepository = topic_TagRepository;
        this.facultiesRepository = facultiesRepository;
    }


    @PreAuthorize("@securityService.isAuthoringAdmin()")
    public void createArticle(String title, String content, String shortResume,
                              Date dateOfPublish, String photo_path,
                              Boolean active, String topic, String faculty) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new RuntimeException("Невалиден достъп до потребител");
        }

        Users author = (Users) auth.getPrincipal();

        Topic_Tag selectedTopic = topic_TagRepository.findByTagName(topic)
                .orElseThrow(() -> new IllegalArgumentException("Няма такава тема: " + topic));


        Faculties selectedFaculty = facultiesRepository.findByFacultyName(faculty)
                .orElseThrow(() -> new IllegalArgumentException("Невалиден факултет: " + faculty));

        News news = new News();
        news.setNews_title(title);
        news.setContent(content);
        news.setShort_resume(shortResume);
        news.setDate_of_publish(dateOfPublish);
        news.setAuthor(author);
        news.setPhoto_path(photo_path);
        news.setActive(active);
        news.setTopic(selectedTopic);
        news.setFaculty(selectedFaculty);

        newsRepository.save(news);

        System.out.println("📄 Статията е създадена успешно от потребителя: " + author.getUser_first_name());
    }
}