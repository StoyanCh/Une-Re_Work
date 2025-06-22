package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.File_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface File_TypeRepository extends JpaRepository<File_Type, String> {
    public List<File_Type> findByFile_TypeName(String file_TypeName);

    public File_Type findFile_TypeById(String file_TypeId);

    public File_Type createFile_Type(String file_TypeName);

    public File_Type updateFile_Type(String file_TypeName);

    public void deleteFile_Type(String file_TypeName);
}
