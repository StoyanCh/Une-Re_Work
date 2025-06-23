package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Student;
import com.example.uniservernew.data.entities.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, StudentId> {

    Optional<Student> findByFacultyNumber(String facultyNumber);

    List<Student> findBySpeciality_SpecialityId(int specialityId);

    List<Student> findByYearOfEnrollingBetween(Date from, Date to);

    Optional<Student> findByStudentEmailAddressUni(String emailUni);

    List<Student> findByStudent_UserLastNameContainingIgnoreCase(String lastName);
}