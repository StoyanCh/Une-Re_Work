package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Faculties;
import com.example.uniservernew.data.entities.Topic_Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultiesRepository extends JpaRepository<Faculties, Integer> {

    Optional<Faculties> findByFacultyName(String FucultyName); // или каквото е името на колоната

}
