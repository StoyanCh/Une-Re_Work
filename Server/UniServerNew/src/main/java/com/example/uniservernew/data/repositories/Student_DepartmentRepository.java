package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Student_Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Student_DepartmentRepository extends JpaRepository<Student_Department, Integer> {

    Optional<Student_Department> findByStudentDepartmentName(String studentDepartmentName);

    List<Student_Department> findAllByOrderByStudentDepartmentNameAsc();

    List<Student_Department> findAllByOrderByStudentDepartmentNameDesc();

    List<Student_Department> findByFaculty_FacultyName(String faculty_FacultyName);

}