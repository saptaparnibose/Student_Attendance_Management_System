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
    @GetMapping("/findTotal")
    public long findTotal(){
        return studentRepository.count();
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
    @GetMapping("findByName/{name}")
    public List<Student> findByName(@PathVariable String name) {
        List<Student> stu = studentRepository.findByName(name);
        return stu;
    }
    @GetMapping("findByDepartment/{department}")
    public List<Student> findByDepartment(@PathVariable String department) {
        List<Student> stu = studentRepository.findByDepartment(department);
        return stu;
    }
    @GetMapping("findByRollNumber/{rollNumber}")
    public List<Student> findByRollNumber(@PathVariable String rollNumber) {
        List<Student> stu = studentRepository.findByRollNumber(rollNumber);
        return stu;
    }
    @GetMapping("findByBirthDate/{birthDate}")
    public List<Student> findByBirthDate(@PathVariable String birthDate) {
        List<Student> stu = studentRepository.findByBirthDate(birthDate);
        return stu;
    }
    @GetMapping("findByMobileNumber/{mobileNumber}")
    public List<Student> findByMobileNumber(@PathVariable String mobileNumber) {
        List<Student> stu = studentRepository.findByMobileNumber(mobileNumber);
        return stu;
    }
}



