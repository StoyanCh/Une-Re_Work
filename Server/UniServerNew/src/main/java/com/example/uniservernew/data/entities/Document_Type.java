package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "document_types")
public class Document_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentTypeId;

    @Column(nullable = false, updatable = false)
    public String documentType;

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Document_Type that = (Document_Type) o;
        return documentTypeId == that.documentTypeId && Objects.equals(documentType, that.documentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentTypeId, documentType);
    }
}
