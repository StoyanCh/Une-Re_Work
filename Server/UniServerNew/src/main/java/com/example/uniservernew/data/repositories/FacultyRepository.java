package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    public Faculty findByName(String name);

    public Faculty findById(int id);

    public List<Faculty> findAllByOrderByNameAsc();

    public List<Faculty> findAllByOrderByNameDesc();

    public Faculty create(Faculty faculty);

    public Faculty update(Faculty faculty);

    public Faculty deleteById(int id);
}
