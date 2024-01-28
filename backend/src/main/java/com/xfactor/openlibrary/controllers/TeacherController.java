package com.xfactor.openlibrary.controllers;

import java.util.*;
import java.util.Optional;

//import javax.validation.constraints.Past;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.xfactor.openlibrary.domain.Teacher;

import com.xfactor.openlibrary.Repositries.TeacherRepository;

@RestController
@RequestMapping("teacher")

public class TeacherController {
    
    private TeacherRepository teacherRepository;
    
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/saveTeacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        if (teacher.getId() == null) {
            Teacher teacher1 = teacherRepository.save(teacher);
            return teacher1;
        }
        return null;

    }

    @PutMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        if (teacher.getId() != null) {
            Teacher teacher2 = teacherRepository.save(teacher);
            return teacher2;
        }
        return null;

    }
    @GetMapping("/getALl")
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Teacher findById(@PathVariable Long id){
        Optional<Teacher> optionalOfAuthor = teacherRepository.findById(id);
        if(optionalOfAuthor.isPresent()){
            return optionalOfAuthor.get();
        }
        return null;

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        teacherRepository.deleteById(id);
    }
    

}

