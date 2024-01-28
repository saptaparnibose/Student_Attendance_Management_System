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

import com.xfactor.openlibrary.domain.Subject;

import com.xfactor.openlibrary.Repositries.SubjectRepository;

@RestController
@RequestMapping("subject")

public class SubjectController {
    private SubjectRepository subjectRepository;
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @PostMapping("/saveSubject")
    public Subject saveSubject(@RequestBody Subject subject){
        if(subject.getsubjectId() == null){
            subjectRepository.save(subject);
            return subject;
        }
        return null;
    }
    @PutMapping("/updateSubject")
    public Subject subject(@RequestBody Subject subject){
        if (subject.getsubjectId() != null) {
            Subject l = subjectRepository.save(subject);
            return l;
        }
        return null;
    }

    @GetMapping("/getALl")
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Subject findById(@PathVariable Long id) {
        Optional<Subject> optionalOfSubject = subjectRepository.findById(id);
        if (optionalOfSubject.isPresent()) {
            return optionalOfSubject.get();
        }
        return null;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        subjectRepository.deleteById(id);
    }
    
}

