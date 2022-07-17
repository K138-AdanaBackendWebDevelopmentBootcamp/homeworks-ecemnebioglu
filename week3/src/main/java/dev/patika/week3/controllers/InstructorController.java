package dev.patika.week3.controllers;

import dev.patika.week3.models.Instructor;
import dev.patika.week3.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    //for searching instructor list
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.findAllInstructors();
    }

    //for searcing instructor by id
    @GetMapping("/instructors/id")
    public Instructor getInstructor(@RequestParam int id) {
        return instructorService.getInstructorById(id);
    }

    //for saving isntructor by name
    @PostMapping("/instructors/save/{name}")
    public Instructor saveInstructorByName(@RequestBody String name) {
        return instructorService.saveInstructorByName(name);
    }

    //for updating instructor by name
    @PutMapping("/instructors/update/{name}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody String name) {
        return new ResponseEntity<>(instructorService.updateInstructorByName(name), HttpStatus.OK);
    }

    //for deleting instructor by id
    @DeleteMapping("/instructors/delete/{id}")
    public String deleteInstructorById(@PathVariable int id) {
        instructorService.deleteInstructorById(id);
        return "Deleted!";
    }

    //for deleting instructor by name
    @DeleteMapping("/instructor/delete/{name}")
    public String deleteInstructorByName(@PathVariable String name){
        instructorService.deleteInstructorByName(name);
        return "Deleted!";
    }
}

