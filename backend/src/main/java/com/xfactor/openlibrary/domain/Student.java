package com.xfactor.openlibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int rollNo;
    @Column
    private String studentName;
    @Column
    private int batch;
    @Column
    private int semester;
    @Column
    private int branchId;
    //@ManyToOne
    //@JoinColumn(name = "branchId",insertable=false, updatable=false)
    //private Branch branch;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRollNumber() {
        return rollNo;
    }
    public void setRollNumber(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return studentName;
    }
    public void setName(String studentName) {
        this.studentName = studentName;
    }
    public int getBatch() {
        return batch;
    }
    public void setBatch(int batch) {
        this.batch = batch;
    }
    
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public int getbranchId() {
        return branchId;
    }

    public void setbranchId(int branchId) {
        this.branchId = branchId;
    }
}