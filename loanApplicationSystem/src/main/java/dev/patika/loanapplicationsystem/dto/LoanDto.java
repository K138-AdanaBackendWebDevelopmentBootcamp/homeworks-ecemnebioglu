package dev.patika.loanapplicationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    private Long loanId;
    private double loanAmount;
    private String loanStatus;
    private Long idNumber;
    private double monthlyIncome;

    public LoanDto(Long idNumber, double monthlyIncome) {
        this.idNumber = idNumber;
        this.monthlyIncome = monthlyIncome;
    }
}
