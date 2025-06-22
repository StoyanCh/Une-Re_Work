package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Document_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Document_TypesRepository extends JpaRepository<Document_Type, Integer> {

    public List<Document_Type> findAllByOrderByIdDesc();

    public List<Document_Type> findAllByOrderByIdAsc();

    public Document_Type findAllByOrderByIdDesc(Integer documentTypeId);

    public Document_Type create(Document_Type documentType);

    public Document_Type update(Document_Type documentType);

    public void delete(Integer documentTypeId);
}
