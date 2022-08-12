package dev.patika.loanapplicationsystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
