package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "file_types")
public class File_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileTypeId;

    @Column(nullable = false, updatable = false)
    public String fileType;

    public int getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(int fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        File_Type fileTypes = (File_Type) o;
        return fileTypeId == fileTypes.fileTypeId && Objects.equals(fileType, fileTypes.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileTypeId, fileType);
    }
}