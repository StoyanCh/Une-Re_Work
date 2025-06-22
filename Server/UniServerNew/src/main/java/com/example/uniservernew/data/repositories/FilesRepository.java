package com.example.uniservernew.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilesRepository extends JpaRepository<FilesRepository, String> {

    public FilesRepository findByFileName(String fileName);

    public List<FilesRepository> findByUploadedBy(String uploadedBy);

    public FilesRepository findByFileType(String fileType);

    public FilesRepository create(FilesRepository files);

    public FilesRepository update(FilesRepository files);

    public FilesRepository deleteByFileID(Integer fileID);




}
