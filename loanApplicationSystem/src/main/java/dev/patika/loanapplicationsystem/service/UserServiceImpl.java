package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getIdNumber(), registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getMobile(), registrationDto.getMonthlyIncome());

        return userRepository.save(user);
    }
}
