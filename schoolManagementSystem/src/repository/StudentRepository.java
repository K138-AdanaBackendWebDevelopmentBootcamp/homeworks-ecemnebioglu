package repository;

import models.Course;
import models.Student;

import java.util.List;

public interface StudentRepository {
    void deleteStudentWithId(int id);

    List<Course> getstudentCourseList (Student student);
}
