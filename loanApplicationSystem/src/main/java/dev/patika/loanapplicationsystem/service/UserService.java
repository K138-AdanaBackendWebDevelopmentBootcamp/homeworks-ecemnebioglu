package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService   {



    void save(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

    Optional<User> findByIdNumber(Long idNumber);

    User createUser(User newUser);

    User updateUser(Long idNumber, User newUser);

    void deleteByIdNumber(Long idNumber);
}
