package com.xfactor.openlibrary.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.xfactor.openlibrary.domain.Attendance;

import com.xfactor.openlibrary.Repositries.AttendanceRepository;

@RestController
@RequestMapping("attendance")

public class AttendanceController {

    private AttendanceRepository attendanceRepository;
    

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @PostMapping("/saveAttendance")
    public Attendance saveAttendance(@RequestBody Attendance publisher){
        if(publisher.getId() == null){
            attendanceRepository.save(publisher);
            return publisher;
        }
        return null;
    }
    @PutMapping("/updateAttendance")
    public Attendance attendance(@RequestBody Attendance attendance){
        if (attendance.getId() != null) {
            Attendance attendance2 = attendanceRepository.save(attendance);
            return attendance2;
        }
        return null;
    }
    @GetMapping("/getALl")
    public List<Attendance> getAllPublisher(){
        return attendanceRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Attendance findById(@PathVariable Long id) {
        Optional<Attendance> optionalOfAttendance = attendanceRepository.findById(id);
        if (optionalOfAttendance.isPresent()) {
            return optionalOfAttendance.get();
        }
        return null;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        attendanceRepository.deleteById(id);
    }

}


