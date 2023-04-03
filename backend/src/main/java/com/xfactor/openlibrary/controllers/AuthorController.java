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

import com.xfactor.openlibrary.domain.Author;

import com.xfactor.openlibrary.Repositries.AuthorRepository;

@RestController
@RequestMapping("author")

public class AuthorController {
    //ArrayList<Author> lAuthor = new ArrayList<>();
    private AuthorRepository authorRepository;
    
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author) {
        if (author.getId() == null) {
            Author author1 = authorRepository.save(author);
            return author1;
        }
        return null;

    }

    @PutMapping("/updateAuthor")
    public Author updateBook(@RequestBody Author author) {
        if (author.getId() != null) {
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;

    }
    @GetMapping("/getALl")
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Author findById(@PathVariable Long id){
        Optional<Author> optionalOfAuthor = authorRepository.findById(id);
        if(optionalOfAuthor.isPresent()){
            return optionalOfAuthor.get();
        }
        return null;

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
    @GetMapping("/findTotal")
    public Long findTotal(){
        return authorRepository.count();
    }
    @GetMapping("findByName/{name}")
    public List<Author> findByName(@PathVariable String name) {
        List<Author> authors = authorRepository.findByName(name);
        return authors;
    }
    @GetMapping("/findByBirthDate/{birthDate}")
    public List<Author> findByBirthDate(@PathVariable String birthDate){
        List<Author> authors = authorRepository.findByBirthDate(birthDate);
        return authors;
    }
    @GetMapping("/findByNationality/{nationality}")
    public List<Author> findByNationality(@PathVariable String nationality){
        List<Author> authors = authorRepository.findByNationality(nationality);
        return authors;
    }

}

