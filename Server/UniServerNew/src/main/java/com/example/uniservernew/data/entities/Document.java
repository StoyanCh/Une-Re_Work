package com.example.uniservernew.data.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @Column(updatable = false, nullable = false)
    public String documentTitle;

    @ManyToOne
    @JoinColumn(name = "doc_type")
    private Document_Type documentTypes;

    @Column(nullable = false)
    @CreationTimestamp
    public Date uploadedDate;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private Users uploader;

    @Column(updatable = false,nullable = false)
    private String docPath;

    @ManyToMany
    @JoinTable(
            name = "document_files",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private Set<Files> files = new HashSet<>();

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public Document_Type getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Document_Type documentTypes) {
        this.documentTypes = documentTypes;
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

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public Set<Files> getFiles() {
        return files;
    }

    public void setFiles(Set<Files> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentId == document.documentId && Objects.equals(documentTitle, document.documentTitle) && Objects.equals(documentTypes, document.documentTypes) && Objects.equals(uploadedDate, document.uploadedDate) && Objects.equals(uploader, document.uploader) && Objects.equals(docPath, document.docPath) && Objects.equals(files, document.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, documentTitle, documentTypes, uploadedDate, uploader, docPath, files);
    }
}
