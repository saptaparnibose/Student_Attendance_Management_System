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

import com.xfactor.openlibrary.domain.Admin;

import com.xfactor.openlibrary.Repositries.AdminRepository;

@RestController
@RequestMapping("admin")

public class AdminController {
    //ArrayList<Admin> lAdmin = new ArrayList<>();
    private AdminRepository adminRepository;
    
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @PostMapping("/saveAdmin")
    public Admin saveLoan(@RequestBody Admin admin){
        if(admin.getId() == null){
            adminRepository.save(admin);
            return admin;
        }
        return null;
    }
    @PutMapping("/updateAdmin")
    public Admin admin(@RequestBody Admin admin){
        if (admin.getId() != null) {
            Admin ad = adminRepository.save(admin);
            return ad;
        }
        return null;
    }

    @GetMapping("/getALl")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Admin findById(@PathVariable Long id) {
        Optional<Admin> optionalOfAdmin = adminRepository.findById(id);
        if (optionalOfAdmin.isPresent()) {
            return optionalOfAdmin.get();
        }
        return null;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        adminRepository.deleteById(id);
    }
    
    
}


