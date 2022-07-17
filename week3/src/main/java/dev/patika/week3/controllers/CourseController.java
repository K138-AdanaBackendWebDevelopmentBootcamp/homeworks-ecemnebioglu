package dev.patika.week3.controllers;

import dev.patika.week3.models.Course;
import dev.patika.week3.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    //for searching all course list
    @GetMapping("/courses")
    public List<Course>getAllCourses(){
        return courseService.findAllCourses();
    }

    //for searching course by id
    @GetMapping("/courses/id")
    public Course getCourse(@RequestParam int id){
        return courseService.getCourse(id);
    }

    //for searching course by course code
    @GetMapping("/courses/get/{courseCode}")
    public Course getCourseByCourseCode(@RequestBody String courseCode){
        return courseService.getCourseByCourseCode(courseCode);
    }

    //for saving courses
    @PostMapping("/courses")
    public Course saveCourses(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    //for saving courses by course code
    @PostMapping("/courses/save/{courseCode}")
    public Course saveCourseByCourseCode(@RequestBody String courseCode){
        return courseService.saveCourseByCourseCode(courseCode);
    }

    //for updating courses by course code
    @PutMapping("/courses/update/{courseCode}")
    public ResponseEntity<Course> updateCourse(@RequestBody String courseCode){
        return new ResponseEntity<>(courseService.updateByCourseCode(courseCode), HttpStatus.OK );

    }

    //for deleting courses by id
    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteCourseById(id);
        return "Deleted!";
    }

    //for deleting courses by course code
    @DeleteMapping("/courses/delete/{courseCode}")
    public String deleteCourseByCourseCode(@PathVariable String courseCode){
        courseService.deleteByCourseCode(courseCode);
        return "Deleted!";
    }

}
