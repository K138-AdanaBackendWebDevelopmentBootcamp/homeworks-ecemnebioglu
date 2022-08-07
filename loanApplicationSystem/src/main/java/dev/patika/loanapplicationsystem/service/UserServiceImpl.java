package dev.patika.loanapplicationsystem.service;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getIdNumber(), registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getMobile(), registrationDto.getMonthlyIncome());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByIdNumber(Long idNumber) {
        return userRepository.findByIdNumber(idNumber);
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }
    //add exception(for not letting id)


    @Override
    public User updateUser(Long idNumber, User newUser) {
        Optional<User> user = userRepository.findByIdNumber(idNumber);
        if (user.isPresent()){
            User foundUser = user.get();
            foundUser.setIdNumber(idNumber);
            foundUser.setFirstName(newUser.getFirstName());
            foundUser.setLastName(newUser.getLastName());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setMobile(newUser.getMobile());
            foundUser.setMonthlyIncome(newUser.getMonthlyIncome());
            userRepository.save(foundUser);
            return foundUser;
        }
        return null;
        //for now will return null
    }

    @Override
    public String deleteByIdNumber(Long idNumber) {
        Optional<User> foundUser= userRepository.findByIdNumber(idNumber);
        if(foundUser.isPresent()){
            userRepository.deleteByIdNumber(idNumber);
            return "User deleted!";
        }else return "User not found";
    }


}
