package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.yaml.snakeyaml.events.Event;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileId;

    @Column(updatable = false, nullable = false)
    public String fileTitle;

    @Column(updatable = false, nullable = false)
    public String filePath;

    @ManyToOne
    @JoinColumn(name = "file_type")
    private Files fileType;

    @Column(nullable = false)
    @CreationTimestamp
    public Date uploadedDate;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private Users uploader;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Files getFileType() {
        return fileType;
    }

    public void setFileType(Files fileType) {
        this.fileType = fileType;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public Users getUploader() {
        return uploader;
    }

    public void setUploader(Users uploader) {
        this.uploader = uploader;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Files files = (Files) o;
        return fileId == files.fileId && Objects.equals(fileTitle, files.fileTitle) && Objects.equals(filePath, files.filePath) && Objects.equals(fileType, files.fileType) && Objects.equals(uploadedDate, files.uploadedDate) && Objects.equals(uploader, files.uploader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileTitle, filePath, fileType, uploadedDate, uploader);
    }
}
