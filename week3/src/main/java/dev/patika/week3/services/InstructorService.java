package dev.patika.week3.services;

import dev.patika.week3.models.Course;
import dev.patika.week3.models.Instructor;
import dev.patika.week3.models.Student;
import dev.patika.week3.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorService{

    @Autowired
    InstructorRepository instructorRepository;

    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findInstructor(id);
    }

    public Instructor saveInstructorByName(String name) {
        Instructor isInstructorExist = instructorRepository.findInstructorByName(name);
        if(isInstructorExist != null){
            System.out.println("Instructor " + name + " is exist!");
        }
        return instructorRepository.save(getInstructorByName(name));
    }

    private Instructor getInstructorByName(String name) {
        return instructorRepository.findInstructorByName(name);
    }

    public Instructor updateInstructorByName(String name) {
        return instructorRepository.save(instructorRepository.findInstructorByName(name));
    }

    public void deleteInstructorById(int id) {
        instructorRepository.delete(instructorRepository.findInstructor(id));
    }

    public void deleteInstructorByName(String name) {
        instructorRepository.delete(instructorRepository.findInstructorByName(name));
    }
}
