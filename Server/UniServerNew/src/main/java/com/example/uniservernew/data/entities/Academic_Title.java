package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "academic_titles")
public class Academic_Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int academicTitleId;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String academicTitleName;

    @Column
    public int titlePriority;

    public int getAcademicTitleId() {
        return academicTitleId;
    }

    public void setAcademicTitleId(int academicTitleId) {
        this.academicTitleId = academicTitleId;
    }

    public String getAcademicTitleName() {
        return academicTitleName;
    }

    public void setAcademicTitleName(String academicTitleName) {
        this.academicTitleName = academicTitleName;
    }

    public int getTitlePriority() {
        return titlePriority;
    }

    public void setTitlePriority(int titlePriority) {
        this.titlePriority = titlePriority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Academic_Title that = (Academic_Title) o;
        return academicTitleId == that.academicTitleId && titlePriority == that.titlePriority && Objects.equals(academicTitleName, that.academicTitleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academicTitleId, academicTitleName, titlePriority);
    }
}
