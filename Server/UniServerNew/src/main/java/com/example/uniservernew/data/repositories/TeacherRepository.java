package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
}
