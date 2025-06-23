package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.File_Type;
import com.example.uniservernew.data.entities.Files;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface FilesRepository extends JpaRepository<Files, String> {
    public Files findByfileTitle(String fileTitle);

    public List<Files> findByUploaderUserFirstName(String userFirstName);

    public List<Files> findByUploaderUserLastName(String userLastName);

    List<Files> findByUploadedDateGreaterThan(Date uploadedDateIsGreaterThan);

    List<Files> findByUploadedDateLessThan(Date uploadedDateIsLessThan);

    List<Files> findByfileType(Files fileType);
}
