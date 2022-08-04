package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService   {

    User save(UserRegistrationDto registrationDto);
}
