package dev.patika.week3.services;

import dev.patika.week3.models.Course;
import dev.patika.week3.models.Student;
import dev.patika.week3.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        return studentRepository.findStudent(id);
    }

    public Student getStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }


    public Student saveStudentByName(String name) {
        Student isStudentExist = studentRepository.findStudentByName(name);
        if(isStudentExist !=null){
            System.out.println("Student " + name + " is exist!");
        }
        return studentRepository.save(getStudentByName(name));
    }

    public Student updateStudentByName(String name) {
       return studentRepository.save(studentRepository.findStudentByName(name));
    }

    public void deleteByName(String name) {
        studentRepository.delete(studentRepository.findStudentByName(name));
    }

    public void deleteStudentById(int id) {
        studentRepository.delete(studentRepository.findStudent(id));
    }
}

