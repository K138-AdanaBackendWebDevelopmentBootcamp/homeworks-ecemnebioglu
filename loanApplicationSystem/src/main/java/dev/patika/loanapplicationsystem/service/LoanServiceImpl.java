package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.model.Loan;
import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.LoanRepository;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {
   @Autowired
    private  LoanRepository loanRepository;
   @Autowired
    private UserRepository userRepository;

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


    public double calculateLoanAmount(Long idNumber, int creditScore, Loan loan) {
        int loanLimitMultiplier = 4;
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
        return loan.getLoanAmount();
    }

    public void checkLoanStatus(double loanAmount, Loan loan) {
        if (loanAmount == -1) {
            loan.setLoanStatus("Inaccurate ID number!");
        } else if (loanAmount == 0) {
            loan.setLoanStatus("Rejected");
        } else {
            loan.setLoanStatus("Approved");
        }
    }

    @Override
    public Loan loanAmountAndStatusCalculation(Long idNumber) {
        if (userRepository.findByIdNumber(idNumber).getLoan()==null){
            Loan loan = new Loan();
            loan.setLoanAmount(calculateLoanAmount(idNumber, calculateCreditScore(idNumber), loan));
            checkLoanStatus(loan.getLoanAmount(), loan);
            userRepository.findByIdNumber(idNumber).setLoan(loan);
            loan.setUser(userRepository.findByIdNumber(idNumber));
            loan.setUserIdNumber(idNumber);
            return loan;
        }else return userRepository.findByIdNumber(idNumber).getLoan();

    }

    @Override
    public Loan findByIdNumber(Long idNumber){
        return loanRepository.findByUserIdNumber(idNumber);

    }

}
