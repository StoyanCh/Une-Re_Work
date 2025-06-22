package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Academic_Title;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicTitlesRepository extends JpaRepository<Academic_Title, Integer> {
    public Academic_Title findByTitle(String title);

    public Academic_Title create(Academic_Title academicTitle);

    public Academic_Title update(Academic_Title academicTitle);

    public Academic_Title deleteByTitle(String title);
}
