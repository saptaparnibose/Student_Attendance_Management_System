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

import com.xfactor.openlibrary.domain.Publisher;

import com.xfactor.openlibrary.Repositries.PublisherRepository;

@RestController
@RequestMapping("publisher")

public class PublisherController {
    //ArrayList<Publisher> lPublisher = new ArrayList<>();

    private PublisherRepository publisherRepository;
    

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher){
        if(publisher.getId() == null){
            publisherRepository.save(publisher);
            return publisher;
        }
        return null;
    }
    @PutMapping("/updatePublisher")
    public Publisher publisher(@RequestBody Publisher publisher){
        if (publisher.getId() != null) {
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }
    @GetMapping("/getALl")
    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Publisher findById(@PathVariable Long id) {
        Optional<Publisher> optionalOfPublisher = publisherRepository.findById(id);
        if (optionalOfPublisher.isPresent()) {
            return optionalOfPublisher.get();
        }
        return null;
    }
    @GetMapping("/findTotal")
    public long findTotal(){
        return publisherRepository.count();
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        publisherRepository.deleteById(id);
    }
    @GetMapping("findByName/{name}")
    public List<Publisher> findByName(@PathVariable String name) {
        List<Publisher> pub = publisherRepository.findByName(name);
        return pub;
    } 
    @GetMapping("findByAddress/{address}")
    public List<Publisher> findByAddress(@PathVariable String address) {
        List<Publisher> pub = publisherRepository.findByAddress(address);
        return pub;
    }
    @GetMapping("findByPhone/{phone}")
    public List<Publisher> findByPhone(@PathVariable String phone) {
        List<Publisher> pub = publisherRepository.findByPhone(phone);
        return pub;
    }
    @GetMapping("findByEmail/{email}")
    public List<Publisher> findByEmail(@PathVariable String email) {
        List<Publisher> pub = publisherRepository.findByEmail(email);
        return pub;
    }

}


