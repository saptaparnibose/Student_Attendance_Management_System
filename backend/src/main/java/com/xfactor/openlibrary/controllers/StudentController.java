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

import com.xfactor.openlibrary.domain.Student;

import com.xfactor.openlibrary.Repositries.StudentRepository;

@RestController
@RequestMapping("Student")

public class StudentController {
    //ArrayList<Student> lStudent = new ArrayList<>();
    private StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        if(student.getId() == null){
            studentRepository.save(student);
            return student;
        }
        return null;
    }
    @PutMapping("/updateStudent")
    public Student student(@RequestBody Student student){
        if (student.getId() != null) {
            Student stu = studentRepository.save(student);
            return stu;
        }
        return null;
    }

    @GetMapping("/getALl")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Student findById(@PathVariable Long id) {
        Optional<Student> optionalOfStudent = studentRepository.findById(id);
        if (optionalOfStudent.isPresent()) {
            return optionalOfStudent.get();
        }
        return null;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}



