package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.model.Loan;
import dev.patika.loanapplicationsystem.service.LoanServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Loan API documentation" )
public class LoanController {
    @Autowired
    private LoanServiceImpl loanService;

    @GetMapping("/loanResult/{idNumber}")
    @ApiOperation(value = "Loan calculation method", notes = "Calculates loan amount, and status")
    public Loan loanResult(@PathVariable Long idNumber) {
        return loanService.loanAmountAndStatusCalculation(idNumber);
    }

    @GetMapping("/loan/{idNumber}")
    @ApiOperation(value = "Finding a loan through user ID number")
    public Loan findByIdNumber(@PathVariable Long idNumber) {
        return loanService.findByIdNumber(idNumber);
    }

}
