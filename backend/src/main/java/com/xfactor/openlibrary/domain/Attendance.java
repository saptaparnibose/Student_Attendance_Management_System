package com.xfactor.openlibrary.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column
    private String studentName;
    @Column
    private int attended;
    @Column
    private int total;
    @Column
    private Date date;
    public Long getId() {
        return studentId;
    }
    public void setId(Long id) {
        this.studentId = id;
    }
    public String getName() {
        return studentName;
    }
    public void setName(String studentName) {
        this.studentName = studentName;
    }
    public int getAttended() {
        return attended;
    }
    public void setAttended(int attended) {
        this.attended = attended;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
}
