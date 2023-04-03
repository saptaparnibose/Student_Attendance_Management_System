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

import com.xfactor.openlibrary.domain.Loan;

import com.xfactor.openlibrary.Repositries.LoanRepository;

@RestController
@RequestMapping("loan")

public class LoanController {
    //ArrayList<Loan> lLoan = new ArrayList<>();
    private LoanRepository loanRepository;
    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan loan){
        if(loan.getId() == null){
            loanRepository.save(loan);
            return loan;
        }
        return null;
    }
    @PutMapping("/updateLoan")
    public Loan loan(@RequestBody Loan loan){
        if (loan.getId() != null) {
            Loan l = loanRepository.save(loan);
            return l;
        }
        return null;
    }

    @GetMapping("/getALl")
    public List<Loan> getAllLoan(){
        return loanRepository.findAll();
    }
    @GetMapping("findById/{id}")
    public Loan findById(@PathVariable Long id) {
        Optional<Loan> optionalOfLoan = loanRepository.findById(id);
        if (optionalOfLoan.isPresent()) {
            return optionalOfLoan.get();
        }
        return null;
    }
    @GetMapping("/findTotal")
    public long findTotal(){
        return loanRepository.count();
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        loanRepository.deleteById(id);
    }
    @GetMapping("findByBookId/{bookId}")
    public List<Loan> findByBookId(@PathVariable int bookId) {
        List<Loan> l = loanRepository.findByBookId(bookId);
        return l;
    }
    @GetMapping("findByStudentId/{studentId}")
    public List<Loan> findByStudentId(@PathVariable int studentId) {
        List<Loan> l = loanRepository.findByStudentId(studentId);
        return l;
    }
    @GetMapping("findByCheckoutDate/{checkoutDate}")
    public List<Loan> findByCheckoutDate(@PathVariable String checkoutDate) {
        List<Loan> l = loanRepository.findByCheckoutDate(checkoutDate);
        return l;
    }
    @GetMapping("findByDueDate/{dueDate}")
    public List<Loan> findByDueDate(@PathVariable String dueDate) {
        List<Loan> l = loanRepository.findByDueDate(dueDate);
        return l;
    }
    @GetMapping("findByReturnDate/{returnDate}")
    public List<Loan> findByReturnDate(@PathVariable String returnDate) {
        List<Loan> l = loanRepository.findByReturnDate(returnDate);
        return l;
    }
}

