package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application")

public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showApplicationForm(){
        //for showing loan application form
        return "application";
    }

    @PostMapping
    public String loanApplication(@ModelAttribute("user")UserRegistrationDto registrationDto){
        //for taking application from user
        userService.save(registrationDto);
        return "redirect:/application?success";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        //for getting empty object in application form
        return new UserRegistrationDto();
    }

}
