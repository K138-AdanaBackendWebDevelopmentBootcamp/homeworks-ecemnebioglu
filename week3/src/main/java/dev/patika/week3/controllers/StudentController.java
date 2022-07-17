package dev.patika.week3.controllers;

import dev.patika.week3.models.Course;
import dev.patika.week3.models.Student;
import dev.patika.week3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    //2nd way for searching all student list
    @GetMapping("/students")
    public List<Student>getAllStudents2(){
        return studentService.findAllStudents();
    }

    //for searching student by id
    @GetMapping("/students/id")
    public Student getStudent(@RequestParam int id){
        return studentService.getStudent(id);
    }

    //for searching student by name
    @GetMapping("/students/get/{name}")
    public Student getStudentByName(@RequestBody String name){
        return studentService.getStudentByName(name);
    }

    //for saving students by name
    @PostMapping("/students/save/{name}")
    public Student saveStudentByName(@RequestBody String name){
        return studentService.saveStudentByName(name);
    }

    //for updating student by name
    @PutMapping("/students/update/{name}")
    public ResponseEntity<Student> updateStudent(@RequestBody String name){
        return new ResponseEntity<>(studentService.updateStudentByName(name), HttpStatus.OK);
    }

    //for deleting students with id
    @DeleteMapping("/student/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "Deleted!";
    }

    @DeleteMapping("/student/delete/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteByName(name);
        return "Deleted!";
    }
}
