package com.xfactor.openlibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column
    private String subjectCode;
    @Column
    private String subjectName;
    
    public Long getsubjectId() {
        return subjectId;
    }
    public void setsubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    public String getsubjectCode() {
        return subjectCode;
    }
    public void setsubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    public String getsubjectName() {
        return subjectName;
    }
    public void setStudentId(String subjectName) {
        this.subjectName = subjectName;
    }
    
}
