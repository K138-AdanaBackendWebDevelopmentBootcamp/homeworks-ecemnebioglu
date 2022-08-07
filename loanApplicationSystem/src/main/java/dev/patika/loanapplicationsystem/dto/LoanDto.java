package dev.patika.loanapplicationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    private Long loanId;
    private double loanAmount;
    private String loanStatus;
    private Long idNumber;
    private double monthlyIncome;

    public double creditScore(@RequestParam("idNumber") Long idNumber){
        int creditScore = 0;
        int lastDigit = (int) Math.abs(idNumber%10);
        switch (lastDigit){
            case 2:
                creditScore =550;
                break;
            case 4:
                creditScore=1000;
                break;
            case 6:
                creditScore=400;
                break;
            case 8:
                creditScore=900;
                break;
            case 0:
                creditScore=2000;
                break;
        }
        return creditScore;
    }



}
