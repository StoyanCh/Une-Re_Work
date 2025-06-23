package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

    public Speciality findByspecialityName(String specialityName);

    public List<Speciality> findAllByOrderBySpecialityNameAsc();

    public List<Speciality> findAllByOrderBySpecialityNameDesc();
}
