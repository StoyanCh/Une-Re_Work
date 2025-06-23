package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Document;
import com.example.uniservernew.data.entities.Document_Type;
import com.example.uniservernew.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

   public List<Document> findByUploadedDateBetween(Date uploadedDateAfter, Date uploadedDateBefore);

    List<Document> findByUploader(Users uploader);

    List<Document> findDocumentByDocumentTypes(Document_Type documentTypes);
}