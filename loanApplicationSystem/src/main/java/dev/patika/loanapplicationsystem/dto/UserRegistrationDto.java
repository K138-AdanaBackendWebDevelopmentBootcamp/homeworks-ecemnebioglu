package dev.patika.loanapplicationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private Long idNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private double monthlyIncome;


}
