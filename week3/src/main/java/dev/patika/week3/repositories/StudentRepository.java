package dev.patika.week3.repositories;

import dev.patika.week3.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("from Student  s WHERE s.id=?1")
    Student findStudent(int id);

    Student findStudentByName(String name);
}
