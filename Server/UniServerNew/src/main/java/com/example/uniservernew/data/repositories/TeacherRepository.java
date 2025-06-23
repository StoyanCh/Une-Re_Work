package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Academic_Title;
import com.example.uniservernew.data.entities.Teacher;
import com.example.uniservernew.data.entities.TeacherId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, TeacherId> {
    public Teacher findByTeacherId(TeacherId teacherId);

    public Teacher findByTeacherEmailAddressUni(String email);

    List<Teacher> findByTeacherTitles(Set<Academic_Title> teacherTitles);
}