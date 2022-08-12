package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoanService loanService;

    public UserServiceImpl(UserRepository userRepository, LoanService loanService) {
        this.userRepository = userRepository;
        this.loanService = loanService;
    }

    @Override
    public void save(UserRegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getIdNumber(),
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getMobile(),
                registrationDto.getMonthlyIncome());
        userRepository.save(user);
        loanService.loanAmountAndStatusCalculation(registrationDto.getIdNumber());
    }

    @Override
    public List<User> getAllUsers(Optional<Long>id) {
        if(id.isPresent()){
            return userRepository.findById(id);
        } else return userRepository.findAll();
    }

    @Override
    public User findByIdNumber(Long idNumber) {
        return userRepository.findByIdNumber(idNumber);
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }
    //add exception(for not letting id)


    @Override
    public String updateUser(Long idNumber, User newUser) {
        User user = userRepository.findByIdNumber(idNumber);
        if (user != null) {
            user.setIdNumber(idNumber);
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            user.setMobile(newUser.getMobile());
            user.setMonthlyIncome(newUser.getMonthlyIncome());
            userRepository.save(user);
            return "User with " + idNumber + " updated!";
        }
        return "User with " + idNumber + " doesn't exist!";
    }

    @Override
    public String deleteByIdNumber(Long idNumber) {
        User foundUser = userRepository.findByIdNumber(idNumber);
        if (foundUser != null) {
            userRepository.deleteByIdNumber(idNumber);
            return "User deleted!";
        } else return "User not found";
    }
}
