package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.model.Loan;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {
    Loan loanAmountAndStatusCalculation(Long idNumber);
    Loan findByIdNumber(Long idNumber);

}
