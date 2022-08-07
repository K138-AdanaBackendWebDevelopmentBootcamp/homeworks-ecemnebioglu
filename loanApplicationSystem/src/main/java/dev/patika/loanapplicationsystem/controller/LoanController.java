package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private LoanService loanService;
}
