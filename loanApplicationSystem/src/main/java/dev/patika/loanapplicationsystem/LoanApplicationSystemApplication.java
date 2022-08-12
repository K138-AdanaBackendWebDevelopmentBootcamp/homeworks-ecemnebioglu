package dev.patika.loanapplicationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LoanApplicationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplicationSystemApplication.class, args);
    }

}
