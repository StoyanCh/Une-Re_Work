package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.News;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findByNews_titleContainingIgnoreCase(String keyword);

    boolean existsByNews_title(String title);

    List<News> findByDate_of_publish(Date publishDate);

    List<News> findByTopic_Tag_TagName(String topicName);

    @Query("SELECT n FROM news n WHERE  n.faculty.faculty_name = :faculty")
    List<News> findByFaculty_FacultyName(String facultyName);

    @Query("SELECT n FROM news n WHERE n.active = true AND n.faculty.faculty_name = :faculty")
    List<News> findActiveNewsByFaculty(@Param("faculty") String facultyName);

    List<News> findByAuthor_StudentDepartment(String department);

    List<News> findByAuthor_Speciality(String speciality);


    List<News> findByActiveTrue();

    List<News> findByAuthor_User_id(int authorId);

    @Modifying
    @Transactional
    @Query("UPDATE news n SET n.active = :active WHERE n.news_id = :id")
    void updateNewsActiveStatus(@Param("id") int id, @Param("active") boolean active);

    void deleteByNews_id(Integer id);
}
