package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //for turning user list or one user by user id
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //finding user by id number
    @GetMapping("/{idNumber}")
    public Optional<User> getOneUser(@PathVariable Long idNumber) {
        return userService.findByIdNumber(idNumber);
    }

    //for saving users via rest
    @PostMapping
    public User saveUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/{idNumber}")
    public User updateUser(@PathVariable Long idNumber, @RequestBody User newUser) {
        return userService.updateUser(idNumber, newUser);
    }

    @DeleteMapping("/{idNumber}")
    @Transactional
    public String deleteUser(@PathVariable Long idNumber) {
        return userService.deleteByIdNumber(idNumber);
    }


}
