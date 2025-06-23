package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.File_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface File_TypeRepository extends JpaRepository<File_Type, String> {

    public File_Type findByFileType(String file_TypeName);
}
