package com.ivan.basicsecurityproject.controllers;

import com.ivan.basicsecurityproject.models.Loans;
import com.ivan.basicsecurityproject.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private final LoanRepository loanRepository;

    @Autowired
    public LoansController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

}
