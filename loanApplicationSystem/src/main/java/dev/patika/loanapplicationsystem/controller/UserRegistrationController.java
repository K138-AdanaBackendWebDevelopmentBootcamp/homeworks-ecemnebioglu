package dev.patika.loanapplicationsystem.controller;

import dev.patika.loanapplicationsystem.dto.LoanDto;
import dev.patika.loanapplicationsystem.dto.UserRegistrationDto;
import dev.patika.loanapplicationsystem.service.LoanService;
import dev.patika.loanapplicationsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/application")

public class UserRegistrationController {

    private final UserService userService;
    private final LoanService loanService;

    public UserRegistrationController(UserService userService, LoanService loanService) {
        this.userService = userService;
        this.loanService = loanService;
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

    @GetMapping("/result")
    public String showResult(@ModelAttribute("loan") LoanDto loanDto){
        loanService.findByIdNumber(loanDto.getLoanId());
        return "result";
    }

//    @PostMapping
//    public String loanResult(@ModelAttribute("user")UserRegistrationDto registrationDto){
//        //for taking application from user
//        userService.findByIdNumber(idNumber);
//
//        return "redirect:/loan?success";
//    }

}
