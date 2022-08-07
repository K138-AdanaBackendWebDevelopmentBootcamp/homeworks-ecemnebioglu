package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.service.LoanService;
import dev.patika.loanapplicationsystem.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {
    private LoanService loanService;
    private UserService userService;

    public LoanApplicationController(LoanService loanService, UserService userService) {
        this.loanService = loanService;
        this.userService = userService;
    }


}
