package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Document_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Document_TypesRepository extends JpaRepository<Document_Type, Integer> {

    public Document_Type findByDocumentType(String documentType);
    public List<Document_Type> findAllByOrderByDocumentTypeIdAsc();

    public List<Document_Type> findAllByOrderByDocumentTypeIdDesc();
}
