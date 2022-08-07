package dev.patika.loanapplicationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long idNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private double monthlyIncome;
}
