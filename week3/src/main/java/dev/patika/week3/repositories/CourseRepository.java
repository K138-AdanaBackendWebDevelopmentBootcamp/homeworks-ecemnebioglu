package dev.patika.week3.repositories;

import dev.patika.week3.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
   @Query("from Course c WHERE c.id=?1")
    Course findCourse(int id);

   Course findCourseByCourseCode(String courseCode);

    void deleteByCourseCode(String courseCode);
}
