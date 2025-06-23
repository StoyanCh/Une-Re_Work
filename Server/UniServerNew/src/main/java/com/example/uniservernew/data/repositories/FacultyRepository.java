package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    public Faculty findByfacultyName(String facultyName);

    public List<Faculty> findAllByOrderByFacultyNameAsc();

    public List<Faculty> findAllByOrderByFacultyNameDesc();
}
