package com.xfactor.openlibrary.controllers;
import java.util.*;

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

import com.xfactor.openlibrary.domain.Branch;
import com.xfactor.openlibrary.Repositries.BranchRepository;

@RestController
@RequestMapping("branch")

public class BranchController {
    private BranchRepository branchRepository;
    
    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @PostMapping("/saveBranch")
    public Branch saveBranch(@RequestBody Branch branch) {
        if (branch.getId() == null) {
            Branch branch1 = branchRepository.save(branch);
            return branch1;
        }
        return null;

    }

    @PutMapping("/updateBranch")
    public Branch updateBranch(@RequestBody Branch branch) {
        if (branch.getId() != null) {
            Branch branch2 = branchRepository.save(branch);
            return branch2;
        }
        return null;

    }
    @GetMapping("/getALl")
    public List<Branch> getAllBranch(){
        return branchRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Branch findById(@PathVariable Long id){
        Optional<Branch> optionalOfbranch = branchRepository.findById(id);
        if(optionalOfbranch.isPresent()){
            return optionalOfbranch.get();
        }
        return null;

    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        branchRepository.deleteById(id);
    }
}
