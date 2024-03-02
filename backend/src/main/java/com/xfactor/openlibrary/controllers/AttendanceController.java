package com.xfactor.openlibrary.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
    public Attendance saveAttendance(@RequestBody Attendance attendance){
        if(attendance.getId() == null){
            attendanceRepository.save(attendance);
            return attendance;
        }
        return null;
    }
    @PutMapping("/updateAttendance")
    public Attendance attendance(@RequestBody Attendance attendance){
        if (attendance.getId() != null) {
            Attendance ad = attendanceRepository.save(attendance);
            return ad;
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Attendance> getAllAttendance(){
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

    /*@PostMapping("/markAttendance")
    public String markAttendance(@RequestParam Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        attendance.setPresent(!attendance.isPresent());
        attendanceRepository.save(attendance);
        return "redirect:/";
    }

    @PostMapping("/submitAttendance")
    public String submitAttendance() {
        // Here, you can save the attendance data to a database or perform any necessary actions
        return "redirect:/";
    }*/
}
