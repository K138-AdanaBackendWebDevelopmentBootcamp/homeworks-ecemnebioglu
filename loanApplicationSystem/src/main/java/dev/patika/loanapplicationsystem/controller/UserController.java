package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.service.LoanService;
import dev.patika.loanapplicationsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(value = "User API documentation")
public class UserController {

    private final UserService userService;
    private final LoanService loanService;

    public UserController(UserService userService, LoanService loanService) {
        this.userService = userService;
        this.loanService = loanService;
    }


    //for turning user list or one user by user id
    @GetMapping
    @ApiOperation(value = "Viewing user list")
    public List<User> getAllUsers(@RequestParam Optional<Long> id) {
        return userService.getAllUsers(id);
    }

    //finding user by id number
    @GetMapping("/{idNumber}")
    @ApiOperation(value = "Finding user throught ID number")
    public User getOneUser(@PathVariable Long idNumber) {
        return userService.findByIdNumber(idNumber);
    }

    //for saving users via rest
    @PostMapping
    @ApiOperation(value = "Saving user")
    public User saveUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return newUser;
    }

    @PutMapping("/{idNumber}")
    @ApiOperation(value = "Updating user")
    public String updateUser(@PathVariable Long idNumber, @RequestBody User newUser) {
        return userService.updateUser(idNumber, newUser);
    }

    @DeleteMapping("/{idNumber}")
    @Transactional
    @ApiOperation(value = "Deleting user")
    public String deleteUser(@PathVariable Long idNumber) {
        return userService.deleteByIdNumber(idNumber);
    }


}
