package dev.patika.week3.services;

import dev.patika.week3.models.Course;
import dev.patika.week3.models.Student;

import java.util.List;

public interface BaseService <T>{
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteByObject(T object);
    void deleteById(int id);
    T update(T object);


    List<Course> getstudentCourseList(Student student);
}
