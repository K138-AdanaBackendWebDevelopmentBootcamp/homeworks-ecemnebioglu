package dev.patika.week3.services;

import dev.patika.week3.models.Course;
import dev.patika.week3.models.Student;
import dev.patika.week3.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(int id) {
        return courseRepository.findCourse(id);
    }

    public Course getCourseByCourseCode(String courseCode){
        return courseRepository.findCourseByCourseCode(courseCode);
    }

    public Course saveCourse(Course course) {
        Course isCourseExist = courseRepository.findCourseByCourseCode(course.getCourseCode());
        if (isCourseExist != null) {
            System.out.println("Course alredy exist with Course Code : " + course.getCourseCode() + " " + course.getCourseName());
        }
        return courseRepository.save(course);
    }

    public Course saveCourseByCourseCode(String courseCode) {
        Course isCourseExist = courseRepository.findCourseByCourseCode(courseCode);
        if(isCourseExist != null){
            System.out.println("Course alredy exist with Course Code : " + courseCode);
        }

        return courseRepository.save(getCourseByCourseCode(courseCode));
    }

    public Course updateByCourseCode(String courseCode) {
        return courseRepository.save(courseRepository.findCourseByCourseCode(courseCode));
    }

    public void deleteByCourseCode(String courseCode) {
        courseRepository.deleteByCourseCode(courseCode);
    }

    public void deleteCourseById(int id) {
        courseRepository.delete(courseRepository.findCourse(id));
    }

}
