package dev.patika.loanapplicationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class UserRegistrationDto {

    private Long idNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private double monthlyIncome;


}
