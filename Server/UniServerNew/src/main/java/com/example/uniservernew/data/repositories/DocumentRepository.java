package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    public Document findById(String id);

    public Document findByDocumentTitle(String documentTitle);

    public List<Document> findByDocumentPublisheDate(Date documentPublisheDate);

    public List<Document> findByDocumentStatus(String documentStatus);

    public Document create(Document document);

    public Document update(Document document);

    public void delete(Document document);
}
