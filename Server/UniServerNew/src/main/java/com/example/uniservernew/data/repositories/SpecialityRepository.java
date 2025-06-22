package com.example.uniservernew.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<SpecialityRepository, Integer> {
    public SpecialityRepository findByName(String name);

    public Optional<SpecialityRepository> findById(Integer id);

    public SpecialityRepository save(SpecialityRepository speciality);

    public SpecialityRepository update(SpecialityRepository speciality);

    public void delete(SpecialityRepository speciality);

    public List<SpecialityRepository> findAllByStudentDepartment(String department);
}
