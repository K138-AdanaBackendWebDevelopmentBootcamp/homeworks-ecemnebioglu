package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.model.Loan;
import dev.patika.loanapplicationsystem.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loanResult/{idNumber}")
    public String loanResult (@PathVariable Long idNumber) {
        Loan loan = loanService.loanAmountAndStatusCalculation(idNumber);
        if(loan.getLoanAmount()==-1){
            return "You entered an inaccurate ID number!";
        }else if(loan.getLoanAmount()==0) {
            return "Your loan application has been " + loan.getLoanStatus();
        }else{
            return "Your loan applicaton has been " + loan.getLoanStatus() + ". Your assigned loan amount is " + loan.getLoanAmount();
        }
    }
    @GetMapping("/loan/{idNumber}")
    public Loan findByIdNumber(@PathVariable Long idNumber){
        return loanService.findByIdNumber(idNumber);
    }


//    @GetMapping
//    public Loan getLoan(@RequestParam Long idNumber){
//        return LoanService.getLoanByIdNumber(idNumber);
//    }
}
