package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.model.Loan;
import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.LoanRepository;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;


    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    public Loan findByIdNumber(Long idNumber) {
        return loanRepository.findByIdNumber(idNumber);
    }

    public int calculateCreditScore(Long idNumber) {

        /*We're assuming we've a credit score service and calculating score according to some rules
         * which are ->
         * if last digit of the ID number is an odd number, assume it's an incorrect value
         * if it's an even number we'll consider the following rules */
        //   int lastDigit = (int) Math.abs(userRegistrationDto.getIdNumber() % 10);
        int lastDigit = (int) Math.abs(idNumber % 10);
        int creditScore;
        switch (lastDigit) {
            case 2:
                creditScore = 550;
                break;
            case 4:
                creditScore = 1000;
                break;
            case 6:
                creditScore = 400;
                break;
            case 8:
                creditScore = 900;
                break;
            case 0:
                creditScore = 2000;
                break;
            default:
                creditScore = 0;
        }
        return creditScore;
    }


    public Loan calculateLoanAmount(Long idNumber) {
        int loanLimitMultiplier = 4;
        int creditScore = calculateCreditScore(idNumber);
        Loan loan =loanRepository.findByIdNumber(idNumber) ;
        User user = userRepository.findByIdNumber(idNumber);

        if (creditScore == 0) {
            loan.setLoanAmount(-1);
        } else if (creditScore < 500) {
            loan.setLoanAmount(0);
        } else if (creditScore < 1000) {
            if (user.getMonthlyIncome() < 5000) {
                loan.setLoanAmount(10.000);
            } else {
                loan.setLoanAmount(20.000);
            }
        } else {
            loan.setLoanAmount(user.getMonthlyIncome() * loanLimitMultiplier);
        }
        loanRepository.save(loan);
        user.setLoan(loan);
        return loan;
    }

    public Loan checkLoanStatus(Loan loan) {
        double loanAmount = loan.getLoanAmount();
        if (loanAmount == -1) {
            loan.setLoanStatus("-1");
        } else if (loanAmount == 0) {
            loan.setLoanStatus("Rejected");
        } else {
            loan.setLoanStatus("Approved");
        }
        loanRepository.save(loan);
        return loan;
    }

    @Override
    public Loan loanAmountAndStatusCalculation(Long idNumber) {
        return checkLoanStatus(calculateLoanAmount(idNumber));
    }

}
